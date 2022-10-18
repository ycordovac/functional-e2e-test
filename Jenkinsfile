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
            sh 'docker stop standalone-chrome'
            sh 'docker rm standalone-chrome'
            sh 'docker run -d --network minikube --network-alias standalone-chrme --name=standalone-chrome -p 4444:4444 --env DOCKER_HOST=tcp://docker:2376 --env DOCKER_CERT_PATH=/certs/client --env DOCKER_TLS_VERIFY=1 selenium/standalone-chrome'
        }
        sh 'mvn clean verify -Dchrome.switches=--headless -Dwebdriver.remote.url=http://localhost:4444/wd/hub -Dwebdriver.remote.driver=chrome'
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
      sh 'docker rm standalone-chrome'
      sh 'docker rm image selenium/standalone-chrome'
      sh 'docker logout'
    }
  }

}