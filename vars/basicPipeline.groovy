#!/usr/bin/groovy

def call(body) 
{
  // evaluate the body block, and collect configuration into the object
  //def config = [:]
  //body.resolveStrategy = Closure.DELEGATE_FIRST
  //body.delegate = config
  mainFlow()
  
}

def mainFlow()
{
    gitUpdate("git@...")
    mavenBuild()
}

def gitUpdate(String gitURL, String gitBranch = "master", String phaseTitle = "GIT checkout")
{
    stage( phaseTitle ) {
        echo "GIT URL ==> " + gitURL;
        echo "GIT BRANCH ==> " + gitBranch;
    }
    
}

def mavenBuild(String mavenPomPath = "pom.xml", String mavenGoals = "clean install", String phaseTitle = "Maven build")
{
    stage( phaseTitle ) {
        echo "Maven POM path ==> " + mavenPomPath;
        echo "MAVEN goals ==> " + mavenGoals;
    }
    
}
