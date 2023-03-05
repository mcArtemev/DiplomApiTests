package ApiTests.User;


import ApiTests.BaseData;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TestFixtures extends BaseData {
    public Response createUser(UserSerializer userJsonData) {
        Response response = given()
                .header("Content-type", "application/json")
                .body(userJsonData)
                .when()
                .post("/api/auth/register");
        return response;
    }

    public void deleteUser(String userToken) {
         given()
                .header("Authorization", userToken)
                .when()
                .delete("/api/auth/user")
                .then()
                .statusCode(202);
    }
}
