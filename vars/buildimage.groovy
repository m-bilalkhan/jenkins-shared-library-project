#!/user/bin/env groovy

def call(){
  echo "building the docker image..."
  withCredentials([usernamePassword(credentialsId: 'docker-hub-repo-creds', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
    sh 'docker build -t mbilalkhan/practice-repo:1.0.0 .'
    sh 'echo $PASS | docker login -u $USER --password-stdin'
    sh 'docker push mbilalkhan/practice-repo:1.0.0'
  }
}