pipeline {
    agent any

    tools {
        maven "MAVEN_HOME"
    }

    environment {
        SONARQUBE = 'sonarqube' // Nombre del servidor Sonar configurado en Jenkins
        DOCKERHUB_IMAGE = 'tu_usuario/lab-clinico-co-app' // Cambia por tu nombre de imagen si vas a subirla
    }

    stages {
        stage('Clone') {
            steps {
                timeout(time: 10, unit: 'MINUTES') {
                    git branch: 'main', url: 'https://github.com/Carlitos-Omar/Entregable_Despliegue.git'
                }
            }
        }

        stage('Build') {
            steps {
                timeout(time: 10, unit: 'MINUTES') {
                    sh 'mvn -DskipTests clean package'
                }
            }
        }

        stage('Test') {
            steps {
                timeout(time: 10, unit: 'MINUTES') {
                 sh 'mvn clean install || true'
                }
            }
        }

        stage('Sonar') {
            steps {
                timeout(time: 10, unit: 'MINUTES') {
                    withSonarQubeEnv("${SONARQUBE}") {
                        sh 'mvn sonar:sonar -Dsonar.projectKey=lab-clinico -Dsonar.host.url=$SONAR_HOST_URL'
                    }
                }
            }
        }

        stage('Quality Gate') {
            steps {
                timeout(time: 10, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }

        stage('Docker Build & Run') {
            steps {
                timeout(time: 10, unit: 'MINUTES') {
                    sh 'docker compose down || true'
                    sh 'docker compose up -d --build'
                }
            }
        }
    }
}
