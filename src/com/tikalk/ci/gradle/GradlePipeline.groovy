package com.tikalk.ci.gradle;

import com.tikalk.ci.BasePipeline

class GradlePipeline extends BasePipeline {
    boolean debugMode
    int waitForInputTimeout
    def buildTarget


    GradlePipeline(script) {
        super(script)
    }


    @Override
    void populateBuildDisplayName() {
        script.currentBuild.displayName = "${script.currentBuild.displayName} ${retrieveCurrentBuildUser()}"
    }

    void retrieveCurrentBuildUser() {
        script.wrap([$class: 'BuildUser']) {
            script.sh returnStdout: true, script: 'echo ${BUILD_USER}'
        }
    }

    @Override
    void initParams()
    {
        this.&initParams()
        buildTarget = script.params.buildTarget //script.params.// Implement to set params that are not able to set in constructor (due to @NonCPS etc)

    }
    @Override
    void build() {
        logger.info "Implements gradle build here"
        script.sh "ls"
        script.sh './gradlew ' + buildTarget
    }


    void waitForInput() {
        script.timeout(time: waitForInputTimeout, unit: 'MINUTES') {
            if (debugMode) {
                script.input 'Continue with cleanup?'
            }
        }
    }



    void compile(Map m) {

    }

    void buildDocker() {

    }





}
