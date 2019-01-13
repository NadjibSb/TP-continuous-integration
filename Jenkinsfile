pipeline {
  agent any
  stages {
    stage('source') {
      steps {
        git(branch: 'master', url: 'git@github.com:NadjibSb/TP-continuous-integration.git')
      }
    }
    stage('build') {
      post {
        failure {
          mail(subject: '[Jenkins][Build failure]', body: "BUILD : ${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}", from: 'fn_souab@esi.dz', to: 'fn_souab@esi.dz')

        }

      }
      steps {
        sh 'gradle build'
        sh 'gradle jar'
        sh 'gradle javadoc'
        archiveArtifacts 'build/libs/*.jar'
        archiveArtifacts 'build/docs/javadoc/'
      }
    }
    stage('Mail Notification') {
      steps {
        mail(subject: '[Jenkins][Build success]', body: "BUILD : ${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}", from: 'fn_souab@esi.dz', to: 'fn_souab@esi.dz')
      }
    }
    stage('Code Analysis') {
      parallel {
        stage('Code Analysis') {
          steps {
            withSonarQubeEnv('sonareqube') {
              sh '/media/nadjib/Data/2CS/Outils/Libraries/sonar-scanner-cli-3.3.0.1492-linux/bin/sonar-scanner'
            }

            waitForQualityGate true
          }
        }
        stage('Test reporting') {
          steps {
            jacoco(buildOverBuild: true)
          }
        }
      }
    }
    stage('Deployment') {
      when {
        not {
          changeRequest target: 'master'
        }

      }
      steps {
        sh 'gradle uploadArchives'
      }
    }
    stage('Slack Notification') {
      when {
        not {
          changeRequest target: 'master'
        }

      }
      steps {
        slackSend(message: "DEPLOYMENT : ${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}")
      }
    }
  }
}