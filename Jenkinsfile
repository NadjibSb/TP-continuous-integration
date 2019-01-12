pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        sh 'gradle build'
        sh 'gradle jar'
        sh 'gradle javadoc'
      }
    }
    stage('Mail Notification') {
      steps {
        mail(subject: '[Jenkins][Build]', body: 'Build success', bcc: 'fn_souab@esi.dz')
      }
    }
    stage('Code Analysis') {
      steps {
        withSonarQubeEnv('Sonar-scanner') {
          sh 'sonar-scanner'
        }

        waitForQualityGate true
      }
    }
  }
}