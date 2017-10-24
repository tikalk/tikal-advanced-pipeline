![Tikal-Advanced-Pipeline](../resources/images/TAP-small.png)
# ***tikal-Advanced-Pipeline available tasks***

Powered by **[Tikal Knowledge](http://www.tikalk.com)** and the community.
<hr/>

## TAP_advancedSlackNotification

***Send a well-formatted Slack notification***

#### Task usage

TAP_advancedSlackNotification(arguments)

Arguments:

| Argument name and type | Description | Default Value |
| ------------- | ----------- | ------------- |
| String buildStatus| Build status| N/A|
| String channel| Slack channel| N/A|
| String additionalMessageText| Additional text to the notification message| empty text|

#### Example
TAP_advancedSlackNotification ("SUCCESS","test-channel","@here")

## TAP_echo

***Echo text with time-stamp***

#### Task usage

TAP_echo(arguments)

Arguments:

| Argument name and type | Description | Default Value |
| ------------- | ----------- | ------------- |
| String text| Text to display| N/A|

#### Example
TAP_echo ("Hello TAP!")

#### Output
[20170715-05:40:11.393] Hello TAP!

## TAP_email

***Send email notification using the EmailExt plugin***

##### Task usage

TAP_email(arguments)

Arguments:

| Argument name and type | Description | Default Value |
| ------------- | ----------- | ------------- |
| String buildStatus | | |
| mailContentFile | | |

#### Example
TAP_email('FAILURE','sample.html')

## TAP_getBuildUserId

***Get job acticator user-id***

#### Task usage example

def userId = TAP_getBuildUserId()

## TAP_setStatusByLogText

***set the build status based on searched text in the build log file***

#### Task usage

TAP_setStatusByLogText(Arguments)

Arguments:

| Argument name and type | Description | Default Value |
| ------------- | ----------- | ------------- |
| String searchText| Text to search| N/A|

#### Example
TAP_setStatusByLogText ("ERROR")

#### Output
Found 'ERROR' in build log

