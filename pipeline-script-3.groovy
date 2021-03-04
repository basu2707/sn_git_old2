// Sample script with simple workflow of publishing and installing an application on NOW platform

pipeline {
    agent any

    parameters {
            snParam(credentialsForPublishedApp: "snow_git_jenkins_poc", instanceForPublishedAppUrl: "https://comcastdemo.service-now.com",
                    credentialsForInstalledApp:"snow_git_jenkins_poc", instanceForInstalledAppUrl:"https://comcastdemo.service-now.com",
                    appScope: "global")
    }

    stages {
        stage('publishing') {
            steps {
                snPublishApp obtainVersionAutomatically: true
            }
        }
        stage('installation') {
            steps {
                snInstallApp()
                snRunTestSuite browserName: 'Firefox', osName: 'Windows', osVersion: '10', testSuiteName: 'My CHG:Change Management', withResults: true
            }
        }
    }
}
