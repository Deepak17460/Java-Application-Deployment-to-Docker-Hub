pipeline {
    agent any

    environment {
        SONAR = 'SonarQube'
        ARTIFACTORY_SERVER_ID = 'Artifactory'
        IMAGE_NAME = 'dpcode72/javaapi'
        IMAGE_TAG = '2.0'
    }
    tools {
        git 'Default'
        maven 'mvn'
    }
    stages {
        stage('Checkout-Scm') {
            steps {
                git branch: 'develop', credentialsId: 'Access-Nagarro-Gitlab', url: 'https://git.nagarro.com/GITG00641/DotNet/deepak-kumar.git'
            }
        }
        stage('Build-Maven') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Unit-Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('SonarQube-Analysis') {
            steps {
                withSonarQubeEnv("${SONAR}") {
                    sh 'mvn sonar:sonar'
                }
            }
        }
        stage('Artifactory') {
            steps {
                script {
                    def uploadSpec = '''{
                        "files": [
                            {
                                "pattern": "target/*.jar",
                                "target": "java-nagarro-assignment/binaries/"
                            }
                        ]
                    }'''
                    rtUpload serverId: "${ARTIFACTORY_SERVER_ID}", spec: uploadSpec
                    rtPublishBuildInfo serverId: "${ARTIFACTORY_SERVER_ID}"
                }
            }
        }
        stage('Build-Docker') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'Artifactory-Auth', usernameVariable: 'ARTIFACTORY_USERNAME', passwordVariable: 'ARTIFACTORY_PASSWORD')]) {
                    sh 'docker build --build-arg ARTIFACTORY_USERNAME=$ARTIFACTORY_USERNAME --build-arg ARTIFACTORY_PASSWORD=$ARTIFACTORY_PASSWORD -t ${IMAGE_NAME}:${IMAGE_TAG} .'
                }
            }
        }
        stage('Docker-Push') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', 'docker-login') {
                        docker.image("${IMAGE_NAME}:${IMAGE_TAG}").push()
                    }
                }
            }
        }
        stage('Run-container') {
            steps {
                script {
                    sh 'docker stop endpointapi'
                    sh 'docker rm endpointapi'
                    sh 'docker run -d --name endpointapi -p 8004:8080 ${IMAGE_NAME}:${IMAGE_TAG}'
                }
            }
        }
    }
}
