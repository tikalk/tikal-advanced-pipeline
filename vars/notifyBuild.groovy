#!/usr/bin/groovy

@NonCPS
def call(String buildStatus = 'STARTED', String mailContentFile) {
    // build status of null means successful
    buildStatus = buildStatus ?: 'SUCCESS'

    // Default values
    //def TEST = '\${CHANGES, showPaths=true, format="%a: %r %p \n--\"%m\"", pathFormat="\n\t- %p"}'
    def mailSubject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})"
    def mailContent = readFile mailContentFile
                               // 'popcorn/pipelines/CI-master/summary.html'

    // Requires "user build vars plugin"
    wrap([$class: 'BuildUser']) {
        echo "Send SUMMARY HTML Mail ..."
        emailext(to: "doronshai@gmail.com", replyTo: "doronshai@tikalk.com",
                mimeType: 'text/html', subject: mailSubject, body: mailContent,
                recipientProviders: [[$class: 'DevelopersRecipientProvider'],[$class: 'CulpritsRecipientProvider']]);
    }
    //emailext attachmentsPattern: '**/test.html', body: readFile 'test.html', subject: summary, to: "${env.DEFAULT_RECIPIENTS}", mimeType: 'text/html', recipientProviders: [[$class: 'DevelopersRecipientProvider'],[$class: 'CulpritsRecipientProvider']]
}
