#!/user/bin/env groovy
//This class is part of com.example 
//Here com.example is a package which we sort of import into functions
//yaha script. ker ke isliye nhi ha ku ke ye direct pipeline ka part nhi hoti yaha ap direct pipeline wale variable etc available nhi hote ha

package com.example

class Docker implements Serializable {
  def script

  Docker () {
    this.script = script
  }

  def buildDockerImage (String imageName) {
    script.echo "building the docker image..."
    script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub-repo-creds', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
      script.sh "docker build -t $imageName ."
      script.sh "echo '${script.PASS}' | docker login -u '${script.USER}' --password-stdin"
      script.sh "docker push $imageName"
    }
  }
}

