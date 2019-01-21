node {
    checkout scm
    docker.image('maven:3.3.9-jdk-8-alpine').inside('-v /root/.m2:/root/.m2') {
        sh "mvn clean install"
    }
}