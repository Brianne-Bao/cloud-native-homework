pipeline {
  	agent none

 environment {
        GIT_URL = 'https://github.com/Brianne-Bao/cloud-native.git'
        PACKAGE_VERSION = '0.0.1'
        IMAGE_NAME = 'player1'
        IMAGE_VERSION = '1.0'
        HARBOR_REGISTRY = 'harbor.edu.cn/nju10'
        YAML_FILE = './codes/player-service1/player-deploy.yaml'
    }
    
    stages {

        stage('Maven Build') {
            agent {
            	docker {
                    image 'maven:latest'
                    args '-v /root/.m2:/root/.m2'
                }
        	}
            steps {
                echo '2.Maven Build Stage'
                sh 'mvn -B clean package -Dmaven.test.skip=true'
            }
		}

        stage('Build Image') {
            agent {
                label 'master'
            }
            steps {
                echo '3.Image Build Stage'
                sh 'docker build -f Dockerfile --build-arg jar_name=target/player-service1-$PACKAGE_VERSION-SNAPSHOT.jar -t $IMAGE_NAME:$BUILD_ID . '
                sh 'docker tag $IMAGE_NAME:$BUILD_ID $HARBOR_REGISTRY/$IMAGE_NAME:$BUILD_ID'
            }
        }
        stage('Push Image') {
            agent {
                label 'master'
            }
            steps {
                echo '4.Push Docker Image Stage'
                sh 'docker login harbor.edu.cn -u nju10 -p nju102022'
                sh 'docker push $HARBOR_REGISTRY/$IMAGE_NAME:$BUILD_ID'
            }
        }
	}
}

node('slave') {
    container('jnlp-kubectl') {
        stage('Clone YAML') {
            echo '5. Git Clone YAML To Slave'
            git branch: 'main', url: 'https://github.com/Brianne-Bao/cloud-native.git'
        }
        stage('YAML') {
            echo '6. Change YAML File Stage'
            sh 'sed -i "s/{VERSION}/$BUILD_ID/g" $YAML_FILE'
        }
        stage('Deploy') {
            echo '7. Deploy To K8s Stage'
            sh 'kubectl apply -f $YAML_FILE'
        }
    }
}
