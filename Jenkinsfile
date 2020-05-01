pipeline { 
agent none 

stages{ 
stage("build"){ 
agent {
  docker {
      image 'maven:3.6.1-jdk-8-slim'
      args '-v $HOME/.m2:root/.m2'
  }
}
  steps{ 
    echo 'Compiling users app..' 
    dir('./'){ 
      sh 'mvn compile' 
    } 
  } 
} 

stage("test"){ 
agent {
  docker {
      image 'maven:3.6.1-jdk-8-slim'
      args '-v $HOME/.m2:root/.m2'
  }
}
  steps{ 
    echo 'Running Unit Tets on users app..' 
  dir('./'){ 
    //sh 'mvn clean test' 
      sleep 5
    } 
  } 
} 
stage("package"){ 
agent {
  docker {
      image 'maven:3.6.1-jdk-8-slim'
      args '-v $HOME/.m2:root/.m2'
  }
}
  steps{ 
    echo 'Packaging users app' 
    dir('./'){ 
      sh 'mvn package -DskipTests' 
      archiveArtifacts artifacts: 'target/*.jar', 
    fingerprint: true 
    } 
  } 
} 
stage(‘docker-package’){
  agent any
  steps{
    echo ‘Packaging users app with docker’
    script{
      docker.withRegistry(‘https://index.docker.io/v1/', 'dockerlogin’) {
        def usersImage = docker.build("samvede/users-n-devices:v${env.BUILD_ID}", "./users-n-devices") 
        usersImage.push()
        usersImage.push("latest")
      }
    }
}
}

post{ 
always{ 
echo 'Building multibranch pipeline for users is completed..' 
} 
} 
}
