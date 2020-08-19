pipeline {

	agent any
	tools {
		maven 'maven'
	}
	stages {

		stage ('Compile Stage'){
			steps{
				bat 'mvn clean compile'	
			}	
		}


	
		stage ('Sonarqube deployment Stage'){
			steps{
				bat 'mvn sonar:sonar'	
			}	
		}
		
		
		
		
	}	
}


