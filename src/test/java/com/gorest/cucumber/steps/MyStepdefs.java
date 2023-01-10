package com.gorest.cucumber.steps;

import com.gorest.steps.UsersSteps;
import com.gorest.utils.PropertyReader;
import com.gorest.utils.TestUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

import static org.hamcrest.CoreMatchers.equalTo;


public class MyStepdefs {

    @Steps
    UsersSteps usersSteps;
    static String token = PropertyReader.getInstance().getProperty("token");
    static String name = null;
    static String gender = null;
    static String email =  TestUtils.getRandomValue()+ "@email.com";
    static String status = null;
    static int userID;
    @When("^I create a new user by providing the information name \"([^\"]*)\" gender \"([^\"]*)\" email \"([^\"]*)\" status \"([^\"]*)\"$")
    public void iCreateANewUserByProvidingTheInformationNameGenderEmailStatus(String name, String gender, String _email, String status)  {
        email=name+email;
        ValidatableResponse response = usersSteps.createUser(name, gender, email, status, token);
        response.log().all().statusCode(201);
        userID = response.log().all().extract().path("id");
    }

    @Then("^I verify new user is created$")
    public void iVerifyNewUserIsCreated() {
      ValidatableResponse response = usersSteps.getUserByID(userID, token);
      response.statusCode(200).body("id", equalTo(userID));
    }

    @When("^I update user with name \"([^\"]*)\" gender \"([^\"]*)\" email \"([^\"]*)\" status \"([^\"]*)\"$")
    public void iUpdateUserWithNameGenderEmailStatus(String name, String gender, String email, String status)  {
       email = TestUtils.getRandomValue() +email;
        ValidatableResponse response = usersSteps.updateUser(name, gender, userID, email, status, token).statusCode(200).log().all();
        response.statusCode(200);
    }

    @Then("^I verify the response has \"([^\"]*)\" status code$")
    public void iVerifyTheResponseHasStatusCode(String arg0)  {

    }


    @When("^I delete user with name \"([^\"]*)\" gender \"([^\"]*)\" email \"([^\"]*)\" status \"([^\"]*)\"$")
    public void iDeleteUserWithNameGenderEmailStatus(String name, String gender, String email, String status)  {
        usersSteps.deleteUser(userID, token).statusCode(204);
        usersSteps.getUserByID(userID, token).statusCode(404);
    }

    @Then("^I verify the response has status code$")
    public void iVerifyTheResponseHasStatusCode() {
    }
}