def gitRepo(repo)
{
  git 'https://github.com/DanielPrawin/${repo}.git'
}
def buildCreation()
{
  sh 'mvn package'
}
def deploy(jobName,ip,context)
{
   sh 'scp /var/lib/jenkins/workspace/${jobName}/webapp/target/webapp.war ubuntu@${ip}:/var/lib/tomcat9/webapps/${context}.war'
}

def testing(jobName)
{
 sh 'java -jar /var/lib/jenkins/workspace/${jobName}/testing.jar'
}
