package step_definitions.api_steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utils.CucumbersLogUtils;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class StudentInfo_steps {
    Response response;
    RequestSpecification request;
    String studentId;
    String endpoint = "https://tla-school-api.herokuapp.com/api/school/resources/students";

    @Given("I perform a POST request to create new student info with following fields")
    public void iPerformAPOSTRequestToCreateNewStudentInfoWithFollowingFields(Map<String, String> data) {
        request = RestAssured.given()
                .header("Content-Type", "application/json");

        String requestBody = "{ " +
                "\"firstName\": \"" + data.get("firstName") + "\"," +
                "\"lastName\": \"" + data.get("lastName") + "\"," +
                "\"batch\": " + data.get("batch") + "," +
                "\"email\": \"" + data.get("email") + "\"" +
                "}";
        request.body(requestBody);

        response = request.post(endpoint);
        studentId = response.jsonPath().getString("data._id");
        System.out.println(studentId);
    }

    @When("I perform a PUT request using id parameter to update the following fields")
    public void performPUTRequest(Map<String, String> data) {
        request = given()
                .header("Content-Type", "application/json")
                .queryParam("key", "d03e989018msh7f4691c614e87a9p1a8181j");

        String requestBody = "{ " +
                "\"batch\": " + data.get("batch") + "," +
                "\"email\": \"" + data.get("email") + "\"" +
                "}";
        request.body(requestBody);

        response = request.put(endpoint + "/" + studentId).then().log().all().extract().response();
    }

    @Then("verify the update should be successful with status code {int}")
    public void verifyUpdateResponse(int statusCode) {
        response = response.then().log().all().extract().response();
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, actualStatusCode);
    }

    @When("I send a GET request")
    public void sendGETRequest() {
        response = RestAssured.given()
                .get(endpoint);
    }

    @Then("verify the response body contains the following fields")
    public void theResponseBodyContainsTheFollowingFields(List<String> expectedFields) {
        response = response.then().log().all().extract().response();
        CucumbersLogUtils.logInfo(response.asPrettyString(),false);
        for (String field : expectedFields) {
            Assert.assertTrue(response.getBody().asString().contains(field));
        }
    }

    @Given("I perform a post request to create new student info with following fields")
    public void iPerformAPostRequestToCreateNewStudentInfoWithFollowingFields(Map<String, String> data) {
        request = RestAssured.given()
                .header("Content-Type", "application/json");

        String requestBody = "{ " +
                "\"firstName\": \"" + data.get("firstName") + "\"," +
                "\"lastName\": \"" + data.get("lastName") + "\"," +
                "\"batch\": " + data.get("batch") + "," +
                "\"email\": \"" + data.get("email") + "\"" +
                "}";
        request.body(requestBody);

        response = request.post(endpoint);
        studentId = response.jsonPath().getString("data._id");
        System.out.println(studentId);
    }

    @When("I perform a DELETE request using student id parameter")
    public void iPerformADELETERequestUsingStudentIdParameter() {
        request = given()
                .header("Content-Type", "application/json")
                .queryParam("key", "d03e989018msh7f4691c614e87a9p1a8181j");

        response = request.delete(endpoint + "/" + studentId).then().log().all().extract().response();
    }

    @Then("verify the DELETE should be successfully with status code {int}")
    public void verifyTheDELETEShouldBeSuccessfullyWithStatusCode(int statusCode) {

        response = response.then().log().all().extract().response();
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, actualStatusCode);

    }
}


