package utils;

import io.restassured.specification.RequestSpecification;
import pojo.NewEmployee;
import testbase.PageInitializer;

import static io.restassured.RestAssured.given;

public class APICommonMethods extends PageInitializer {

    /**
     * This method creates new employee
     * @param token
     * @param createEmployeeBody
     * @return
     */
    public static RequestSpecification createNewEmployee(String token, NewEmployee createEmployeeBody) {
        return given().header(APIConstants.HEADER_CONTENT_TYPE, APIConstants.CONTENT_TYPE)
                .header(APIConstants.HEADER_AITHORIZATION, token)
                .body(createEmployeeBody);
    }

    /**
     * This method retrives any one employee based on specific employee number
     * @param token
     * @param employeeID
     * @return
     */
    public static RequestSpecification getOneEmployee(String token, String employeeID) {
        return given().header(APIConstants.HEADER_CONTENT_TYPE, APIConstants.CONTENT_TYPE)
                .header(APIConstants.HEADER_AITHORIZATION, token)
                .queryParam("employee_id", employeeID);
    }

    /**
     * This method creates request for get call without passing parameters
     * @param token
     * @return
     */
    public static RequestSpecification getAllData(String token) {
        return given().header(APIConstants.HEADER_CONTENT_TYPE, APIConstants.CONTENT_TYPE)
                .header(APIConstants.HEADER_AITHORIZATION, token);
    }


   }
