<<<<<<< HEAD
pipeline {
    agent {
        docker {
            image 'maven:3.3.9-jdk-8-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
=======
node {
    checkout scm
    docker.image('maven:3.3.9-jdk-8-alpine').inside('-v /root/.m2:/root/.m2') {
        sh "mvn clean install"
>>>>>>> parent of 573d7f9... Jenkinsfile updated
    }
}