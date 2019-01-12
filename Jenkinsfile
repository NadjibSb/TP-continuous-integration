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
        post() {
          success() {
            mail(subject: '[Jenkins][MatrixCalculator][Build]', body: 'Build success', bcc: 'fn_souab@esi.dz')
          }

          failure() {
            mail(subject: '[Jenkins][MatrixCalculator][Build]', body: 'Build failure', bcc: 'fn_souab@esi.dz')
          }

        }

      }
    }
  }
}