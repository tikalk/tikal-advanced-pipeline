package com.tikalk.ci.gradle

import com.tikalk.utils.Library
import com.tikalk.ci.gradle.GradlePipeline


@Library('tikal-advanced-pipeline') _


node("linux-host-slave") {
    pipeline = new GradlePipeline(this)
    pipeline.run()

    def buildResult = pipeline.getCurrentBuildResult() != null ? pipeline.getCurrentBuildResult() : 'SUCCESS'
    def buildNum = env.BUILD_NUMBER
    def buildURL = env.BUILD_URL

    emailext body: 'Your Jenkins Job, Num. ' + buildNum + ' Finished With Status => ' +
             buildResult + '\nYou Can Reach The Test Result Page Here. ' +
            buildURL + 'cucumber-html-reports/overview-features.html',
             subject: 'Build ' + env.BUILD_NUMBER + ' Result',
            to: 'itai@tikalk.com'
     }

