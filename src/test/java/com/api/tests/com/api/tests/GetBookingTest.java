package com.api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetBookingTest {

    @Test
    public void getBookingById() {

        Response response =
                RestAssured
                        .given()
                        .when()
                        .get("https://restful-booker.herokuapp.com/booking/1");

        System.out.println(response.asPrettyString());

        // Status code check
        Assert.assertEquals(response.getStatusCode(), 200);

        // Basic validations
        Assert.assertNotNull(response.jsonPath().getString("firstname"));
        Assert.assertNotNull(response.jsonPath().getString("lastname"));
    }
}
