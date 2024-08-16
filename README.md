## Goal
The purpose of this repository is to create API test automation framework which test
https://restful-api.dev/ webb app.

## Running regression
`gradle test`
<br/>
Will execute full regression

## Running arbitrary tests
It is possible to run any test or tests which are annotated by JUnit5 tags.
In this purpose gradle task `junit5` was introduced.
<br/>
To run test which include specific task e.g. `"debug"`,
annotate test/s by `@Tag("debug")`, then run the following command:
`gradle junit5 -Ptag=debug`
<br/>
> Note: If `-Ptag=` option not provided, full regression will be run

## GitHub Actions Integration
The test framework is integrated with GitHub Actions. You can run tests via GitHub Action.
Go to `GitHub Action Manual Test Run`, select environment and run regression.
To open reports do the following steps:
1. Download `reports` archive
2. Extract archive
3. Open terminal at `reports` folder
4. Execute `allure open` command

## Note
QA env is set to wrong url, tests run against QA will fail. This is only mock to emulate running tests on 2 envs.
