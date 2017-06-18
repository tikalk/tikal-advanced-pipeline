#!/usr/bin/groovy

import settings_mail

def call(settings_mail set) {
    // build status of null means successful
    buildStatus = set.buildStatus ?: 'SUCCESS'

    // Default values
    //def TEST = '\${CHANGES, showPaths=true, format="%a: %r %p \n--\"%m\"", pathFormat="\n\t- %p"}'
    def mailSubject = "${set.buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})"
    def mailContent = readFile set.mailContentFile
                               // 'popcorn/pipelines/CI-master/summary.html'

    // Requires "user build vars plugin"
    wrap([$class: 'BuildUser']) {
        echo "Send SUMMARY HTML Mail ..."
        emailext(to: "${env.DEFAULT_RECIPIENTS}", replyTo: "dorons@tikalk.com",
                mimeType: 'text/html', subject: set.mailSubject, body: set.mailContent,
                recipientProviders: [[$class: 'DevelopersRecipientProvider'],[$class: 'CulpritsRecipientProvider']]);
    }
    //emailext attachmentsPattern: '**/test.html', body: readFile 'test.html', subject: summary, to: "${env.DEFAULT_RECIPIENTS}", mimeType: 'text/html', recipientProviders: [[$class: 'DevelopersRecipientProvider'],[$class: 'CulpritsRecipientProvider']]
}
