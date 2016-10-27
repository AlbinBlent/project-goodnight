node {
    try {
        stage('checkout') {
            git 'https://github.com/AlbinBlent/project-goodnight.git'
        }

        def project_path = "spring-boot-samples/spring-boot-sample-atmosphere"

        stage('build, unit test, integration test') {
            sh 'mvn clean package -Dembedded=true'
            sh 'mvn docker:build'
        }

    } catch (err) {
        currentBuild.result = 'FAILURE'
    }

    stage('archival') {
        /*
        publishHTML([allowMissing: true,
            alwaysLinkToLastBuild: false,
            keepAll: true,
            reportDir: 'target/site/jacoco',
            reportFiles: 'index.html',
            reportName: 'Code Coverage'])
        */
        junit 'target/surefire-reports/TEST-*.xml'

        archiveArtifacts artifacts: "target/*.?ar", excludes: null
    }

    stage ('Deploy'){
        sh 'docker push albin/albinsshop'
        sh 'docker-cloud service redeploy albinsshop'
    }
}
