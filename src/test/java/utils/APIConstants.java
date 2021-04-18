package utils;

import io.restassured.RestAssured;

public class APIConstants {
    public static final String BASE_URI = RestAssured.baseURI = "http://3.237.189.167/syntaxapi/api";
    public static final String GENERATE_TOKEN_URI = "/generateToken.php";
    public static final String CREATE_EMPLOYEE_URI = "/createEmployee.php";
    public static final String GET_ONE_EMPLOYEE_URI = "/getOneEmployee.php";
    public static final String UPDATE_EMPLOYEE_URI = "/updateEmployee.php";
    public static final String GET_ALL_EMPLOYEE_URI = "/getAllEmployees.php";
    public static final String DELETE_EMPLOYEE_URI = "/deleteEmployee.php";
    public static final String PARTIALLY_UPDATE_EMPLOYEE_URI = "/updatePartialEmplyeesDetails.php";
    public static final String GET_ALL_EMPLOYEES_STATUS_URI = "/employeeStatus.php";
    public static final String GET_ALL_JOB_TITLES_URI = "/jobTitle.php";

    public static final String HEADER_CONTENT_TYPE = "Content-type";
    public static final String CONTENT_TYPE = "Application/json";

    public static final String HEADER_AITHORIZATION = "Authorization";

    public static final String CREATE_EMPLOYEE_JSON=System.getProperty("user.dir")+"/src/test/resources/JsonData/createUser.json";
}
