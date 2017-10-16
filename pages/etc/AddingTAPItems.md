# Adding an item to tikal-advanced-pipeline

For adding a new task or an example, please follow those steps.

1. Create a branch or a fork from the master branch.
2. Write the groovy/Jenkinsfile file for the task/example (along with matching src and resources files if needed) - the file name **MUST** start with **TAP_** prefix.
3. If it is a task, write a test Jenkinsfile for testing the new task and place it in a separate folder in **'/test/pipelines'** folder.
4. Write a markdown file for describing the added item - based on the matching [task template](../../templates/TemplateTaskPage.md) file.
5. Add a link to the new markdown file in the [main README.md file](../../README.md).
6. Submit a pull request.

Please notice that only the following of all those steps will be accepted.


