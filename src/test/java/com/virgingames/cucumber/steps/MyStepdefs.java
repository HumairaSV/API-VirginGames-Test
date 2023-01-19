package com.virgingames.cucumber.steps;

import com.virgingames.gamesinfo.BingoFeedSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasValue;

public class MyStepdefs {
    @Steps
    BingoFeedSteps bingoFeedSteps;
    static ValidatableResponse response;


    @Given("^I am on the Virgin games bingo api$")
    public void iAmOnTheVirginGamesBingoApi() {
    }

    @When("^I send Get request to the Lobby feed endpoint$")
    public void iSendGetRequestToTheLobbyFeedEndpoint() {
        response = bingoFeedSteps.getBingoLobbyFeed();

    }

    @Then("^I must get back a valid status code \"([^\"]*)\"$")
    public void iMustGetBackAValidStatusCode(int code) {
        response.statusCode(code);
    }


    @And("^I verify that the database has stream name \"([^\"]*)\" in streams at index 1$")
    public void iVerifyThatTheDatabaseHasStreamNameInStreamsAtIndex(String streamName) {
        HashMap<String, Object> streamMap = bingoFeedSteps.getStreamNameFromStreams(streamName);
        Assert.assertThat(streamMap, hasValue(streamName));


    }
}
