#!/usr/bin/groovy

def notifyBuild(String buildStatus = 'STARTED') {
    // build status of null means successful
    buildStatus = buildStatus ?: 'SUCCESS'

    // Default values
    //def TEST = '\${CHANGES, showPaths=true, format="%a: %r %p \n--\"%m\"", pathFormat="\n\t- %p"}'
    def colorName = 'RED'
    def colorCode = '#FF0000'
    def mailSubject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})"
    def mailContent = readFile 'popcorn/pipelines/CI-master/summary.html'

    // Override default values based on build status
    if (buildStatus == 'STARTED') {
        color = 'YELLOW'
        colorCode = '#FFFF00'
    } else if (buildStatus == 'SUCCESS') {
        color = 'GREEN'
        colorCode = '#00FF00'
    } else {
        color = 'RED'
        colorCode = '#FF0000'
    }

    wrap([$class: 'BuildUser']) {
        echo "Send SUMMARY HTML Mail ..."
        emailext(to: "${env.DEFAULT_RECIPIENTS}", replyTo: "popcorn@amdocs.com",
                mimeType: 'text/html', subject: mailSubject, body: mailContent,
                recipientProviders: [[$class: 'DevelopersRecipientProvider'],[$class: 'CulpritsRecipientProvider']]);
    }
    //emailext attachmentsPattern: '**/test.html', body: readFile 'test.html', subject: summary, to: "${env.DEFAULT_RECIPIENTS}", mimeType: 'text/html', recipientProviders: [[$class: 'DevelopersRecipientProvider'],[$class: 'CulpritsRecipientProvider']]
}
