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
        mail(subject: '[Jenkins][Build]', body: 'Build success', from: 'fn_souab@esi.dz', to: 'fn_souab@esi.dz')
      }
    }
    stage('Code Analysis') {
      steps {
        sh 'sonar-scanner'
      }
    }
  }
}