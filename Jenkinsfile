pipeline {
    agent any

    tools {
        maven 'Default'
    }

    stages {

        stage('Compilation') {
            steps {
                dir('pipeline-test') {
                    sh 'mvn clean compile'
                }
            }
        }

        stage('Analyse SonarQube') {
            steps {
                dir('pipeline-test') {
                    withSonarQubeEnv('sonar-server') {
                        sh '''
                            mvn sonar:sonar \
                            -Dsonar.projectKey=mon-pipeline-test
                        '''
                    }
                }
            }
        }

        stage('Quality Gate') {
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }

        stage('Publication Nexus Snapshot') {
            steps {
                dir('pipeline-test') {
                    withCredentials([
                        usernamePassword(
                            credentialsId: 'nexus-credentials',
                            usernameVariable: 'NEXUS_USER',
                            passwordVariable: 'NEXUS_PASS'
                        )
                    ]) {
                        sh '''
                            mvn deploy \
                            -DskipTests \
                            -DaltDeploymentRepository=nexus::default::http://${NEXUS_USER}:${NEXUS_PASS}@nexus:8081/repository/maven-snapshots/
                        '''
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'Build, SonarQube analysis, Quality Gate and Nexus deployment completed successfully.'
        }

        failure {
            echo 'Pipeline failed.'
        }

        always {
            cleanWs()
        }
    }
}
