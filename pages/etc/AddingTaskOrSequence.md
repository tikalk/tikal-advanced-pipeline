# Adding a task/sequence to tikal-advanced-pipeline

For adding a new task or a sequence, please follow those steps.

1. Create a branch or a fork from the master branch.
2. Write the groovy file for the task/sequence (along with matching src and resources files if needed) - the file name **MUST** start with **TAP_** prefix.
3. Write a test Jenkinsfile for testing the new task/sequence and place it in a separate folder in **'/test/pipelines'** folder.
4. Write a markdown file for describing the added task/sequence - based on the matching [task template](../../templates/TemplateTaskPage.md) or  [sequence template](../../templates/TemplateSequencePage.md) file.
5. Add a link to the new markdown file in the [main README.md file](../../README.md).
6. Submit a pull request.

Please notice that only the following of all those steps will be accepted.


