#!/usr/bin/groovy

@NonCPS
def call(String buildStatus = 'STARTED', String mailContentFile) {
    // build status of null means successful
    buildStatus = buildStatus ?: 'SUCCESS'

    def out
    def config = new HashMap()
    def bindings = getBinding()
    config.putAll(bindings.getVariables())
    out = config['out']
    
    out.println "================== Printed do Jenkins console ======================"
    out.println "================== buildStatus ${buildStatus} ======================"
    out.println "================== JOB_NAME ${env.JOB_NAME} ======================"
    out.println "================== BUILD_NUMBER ${env.BUILD_NUMBER} ======================"
    out.println "================== BUILD_URL ${env.BUILD_URL} ======================"

    def mailSubject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})"
    def mailContent = readFile mailContentFile
                               // 'popcorn/pipelines/CI-master/summary.html'
    out.println "================== 1111111111111 ======================"

    // Requires "user build vars plugin"
    wrap([$class: 'BuildUser']) {
        out.println "================== Send SUMMARY HTML Mail ... ======================"
        emailext(to: "doronshai@gmail.com", replyTo: "dorons@tikalk.com",
                mimeType: 'text/html', subject: mailSubject, body: mailContent,
                recipientProviders: [[$class: 'DevelopersRecipientProvider'],[$class: 'CulpritsRecipientProvider']]);
    }
    //emailext attachmentsPattern: '**/test.html', body: readFile 'test.html', subject: summary, to: "${env.DEFAULT_RECIPIENTS}", mimeType: 'text/html', recipientProviders: [[$class: 'DevelopersRecipientProvider'],[$class: 'CulpritsRecipientProvider']]
}
