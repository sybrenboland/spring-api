node {
    checkout scm
    docker.image('maven:3.3.9-jdk-8-alpine') {
        sh "mvn clean install"
    }
}