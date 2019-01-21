podTemplate(label: 'mypod', containers: [
    containerTemplate(name: 'maven', image: 'maven:3.3.9-jdk-8-alpine', command: 'cat', ttyEnabled: true)
  ],
  volumes: [
    hostPathVolume(mountPath: '/var/run/docker.sock', hostPath: '/var/run/docker.sock'),
  ]
  ) {
    node('mypod') {
        stage('Checkout SCM') {
            checkout(scm)
        }

        stage('Build Maven') {
            container('maven') {
                def mavenGoals = ["clean", "install"]

                def mavenGoalsString = mavenGoals.join(" ")

                sh "mvn $mavenGoalsString"
            }
        }
    }
}