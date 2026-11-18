
pipeline {
    agent any

    stages {

        stage('Start') {
            steps {
                echo 'Welcome to Jenkins Pipeline!'
                echo 'Starting the build process...'
            }
        }

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Tanvi49471/jenkins-groovy-task.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Building the application...'
                sh 'mkdir -p output'
                sh 'echo "Hello Tanvi! Jenkins Build Successful." > output/message.txt'
            }
        }

        stage('Test') {
            steps {
                echo 'Testing the application...'
                sh 'cat output/message.txt'
                echo 'Test completed successfully!'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying the application...'
                echo 'Deployment completed successfully!'
            }
        }
    }

    post {
        success {
            echo 'SUCCESS: Jenkins Pipeline completed!'
        }

        failure {
            echo 'FAILURE: Jenkins Pipeline failed!'
        }

        always {
            echo 'Pipeline execution finished.'
        }
    }
}
