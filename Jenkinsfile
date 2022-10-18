pipeline{

  agent {
    node {
        label 'nodo-java'
    }
  }

  stages {

    stage('Deploy to K8s') {

      steps{
        script {
          if(fileExists("configuracion")){
            sh 'rm -r configuracion'
          }
        }
        sh 'git clone https://github.com/dberenguerdevcenter/kubernetes-helm-docker-config.git configuracion --branch test-implementation'
        sh 'kubectl apply -f configuracion/kubernetes-deployment/standalone-chrome/manifest.yml -n default --kubeconfig=configuracion/kubernetes-config/config'
      }

    }

    stage('Run function testing E2E') {
      steps {
        sh 'mvn clean verify -Dchrome.switches=--headless -Dwebdriver.remote.url=http://localhost:4444/wd/hub -Dwebdriver.remote.driver=chrome -Dchrome.switches="--no-sandbox,--ignore-certificate-errors,--homepage=about:blank,--no-first-run"'
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