pipeline {
    agent any

    environment {
        TOMCAT_IP = credentials('DEPLOY_SERVER_IP')
    }

    stages {

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Deploy to Tomcat server') {
            steps {
                sshagent(credentials: ['tomcat-ssh-key']) {
                    sh """
                    scp target/*.war ec2-user@${TOMCAT_IP}:/home/ec2-user/tomcat9/tomcat/webapps/
                    """
                }
            }
        }
    }

    post {
        success {
            echo 'Deployment successful!'
        }
        failure {
            echo 'Deployment failed.'
        }
    }
}
