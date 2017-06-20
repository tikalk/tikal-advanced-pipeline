#!/usr/bin/groovy

@NonCPS
def call(String buildStatus, String mailContentFile) {
    // build status of null means successful
    buildStatus = buildStatus ?: 'SUCCESS'

    //def out
    //def config = new HashMap()
    //def bindings = getBinding()
    //config.putAll(bindings.getVariables())
    //out = config['out']
    
    
    manager.listener.logger.println "================== Printed do Jenkins console 1 ======================"
    manager.listener.logger.println "================== buildStatus    ${buildStatus} ======================"
    manager.listener.logger.println "================== JOB_NAME       ${env.JOB_NAME} ======================"
    manager.listener.logger.println "================== BUILD_NUMBER   ${env.BUILD_NUMBER} ======================"
    manager.listener.logger.println "================== BUILD_URL      ${env.BUILD_URL} ======================"

    def mailSubject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})"
    manager.listener.logger.println "================== mailSubject      "+ mailSubject + " ======================"

    manager.listener.logger.println "================== Printed do Jenkins console 2 ====================="
    manager.listener.logger.println "================== Printed do Jenkins console 2 ====================="
    manager.listener.logger.println "================== Printed do Jenkins console 2 ====================="
    
    manager.listener.logger.println "================== mailContentFile    " + mailContentFile + " ====================="
    
    //String 
    String mailContent = readFile mailContentFile
    //String mailContent = new File(env.WORKSPACE/mailContentFile).text

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
