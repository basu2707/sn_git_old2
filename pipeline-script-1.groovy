// Simple script with one step

pipeline {
    agent any

    stages {
        stage('preparation') {
            steps {
                snApplyChanges url: "https://comcastdemo.service-now.com", credentialsId: "snow_git_jenkins_poc", appScope: "global"
            }
        }
    }
}
