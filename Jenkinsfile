pipeline{

  agent {
      docker {
          image 'selenium/standalone-chrome'
          reuseNode true
      }
  }

  stages {

    stage('Run function testing E2E') {

      steps {
        sh 'mvn clean verify -Dchrome.switches=--headless;'
      }
    }

    stage('Generate Cucumber Report') {
      steps {
        sh 'mvn serenity:aggregate'
      }
    }

  }

}