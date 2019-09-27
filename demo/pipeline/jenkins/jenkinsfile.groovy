pipeline {

    agent { label 'devl' }  //jenkins slave on which pipeline will deploy

    stages {

        stage('Hello World') {
            steps {
                dir('pipeline/scripts') {
                    sh 'sh ./hello.sh'
                }
            }
        }
    }

}
