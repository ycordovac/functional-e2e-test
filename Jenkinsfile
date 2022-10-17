pipeline{

  agent {
    node {
        label "nodo-java-chrome"
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