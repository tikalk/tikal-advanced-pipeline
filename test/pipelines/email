#!/usr/bin/env groovy

@Library('tikal-advanced-pipeline@master') _

pipeline 
{
    agent any
    stages 
    {
        stage('Code Update') 
        {
            steps 
            {
                echo "===================== 0.0 ========================"
            }
        }
    }
    post {
        success {
            echo "===================== 1.0 ========================"
            notifyBuild('SUCCESS','sample.html')
            echo "===================== 2.0 ========================"
        }
        failure {
            notifyBuild('FAILURE','sample.html')
        }  
        unstable {
            notifyBuild('UNSTABLE','sample.html')
        }            
    }
}
