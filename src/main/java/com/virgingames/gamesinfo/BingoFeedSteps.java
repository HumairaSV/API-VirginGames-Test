package com.virgingames.gamesinfo;

import com.virgingames.constants.EndPoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasValue;

public class BingoFeedSteps {

    @Step("Getting the bingo lobby feed")
    public ValidatableResponse getBingoLobbyFeed() {
        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_FEED)
                .then();
    }

    @Step("Getting gameRef from streams at index 1")
    public HashMap<String, Object> getStreamNameFromStreams(String streamName) {
       String p1 = "bingoLobbyInfoResource.streams.findAll{it.streamName == '";
        String p2 = "'}.get(0)";

        RestAssured.registerParser("text/plain", Parser.JSON);

        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_FEED)
                .then()
                .statusCode(200)
                .extract()
                .path(p1 + streamName + p2);



    }

}
