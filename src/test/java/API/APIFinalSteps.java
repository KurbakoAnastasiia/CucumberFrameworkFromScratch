package API;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import pojo.*;
import testbase.PageInitializer;
import utils.APICommonMethods;
import utils.APIConstants;
import utils.APIPayloadConstants;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class APIFinalSteps extends PageInitializer {

    RequestSpecification request;
    Response response;
    static String employeeID;
    static String updated_employee_middle_name;
    static String updated_firstname;

    @Given("a request is prepared tp create an employee")
    public void a_request_is_prepared_tp_create_an_employee() {
        request = APICommonMethods.createNewEmployee(generateTokenSteps.token, APIPayloadConstants.newEmployeePayload()).log().all();
    }

    @When("a POST call is made to create an employee")
    public void a_POST_call_is_made_to_create_an_employee() {
        response = request.when().post(APIConstants.CREATE_EMPLOYEE_URI);
    }

    @Then("the status code for creating an employee is {int}")
    public void the_status_code_for_creating_an_employee_is(int statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }

    @Then("the employee is created contains key {string} and value {string}")
    public void the_employee_is_created_contains_key_and_value(String key, String value) {
        response.then().assertThat().body(key, equalTo(value));
    }

    @Then("the employeeID {string} is stored in the global variable to be used for other calls")
    public void the_employeeID_is_stored_in_the_global_variable_to_be_used_for_other_calls(String pathEmployeeID) {
        employeeID = response.jsonPath().getString(pathEmployeeID);
        CreatedEmloyee responsePojo = response.getBody().as(CreatedEmloyee.class);
        System.out.println(responsePojo.toString());
    }

    @Given("a request is prepared to retrieve the created employee")
    public void a_request_is_prepared_to_retrieve_the_created_employee() {
        request = APICommonMethods.getOneEmployee(generateTokenSteps.token, employeeID);
    }

    @When("a GET call is made to retrieve the created Employee")
    public void a_GET_call_is_made_to_retrieve_the_created_Employee() {
        response = request.when().get(APIConstants.GET_ONE_EMPLOYEE_URI);
    }

    @Then("the status code for retrieving the created employee is {int}")
    public void the_status_code_for_retrieving_the_created_employee_is(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("the retrieved EmployeeID {string} matches the globally stored EmployeeID")
    public void the_retrieved_EmployeeID_matches_the_globally_stored_EmployeeID(String value) {
        response.then().assertThat().body(value, equalTo(employeeID));
    }

    @Then("the retrieved data matches the data used to create the employee")
    public void the_retrieved_data_matches_the_data_used_to_create_the_employee() {
        response.then().assertThat().body("employee[0].emp_firstname", equalTo("Anastasiia"));

        GetOneEmployeeBody createdEmployee = response.getBody().as(GetOneEmployeeBody.class);
        System.out.println(createdEmployee);
        List<EmployeeBody> newEmployee = createdEmployee.getEmployee();
        EmployeeBody employee1Body = newEmployee.get(0);
        System.out.println(employee1Body);



//        JsonPath jpath = response.jsonPath();
//        String emp_first_name = jpath.getString("employee[0].emp_firstname");
//        String emp_last_name = jpath.getString("employee[0].emp_lastname");
//        String emp_middle_name = jpath.getString("employee[0].emp_middle_name");
//        String emp_birthday = jpath.getString("employee[0].emp_birthday");
//        String emp_gender = jpath.getString("employee[0].emp_gender");
//        String emp_job_title = jpath.getString("employee[0].emp_job_title");
//        String emp_status = jpath.getString("employee[0].emp_status");
//
//        assertThat(emp_first_name, CoreMatchers.equalTo("Anastasiia"));
//        assertThat(emp_last_name, CoreMatchers.equalTo("Zaiceva"));
//        assertThat(emp_middle_name, CoreMatchers.equalTo("K"));
//        assertThat(emp_birthday, CoreMatchers.equalTo("1986-02-18"));
//        assertThat(emp_gender, CoreMatchers.equalTo("Female"));
//        assertThat(emp_job_title, CoreMatchers.equalTo("IT Analyst"));
//        assertThat(emp_status, CoreMatchers.equalTo("Employee"));
    }

    @Then("the retrieved data at {string} matches the data used to create the employee with employee ID {string}")
    public void the_retrieved_data_at_matches_the_data_used_to_create_the_employee_with_employee_ID(String employeeObject, String responseEmployeeID, DataTable dataTable) {

        //A map to have the data expected in the response --> from feature file
        List<Map<String, String>> expectedData = dataTable.asMaps();

        //getting data from response body
        List<Map<String, String>> actualData = response.body().jsonPath().get(employeeObject);

        //loop through the keys in our hardcoded data and get the value
        int index = 0;
        for (Map<String, String> map : expectedData) {
            Set<String> keys = map.keySet();
            //loop through Keys and get their value and assert

            for (String key : keys) {
                String expectedValue = map.get(key);
                String actualValue = actualData.get(index).get(key);
                Assert.assertEquals(expectedValue, actualValue);
            }
            index++;
        }
        String empID = response.body().jsonPath().getString(responseEmployeeID);
        Assert.assertTrue(empID.contentEquals(employeeID));
    }


    @Given("a request is prepared to get all employees")
    public void a_request_is_prepared_to_get_all_employees() {
        request = APICommonMethods.getAllData(generateTokenSteps.token);
    }

    @When("a GET call is made to retrive all employees")
    public void a_GET_call_is_made_to_retrive_all_employees() {
        response = request.when().get(APIConstants.GET_ALL_EMPLOYEE_URI);
    }

    @Then("the status code is {int}")
    public void the_status_code_is(int statusCode) {
       response.then().statusCode(statusCode);
    }

    @Then("it contains key1 {string} and key2 {string}")
    public void it_contains_key1_and_key2(String key, String key2) {
        response.then().body(containsString(key)).body(containsString(key2));
        }
    @Given("a request is prepared to get all employees status")
    public void a_request_is_prepared_to_get_all_employees_status() {
        request = APICommonMethods.getAllData(generateTokenSteps.token);
    }

    @When("a GET call is made to retrieve all employees status")
    public void a_GET_call_is_made_to_retrieve_all_employees_status() {
       response = request.when().get(APIConstants.GET_ALL_EMPLOYEES_STATUS_URI);
    }

    @Then("it contains the value1 {string} value2 {string}")
    public void it_contains_the_value1_value2(String key1, String key2) {
        //response.then().assertThat().body(containsString(value1)).body(containsString(value2));
        EmployeeStatuses statusesList = response.getBody().as(EmployeeStatuses.class);
        System.out.println(statusesList.toString());
    }
}