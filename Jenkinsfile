pipeline {
  agent any
  stages {
    stage('build') {
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
        echo "Mail notification"
      }
      post{
        success{
          mail(subject: '[Jenkins][Build success]', body: 'Build success', from: 'fn_souab@esi.dz', to: 'fn_souab@esi.dz')
        }
        failure{
          mail(subject: '[Jenkins][Build failure]', body: 'Build failure', from: 'fn_souab@esi.dz', to: 'fn_souab@esi.dz')
        }
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
            jacoco(buildOverBuild: true, maximumMethodCoverage: '100', minimumClassCoverage: '100', minimumLineCoverage: '100')
          }
        }
      }
    }
    stage('Deployment') {
      steps {
        sh 'gradle uploadArchives'
      }
    }
    stage('Slack Notification') {
      steps {
        slackSend(message: 'Deployment success')
      }
    }
  }
}
