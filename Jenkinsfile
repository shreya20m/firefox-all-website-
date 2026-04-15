pipeline {
agent any

```
tools {
    maven 'Maven'   // Make sure Maven is configured in Jenkins
    jdk 'Java'      // Make sure JDK is configured in Jenkins
}

stages {

    stage('Checkout Code') {
        steps {
            git branch:'main',url:'https://github.com/shreya20m/firefox.git'
        }
    }

    stage('Build') {
        steps {
            sh 'mvn clean package'
        }
    }

    stage('Run Application') {
        steps {
            sh 'java -jar target/MyMavenSeleniumApp01-1.0-SNAPSHOT.jar'
        }
    }
}

post {
    success {
        echo '✅ Build and execution successful!'
    }
    failure {
        echo '❌ Build failed!'
    }
}
```

}



