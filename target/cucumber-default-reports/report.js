$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/apiWorkflow.feature");
formatter.feature({
  "name": "Syntax HRMS API Workflow",
  "description": "  Description: This feature file tests Syntax HRMS API Workflow",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@apiWorkflow"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a JWT is generated",
  "keyword": "Given "
});
formatter.match({
  "location": "API.generateTokenSteps.a_JWT_is_generated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Creating an employee",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@apiWorkflow"
    }
  ]
});
formatter.step({
  "name": "a request is prepared tp create an employee",
  "keyword": "Given "
});
formatter.match({
  "location": "API.APIFinalSteps.a_request_is_prepared_tp_create_an_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a POST call is made to create an employee",
  "keyword": "When "
});
formatter.match({
  "location": "API.APIFinalSteps.a_POST_call_is_made_to_create_an_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the status code for creating an employee is 201",
  "keyword": "Then "
});
formatter.match({
  "location": "API.APIFinalSteps.the_status_code_for_creating_an_employee_is(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee is created contains key \"Message\" and value \"Entry Created\"",
  "keyword": "And "
});
formatter.match({
  "location": "API.APIFinalSteps.the_employee_is_created_contains_key_and_value(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employeeID \"Employee[0].employee_id\" is stored in the global variable to be used for other calls",
  "keyword": "And "
});
formatter.match({
  "location": "API.APIFinalSteps.the_employeeID_is_stored_in_the_global_variable_to_be_used_for_other_calls(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a JWT is generated",
  "keyword": "Given "
});
formatter.match({
  "location": "API.generateTokenSteps.a_JWT_is_generated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Retrieving the created employee",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@apiWorkflow"
    }
  ]
});
formatter.step({
  "name": "a request is prepared to retrieve the created employee",
  "keyword": "Given "
});
formatter.match({
  "location": "API.APIFinalSteps.a_request_is_prepared_to_retrieve_the_created_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a GET call is made to retrieve the created Employee",
  "keyword": "When "
});
formatter.match({
  "location": "API.APIFinalSteps.a_GET_call_is_made_to_retrieve_the_created_Employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the status code for retrieving the created employee is 200",
  "keyword": "Then "
});
formatter.match({
  "location": "API.APIFinalSteps.the_status_code_for_retrieving_the_created_employee_is(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the retrieved EmployeeID \"employee[0].employee_id\" matches the globally stored EmployeeID",
  "keyword": "And "
});
formatter.match({
  "location": "API.APIFinalSteps.the_retrieved_EmployeeID_matches_the_globally_stored_EmployeeID(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the retrieved data matches the data used to create the employee",
  "keyword": "And "
});
formatter.match({
  "location": "API.APIFinalSteps.the_retrieved_data_matches_the_data_used_to_create_the_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the retrieved data at \"employee\" matches the data used to create the employee with employee ID \"employee[0].employee_id\"",
  "rows": [
    {},
    {}
  ],
  "keyword": "And "
});
formatter.match({
  "location": "API.APIFinalSteps.the_retrieved_data_at_matches_the_data_used_to_create_the_employee_with_employee_ID(java.lang.String,java.lang.String,io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a JWT is generated",
  "keyword": "Given "
});
formatter.match({
  "location": "API.generateTokenSteps.a_JWT_is_generated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Get all Employees",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@apiWorkflow"
    }
  ]
});
formatter.step({
  "name": "a request is prepared to get all employees",
  "keyword": "Given "
});
formatter.match({
  "location": "API.APIFinalSteps.a_request_is_prepared_to_get_all_employees()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a GET call is made to retrive all employees",
  "keyword": "When "
});
formatter.match({
  "location": "API.APIFinalSteps.a_GET_call_is_made_to_retrive_all_employees()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the status code is 200",
  "keyword": "Then "
});
formatter.match({
  "location": "API.APIFinalSteps.the_status_code_is(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "it contains key1 \"Total Employees\" and key2 \"Employees\"",
  "keyword": "And "
});
formatter.match({
  "location": "API.APIFinalSteps.it_contains_key1_and_key2(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a JWT is generated",
  "keyword": "Given "
});
formatter.match({
  "location": "API.generateTokenSteps.a_JWT_is_generated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "get all Employees status",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@apiWorkflow"
    }
  ]
});
formatter.step({
  "name": "a request is prepared to get all employees status",
  "keyword": "Given "
});
formatter.match({
  "location": "API.APIFinalSteps.a_request_is_prepared_to_get_all_employees_status()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a GET call is made to retrieve all employees status",
  "keyword": "When "
});
formatter.match({
  "location": "API.APIFinalSteps.a_GET_call_is_made_to_retrieve_all_employees_status()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "it contains the value1 \"Employee\" value2 \"Worker\"",
  "keyword": "Then "
});
formatter.match({
  "location": "API.APIFinalSteps.it_contains_the_value1_value2(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
});