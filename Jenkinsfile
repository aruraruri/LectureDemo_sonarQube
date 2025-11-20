pipeline {
    agent any

    tools {
     maven 'MAVEN_HOME'
    }

    environment {
        SONARQUBE_SERVER = 'SonarQubeServer'  // SonarQube server name in Jenkins config
        SONAR_TOKEN = 'sqa_e4cef5513e99fd1196f1f7053dac7ababb620c2b'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/aruraruri/LectureDemo_sonarQube.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQubeServer') {
                    bat """
                        ${tool 'SonarScanner'}\\bin\\sonar-scanner ^
                        -Dsonar.projectKey=SonarCalculator ^
                        -Dsonar.sources=src/calc/java/calc ^
                        -Dsonar.projectName=SonarCalculatorTest ^
                        -Dsonar.host.url=http://localhost:9000 ^
                        -Dsonar.login=${env.SONAR_TOKEN} ^
                        -Dsonar.java.binaries=target/classes
                    """
                }
            }
        }
    }
}