// Simple script with one step

pipeline {
    agent any

    stages {
        stage('preparation') {
            steps {
                snApplyChanges url: "https://comcastdemo.service-now.com", credentialsId: "f8238767dbee64d46caeaa2e139619a7", appScope: "global"
            }
        }
    }
}
