pipeline { 
agent any 
tools{ 
maven 'Maven 3.6.1' 
} 
stages{ 
stage("build"){ 
steps{ 
echo 'Compiling users app..' 
dir('src/main/java/com/glarimy/cmad'){ 
sh 'mvn compile' 
} 
} 
} 
stage("test"){ 
steps{ 
echo 'Running Unit Tets on users app..' 
dir('src/main/java/com/glarimy/cmad'){ 
sh 'mvn clean test' 
} 
} 
} 
stage("package"){ 
steps{ 
echo 'Packaging users app' 
dir('java/cmad-1'){ 
sh 'mvn package -DskipTests' 
archiveArtifacts artifacts: 'src/main/java/com/glarimy/cmad/target/*.jar', 
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