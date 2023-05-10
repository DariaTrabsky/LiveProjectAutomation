package step_definitions.api_steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class StudentInfo_steps {
    Response response;
    RequestSpecification request;
    String studentId;

    @Given("I perform a POST request to {string} to create new student info")
    public void performPOSTRequest(String url) {
        request = RestAssured.given()
         .header("Content-Type", "application/json")
         .body("{ \"firstname\": \"John\",\"lastname\": \"Doe\", \"batch\": 2000,\"email\": \"test@api.com\" }")
         .log().all();

        response = request.post(url);
    }

    @Given("I retrieve student id")
    public void retrieveStudentId() {
        studentId = response.jsonPath().getString("data._id");
        System.out.println("Retrieved student ID: " + studentId);
    }


    @When("To Update an existing, I perform a PUT request to {string} using id parameter")
    public void performPUTRequest(String url) {
        request= given()
                .header("Content-Type", "application/json")
                .header("Key", "d03e989018msh7f4691c614e87a9p1a8181j")
                //.pathParam("_id", studentId)
                .body("{ \"firstname\": \"John\",\"lastname\": \"Doe\", \"batch\": 2000,\"email\": \"Jonh@api.com\" }");

        response = request.put(url + "/"+studentId);
        System.out.println(studentId);
    }

    @Then("the update should be successful with status code {int}")
    public void verifyUpdateResponse(int statusCode) {
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, actualStatusCode);
    }

    @Then("verify the response contains the following fields")
    public void verifyResponseFields(DataTable dataTable) {
        for (Map<String, String> data : dataTable.asMaps()) {
            String fieldName = data.get("Field");
            String expectedValue = data.get("Value");

            response.then().assertThat().body(fieldName, equalTo(expectedValue));
        }
    }
}


