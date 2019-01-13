pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh '''gradle build
'''
        sh 'gradle javadoc'
        sh 'gradle jar'
        archiveArtifacts 'build/libs/*.jar'
        archiveArtifacts 'build/docs/javadoc/'
      }
    }
    stage('Mail Notification') {
      steps {
        mail(subject: '[Jenkins][Build success]', body: 'BUILD : ${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\\n More info at: ${env.BUILD_URL}', from: 'fn_souab@esi.dz', to: 'fn_souab@esi.dz')
      }
    }
  }
}