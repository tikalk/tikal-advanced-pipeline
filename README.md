![Tikal-Advanced-Pipeline](resources/images/TAP-small.png)
# TAP - tikal-advanced-pipeline
***Advanced Jenkins Pipeline library***.

Powered by **[Tikal Knowledge](http://www.tikalk.com)** and the community.
<hr/>

Tikal Advanced Pipeline is a [shared library](https://jenkins.io/doc/book/pipeline/shared-libraries/) for [Jenkins Pipeline](https://jenkins.io/doc/book/pipeline/).

The Library is a collection of tasks and examples that can be used inside a pipeline.

Anyone who wants to contribute to this library - please follow the instructions below in the page.

## [Available tasks](vars/README.md)

* TAP_advancedSlackNotification
* TAP_echo
* TAP_email
* TAP_getBuildUserId
* TAP_setStatusByLogText

## [Available examples](resources/pages/examples/README.md)

* Build a Docker image and push it to ECR
* Pull Docker image from ECR

## Adding an item to tikal-advanced-pipeline

For adding a new task or an example, please follow those steps.

1. Create a branch or a fork from the master branch.
2. Write the groovy/Jenkinsfile file for the task/example (along with matching src and resources files if needed) - the file name **MUST** start with **TAP_** prefix.
3. If it is a task, write a test Jenkinsfile for testing the new task and place it in a separate folder in **'/test/pipelines'** folder.
4. Write a markdown section for describing the added item in the matching README.md file.
6. Submit a pull request.

Please notice that only the following of all those steps will be accepted.
