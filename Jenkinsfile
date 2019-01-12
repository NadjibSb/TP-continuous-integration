pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        sh 'gradle build'
        sh 'gradle jar'
        sh 'gradle javadoc'
        archiveArtifacts 'build/libs/*.jar'
        archiveArtifacts 'build/docs'
      }
    }
    stage('Mail Notification') {
      steps {
        mail(subject: '[Jenkins][Build]', body: 'Build success', from: 'fn_souab@esi.dz', to: 'fn_souab@esi.dz')
      }
    }
    stage('Code Analysis') {
      parallel {
        stage('Code Analysis') {
          steps {
            sh '/media/nadjib/Data/2CS/Outils/Libraries/sonar-scanner-cli-3.3.0.1492-linux/bin/sonar-scanner'
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