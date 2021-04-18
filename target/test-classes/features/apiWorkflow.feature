#Author: Anastasiia
@apiWorkflow
Feature: Syntax HRMS API Workflow
  Description: This feature file tests Syntax HRMS API Workflow

  Background:
    Given a JWT is generated

  Scenario: Creating an employee
    Given a request is prepared tp create an employee
    When a POST call is made to create an employee
    Then the status code for creating an employee is 201
    And the employee is created contains key "Message" and value "Entry Created"
    And the employeeID "Employee[0].employee_id" is stored in the global variable to be used for other calls

  Scenario: Retrieving the created employee
    Given a request is prepared to retrieve the created employee
    When a GET call is made to retrieve the created Employee
    Then the status code for retrieving the created employee is 200
    And the retrieved EmployeeID "employee[0].employee_id" matches the globally stored EmployeeID
    And the retrieved data matches the data used to create the employee
    And the retrieved data at "employee" matches the data used to create the employee with employee ID "employee[0].employee_id"
      | emp_firstname | emp_middle_name | emp_lastname | emp_birthday | emp_gender | emp_job_title | emp_status |
      | Anastasiia    | K               | Zaiceva      | 1986-02-18   | Female     | IT Analyst    | Employee   |

  Scenario: Get all Employees
    Given a request is prepared to get all employees
    When a GET call is made to retrive all employees
    Then the status code is 200
    And it contains key1 "Total Employees" and key2 "Employees"

  Scenario: get all Employees status
    Given a request is prepared to get all employees status
    When a GET call is made to retrieve all employees status
    Then it contains the value1 "Employee" value2 "Worker"