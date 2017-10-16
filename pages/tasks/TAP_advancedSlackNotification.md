# TAP_advancedSlackNotification

***Send a well-formatted Slack notification***

# Task usage

TAP_advancedSlackNotification(arguments)

Arguments:

| Argument name and type | Description | Default Value |
| ------------- | ----------- | ------------- |
| String buildStatus| Build status| N/A|
| String channel| Slack channel| N/A|
| String additionalMessageText| Additional text to the notification message| empty text|

# Examples

### Usage
TAP_advancedSlackNotification ("SUCCESS","test-channel","@here")

### Output
*BUILD SUCCESS*

[Job] *TEST-JOB #1*
[Name] *#1
[Console] http://jenkins.test-corporate.com:8080/job/TEST-JOB/1/consoleFull

### Test
[Jenkinsfile](../../test/pipelines/advanced_slack_notification/Jenkinsfile)
