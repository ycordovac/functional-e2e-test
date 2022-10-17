pipeline{

  agent {
    node {
        label 'nodo-java'
    }
  }

  stages {

    stage('Run function testing E2E') {
      steps {
        script {
            sh 'docker run -d --network minikube --network-alias node-chrome -p 4444:4444 selenium/standalone-chrome'
        }
        sh 'mvn clean verify -Dchrome.switches=--headless;'
      }
    }

    stage('Generate Cucumber Report') {
      steps {
        sh 'mvn serenity:aggregate'
      }
    }

  }

  post {
    always {
      sh 'docker logout'
    }
  }

}