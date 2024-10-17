#!/user/bin/env groovy

import.com.example.Docker
def call(String imageName){
  return new Docker(this).buildDockerImage(imageName) //by this we passed the reference to all variable availabe to jenkins file to our docker class
}