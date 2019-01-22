podTemplate(
    label: 'mypod',
    inheritFrom: 'default',
    containers: [
        containerTemplate(
            name: 'maven',
            image: 'maven:3.3.9-jdk-8-alpine',
            ttyEnabled: true,
            command: 'cat'
        ),
        containerTemplate(
            name: 'docker',
            image: 'docker:18.02',
            ttyEnabled: true,
            command: 'cat'
        )
    ],
    volumes: [
        hostPathVolume(
            hostPath: '/var/run/docker.sock',
            mountPath: '/var/run/docker.sock'
        )
    ]
) {
    node('mypod') {
        def commitId
        stage ('Extract') {
            checkout scm
            commitId = sh(script: 'git rev-parse --short HEAD', returnStdout: true).trim()
        }
        stage ('Build') {
            container ('maven') {
                sh 'mvn clean install'
            }
        }
        def repository
        stage ('Docker build and push') {
            container ('docker') {
                repository = "shboland/spring-api"
                sh "docker build -t ${repository}:${commitId} ."

                withCredentials([usernamePassword(credentialsId: 'dockerhub',
                                        usernameVariable: 'registryUser', passwordVariable: 'registryPassword')]) {
                    sh "docker push ${repository}"
                }
            }
        }
    }
}