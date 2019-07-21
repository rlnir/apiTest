# API Test Example

## Installation
1. download or clone source code.
2. import to IDE as Maven project.

## Running Tests
1. find sanity.xml file in root.
2. run file as TestNG suite (usually right click on file -> run).

## Create Report
1. install Allure commandline application: [instructions](https://docs.qameta.io/allure/#_get_started).
2. make sure that you have run the tests at list once.
2. go to the root path of the project.
3. type and execute (in power shell or bash):
```
allure serve allure-results
```

a report should be generated and displayed in your browser.
