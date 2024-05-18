package tests;

import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static utils.Steps.*;

public class TestRequests {


    @BeforeSuite
    public void setUp() {
        baseURI = "https://reqres.in/api";
    }

    @Test
    public void testListUsers() {

        String url = "/users?page=2";

        Allure.addAttachment("URL: ", url);

        Response response = GET(url);

//        Response response = get("https://reqres.in/api/users?page=2");
//        response.then().assertThat().statusCode(200);

        isStatusCodeValid(response, 200);


//        given()
//                .when()
//                .get("https://reqres.in/api/users?page=2")
//                .then()
//                .assertThat()
//                .statusCode(200);
    }

    @Test
    public void testSingleUser() {
        String url = "/users/2";

        Allure.addAttachment("URL: ", url);

        Response response = GET(url);

        isStatusCodeValid(response, 200);
    }

    @Test
    public void testCreate() {
        String url = "/users";

        String body = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        Response response = POST(body, url);
        isStatusCodeValid(response, 201);


    }
}
