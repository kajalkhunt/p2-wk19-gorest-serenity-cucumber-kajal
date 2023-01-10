package com.gorest.crudtests;

import com.gorest.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class TagsTest extends TestBase {
    //this is negative test case
    @WithTag("gorestfeature:NEGATIVE")
    @Title("Provide a 500 status code when incorrect HTTP method is used to access resource")
    @Test
    public void invalidMethod() {
        SerenityRest.rest()
                .given()
                .when()
                .get("/users")
                .then()
                .statusCode(500)
                .log().all();
    }
    //this is positive test case
    @WithTags({
            @WithTag("gorestfeature:SMOKE"),
            @WithTag("gorestfeature:POSITIVE")
    })
  //  @WithTag("gorestfeature:SMOKE")
    @Title("This test will verify if a status code of 200 is returned for GET request")
    @Test
    public void verifyIfTheStatusCodeIs200() {
        SerenityRest.rest()
                .given()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .log().all();
    }

}
