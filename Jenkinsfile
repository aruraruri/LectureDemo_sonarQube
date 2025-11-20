pipeline {
    agent any

     environment {
                    PATH = "C:\\Program Files\\Docker\\Docker\\resources\\bin;${env.PATH}"

                    // Define Docker Hub credentials ID
                    DOCKERHUB_CREDENTIALS_ID = 'Docker_Hub'
                    // Define Docker Hub repository name
                    DOCKERHUB_REPO = 'aruraruri/sonar_calculator'
                    // Define Docker image tag
                    DOCKER_IMAGE_TAG = 'latest'
                }

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

        stage('Code Coverage') {
                    steps {
                        recordCoverage(tools: [[parser: 'JACOCO']],
                                id: 'jacoco', name: 'JaCoCo Coverage',
                                sourceCodeRetention: 'EVERY_BUILD',
                                qualityGates: [
                                        [threshold: 60.0, metric: 'LINE', baseline: 'PROJECT', unstable: true],
                                        [threshold: 60.0, metric: 'BRANCH', baseline: 'PROJECT', unstable: true]])
                    }
                }
                stage('Build Docker Image') {
                    steps {
                        bat 'docker build -t %DOCKERHUB_REPO%:%DOCKER_IMAGE_TAG% .'
                    }
                }

                stage('Push Docker Image to Docker Hub') {
                    steps {
                        withCredentials([usernamePassword(credentialsId: "${DOCKERHUB_CREDENTIALS_ID}", usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                            bat '''
                                docker login -u %DOCKER_USER% -p %DOCKER_PASS%
                                docker push %DOCKERHUB_REPO%:%DOCKER_IMAGE_TAG%
                            '''
                        }
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