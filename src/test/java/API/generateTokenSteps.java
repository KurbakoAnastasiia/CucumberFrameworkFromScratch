package API;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.User;
import utils.APIConstants;
import utils.APIPayloadConstants;

import static io.restassured.RestAssured.given;

public class generateTokenSteps {
    String BaseURI = RestAssured.baseURI = "http://3.237.189.167/syntaxapi/api";
    static String token;

    @Given("a JWT is generated")
    public void a_JWT_is_generated() {
        RequestSpecification generateTokenRequest = given().header(APIConstants.HEADER_CONTENT_TYPE, APIConstants.CONTENT_TYPE).
                body(APIPayloadConstants.userToGenerateToken());
        Response generateTokenResponse = generateTokenRequest.when().post(APIConstants.GENERATE_TOKEN_URI);
        generateTokenResponse.prettyPrint();
        token = "Bearer " + generateTokenResponse.jsonPath().getString("token");
    }
}
