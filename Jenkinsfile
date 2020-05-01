pipeline { 
agent any 
tools{ 
maven 'Maven 3.6.1' 
} 
stages{ 
stage("build"){ 
steps{ 
echo 'Compiling users app..' 
dir('./'){ 
sh 'mvn compile' 
} 
} 
} 
stage("test"){ 
steps{ 
echo 'Running Unit Tets on users app..' 
dir('./'){ 
//sh 'mvn clean test' 
  sleep 5
} 
} 
} 
stage("package"){ 
steps{ 
echo 'Packaging users app' 
dir('./'){ 
sh 'mvn package -DskipTests' 
archiveArtifacts artifacts: 'target/*.jar', 
fingerprint: true 
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
