package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.PayloadPojo;

import static io.restassured.RestAssured.given;

public class StepDefinitions {
    private Response response;

    @Given("The user invokes API URI")
    public void the_user_invokes_api_uri() {
        RestAssured.baseURI = "https://www.mycgmtest.com/apitest/synonyms";
    }

    @When("The user sends the request")
    public void the_user_sends_the_request() {
        response = given().log().all().contentType(ContentType.JSON).header("headerKey", "headerValue")
                .body(PayloadPojo.toJsonString("test", "ASC")) //searchString variable is mandatory
                .when().get();
    }

    @Then("The user receives a {string} response")
    public void theUserReceivesAResponse(String statusCode) {
        response.then().log().all().assertThat().statusCode(Integer.parseInt(statusCode));
    }
}
