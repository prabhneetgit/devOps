node {
   def mvnHome
   stage('Prepare') {
      git url: 'git@github.com:prabhneetgit/devOps.git', branch: 'develop'
      mvnHome = tool 'maven'
   }
   stage('Build') {
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
      } else {
         bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
      }
   }
   stage('Unit Test') {
      junit '**/target/surefire-reports/TEST-*.xml'
      archive 'target/*.jar'
   }
   stage('Integration Test') {
     if (isUnix()) {
        sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean verify"
     } else {
        bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean verify/)
     }
   }
   stage('Sonar') {
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' sonar:sonar"
      } else {
         bat(/"${mvnHome}\bin\mvn" sonar:sonar -Dsonar.projectKey=devops-gitflow -Dsonar.host.url=http://192.168.99.100:9000 -Dsonar.login=dbbb81b1f748556e80e5ac37fd72583a84d7d853/)
      }
   }
   stage('Deploy') {
       sh 'curl -u jenkins:jenkins -T target/**.war "http://localhost:8080/manager/text/deploy?path=/devops&update=true"'
   }
   stage("Smoke Test"){
       sh "curl --retry-delay 10 --retry 5 http://localhost:8080/devops"
   }
}