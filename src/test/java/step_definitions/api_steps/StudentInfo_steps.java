package step_definitions.api_steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class StudentInfo_steps {
    Response response;
    RequestSpecification request;
    String studentId;
    String url ="https://tla-school-api.herokuapp.com/api/school/resources/students";

    @Given("I perform a POST request to create new student info with following fields")
    public void iPerformAPOSTRequestToCreateNewStudentInfoWithFollowingFields(DataTable dataTable) {
        request = RestAssured.given()
                .header("Content-Type", "application/json");

        Map<String, String> data = dataTable.asMap(String.class, String.class);
        String requestBody = "{ " +
                "\"firstName\": \"" + data.get("firstName") + "\"," +
                "\"lastName\": \"" + data.get("lastName") + "\"," +
                "\"batch\": " + data.get("batch") + "," +
                "\"email\": \"" + data.get("email") + "\"" +
                "}";
        request.body(requestBody);

        response = request.post("https://tla-school-api.herokuapp.com/api/school/resources/students");
        studentId = response.jsonPath().getString("data._id");
        System.out.println(studentId);
    }

    @When("I perform a PUT request using id parameter to update the following fields")
    public void performPUTRequest(DataTable dataTable) {
        request = given()
                .header("Content-Type", "application/json")
                .queryParam("key", "d03e989018msh7f4691c614e87a9p1a8181j");

        Map<String, String> data = dataTable.asMap(String.class, String.class);
        String requestBody = "{ " +
                "\"batch\": " + data.get("batch") + "," +
                "\"email\": \"" + data.get("email") + "\"" +
                "}";
        request.body(requestBody);

        response = request.put(url+"/"+studentId).then().log().all().extract().response();
    }

    @Then("verify the update should be successful with status code {int}")
    public void verifyUpdateResponse(int statusCode) {
        response = response.then().log().all().extract().response();
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, actualStatusCode);
    }
}


