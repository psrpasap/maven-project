pipeline {
    agent any
    
    parameters { 
         string(name: 'tomcat_dev', defaultValue: '34.228.23.64', description: 'Staging Server')
         string(name: 'tomcat_prod', defaultValue: '34.228.23.64', description: 'Production Server')
    } 
 
    triggers {
         pollSCM('* * * * *') // Polling Source Control
     }
 
    stages{
        stage('Build'){
            steps {
                bat 'mvn clean package'
            }
            post {
                success {
                    echo 'Now Archiving...'
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }
        }
 
        stage ('Deployments'){
            parallel{
                stage ('Deploy to Staging'){
                    steps {
                        bat "winscp -i C:/Users/prasad potluri/tomcat-demo-east1.pem **/target/*.war ec2-user@${params.tomcat_dev}:/var/lib/tomcat8/webapps"
                    }
                }
 
                stage ("Deploy to Production"){
                    steps {
                        bat "winscp -i C:/Users/prasad potluri/tomcat-demo-east1.pem **/target/*.war ec2-user@${params.tomcat_prod}:/var/lib/tomcat8/webapps"
                    }
                }
            }
        }
    }
}