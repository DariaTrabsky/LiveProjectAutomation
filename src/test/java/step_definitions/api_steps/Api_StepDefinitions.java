package step_definitions.api_steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utils.BrowserUtils;
import utils.CucumbersLogUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Api_StepDefinitions {
    Response response;
    Response postResponse;
    Response deleteResponse;
    String courseName;
    private RequestSpecification request;
    private String endpoint;
    @Given("the {string} course endpoint is {string}")
    public void theSDETCourseEndpointIs(String courseType, String endpoint) {
        if (courseType.equalsIgnoreCase("SDET")) {
            this.endpoint = endpoint;
        } else if (courseType.equalsIgnoreCase("Dev")) {
            this.endpoint = endpoint;
        } else {
            throw new IllegalArgumentException("Invalid course type: " + courseType);
        }
    }

    @When("I send a GET request to the SDET course endpoint")
    public void iSendAGETRequestToTheSDETCourseEndpoint() {
        RequestSpecification request = RestAssured.given();
        response = request.get(endpoint).then().log().all().extract().response();
    }

    @Then("the response status code is {int}")
    public void theResponseStatusCodeIs(int code) {
        Assert.assertEquals(code, response.statusCode());
    }


    @And("the response body contains the following fields:")
    public void theResponseBodyContainsTheFollowingFields(List<String> expectedFields) {
        response = response.then().log().all().extract().response();
        for (String field : expectedFields) {
            Assert.assertTrue(response.getBody().asString().contains(field));

        }

    }

    @Given("I have the following student details")
    public void iHaveTheFollowingStudentDetails(List<Map<String, Object>> data) {

        Object batch = data.get(0).get("batch");
        Object firstName = data.get(0).get("firstName");
        Object lastName = data.get(0).get("lastName");
        Object email = data.get(0).get("email");

        System.out.println("Creating student with the following details:");
        System.out.println("Batch Name: " + batch);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Email: " + email);

        String jsonPayload = "{\"batch\":\"" + batch + "\",\"firstName\":\"" + firstName + "\",\"lastName\":\"" + lastName + "\",\"email\":\"" + email + "\"}";
        request = RestAssured.given()
        .header("Content-Type", "application/json")
        .body(jsonPayload);



    }
    @When("I perform a POST request to add the student")
    public void iPerformPOSTRequestToAddTheStudent() {
        response = request.post("https://tla-school-api.herokuapp.com/api/school/resources/students");
    }

    @Then("the student should be successfully added to the database")
    public void theStudentShouldBeSuccessfullyAddedToTheDatabase() {
        response = response.then().log().all().extract().response();
        CucumbersLogUtils.logInfo(response.asPrettyString(),false);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);

    }


    @Given("I send a POST request to the course endpoint with following fields")
    public void sendPOSTRequest(Map<String, String> fields) {
        String duration = fields.get("duration");
        String name = fields.get("name");
        RequestSpecification request = RestAssured.given()
                .header("Content-Type", "application/json")
                .body("{ \"duration\": \"" + duration + "\", \"name\": \"" + name + "\" }");

        postResponse = request.post(endpoint).then().log().all().extract().response();
        System.out.println(endpoint);
        CucumbersLogUtils.logInfo(postResponse.asPrettyString(),false);
        courseName = postResponse.jsonPath().getString("data.name");
        System.out.println(courseName);
    }

    @When("I perform a DELETE request using course name parameter")
    public void performDELETERequest() {
        RequestSpecification request = RestAssured.given().queryParam("name", courseName);
        deleteResponse = request.delete(endpoint);
        System.out.println(endpoint);
    }

    @Then("the delete should be successful with status code {int}")
    public void verifyStatusCode(int statusCode) {
        Assert.assertEquals(statusCode, deleteResponse.getStatusCode());
    }

}
