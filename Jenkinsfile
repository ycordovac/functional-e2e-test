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
            sh 'docker run -d --name=standalone-chrome -p 4444:4444 selenium/standalone-chrome'
        }
        sh 'mvn clean verify -Dchrome.switches=--headless -DSELENIUM_GRID=http://localhost:4444/wd/hub'
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