
node {
    stage('Pre Build') {
        echo "Checkout"
        checkout scm
    }
    stage('Build') {
        echo 'Building..'
        def gradleHome = tool 'Gradle3.4'
        sh "${gradleHome}/bin/gradle build"
    }
    stage('Test') {
        echo 'Testing..'
    }
    stage('Deploy') {
        echo 'Deploying....'
    }
}