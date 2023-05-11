package step_definitions.api_steps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.ConfigReader;
import utils.CucumbersLogUtils;

import java.util.HashMap;
import java.util.Map;

public class Hooks {
    private static String token;

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        Hooks.token = token;
    }

    @Before
    public static void retrieveToken(Scenario scenario) {
        CucumbersLogUtils.initScenario(scenario);

        RestAssured.baseURI = "https://api.octoperf.com";

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("password", ConfigReader.readProperty("ConfigLocal.properties","password"));
        map.put("username", ConfigReader.readProperty("ConfigLocal.properties","username"));

        Response response = RestAssured.given()
                .queryParams(map)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .post("/public/users/login")
                .then()
                .log().all()
                .extract()
                .response();
        token = response.jsonPath().getString("token");
        if (token != null) {
            Hooks.setToken(token);
            System.out.println("Token retrieved: " + token);
        } else {
            System.out.println("Failed to retrieve token");
        }
    }


    @After("@token")
    public void clearToken() {
        Hooks.setToken(null);
    }
}
