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
    stage('Mail Nootification') {
      steps {
        mail(bcc: 'fn_souab@gmail.dz', subject: '[Jenkins][Build]', body: 'Build success')
      }
    }
  }
}