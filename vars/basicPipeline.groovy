#!/usr/bin/groovy
def call(body) 
{
  // evaluate the body block, and collect configuration into the object
  // def config = [:]
  // body.resolveStrategy = Closure.DELEGATE_FIRST
  // body.delegate = config
  // body()
  
  node {
    stage ('First Stage'){
      echo "This is first stage"
    }
    stage('Second Stage'){
      echo "This is second stage"
    }
  }
}
