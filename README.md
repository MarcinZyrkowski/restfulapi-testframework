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
> Note: If `-Ptags=` option not provided, full regression will run

## TO DO:
- update readme
- finish tests for all endpoints
- add github actions
