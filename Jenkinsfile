pipeline {
    agent any

    stages {

        stage('Clone') {
            steps {
                git 'https://github.com/Manoj18121812/Two-tier-Crud-CICD.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Deploy using Docker Compose') {
            steps {
                sh '''
                docker compose down || true
                docker compose up -d --build
                '''
            }
        }
    }

    post {
        success {
            echo 'Deployment Successful 🚀'
        }
        failure {
            echo 'Build Failed ❌'
        }
    }
}

