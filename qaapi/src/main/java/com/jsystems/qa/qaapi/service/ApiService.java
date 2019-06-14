package com.jsystems.qa.qaapi.service;

import com.jsystems.qa.qaapi.model.error.ErrorResponse;
import com.jsystems.qa.qaapi.model.user.MyUser;
import com.jsystems.qa.qaapi.model.user.User;
import com.jsystems.qa.qaapi.model.user.UserAzure;
import com.jsystems.qa.qaapi.specification.Specification;
import io.restassured.RestAssured;

import java.util.List;

public class ApiService {

    private static final String USERS_LIST = "/5a6a58222e0000d0377a7789";
    private static final String USER = "/5a6a58222e0000d0377a7789";
//    private static final String USER_2 = "???";
    private static final String POST_URL = "/5a690a1b2e000051007a73cb";
    private static final String ERROR_URL = "/5a690b452e000054007a73cd";


    public static List<User> getUsers(){

        return RestAssured
                .given()
//                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789")
                .spec(Specification.requestSpecBulider())
//                .get("/5a6a58222e0000d0377a7789")
                .get(USERS_LIST)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getList("", User.class);

    }

    public static MyUser getUser(){

        return RestAssured
                .given()
                .spec(Specification.requestSpecBulider())
//                .get("/5a6a58222e0000d0377a7789")
                .get(USER)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getObject("", MyUser.class);

    }

    public static String[] postMyUser (MyUser user){

        return RestAssured.given()
                .spec(Specification.requestSpecBulider())
                .body(user)
                .post(POST_URL)
                .andReturn()
                .then()
                .assertThat()
                .statusCode(201)
                .extract()
                .as(String[].class);

    }

    public static ErrorResponse getUserErrorResponse() {
        return  RestAssured.given()
                .spec(Specification.requestSpecBulider())
                .when()
                .get(ERROR_URL)
                .then()
                .assertThat()
                .statusCode(400)
                .extract()
                .body()
                .as(ErrorResponse.class);
    }

    public static UserAzure getUserAzureById(long id) {
        return RestAssured.given()
                .spec(Specification.fakeAzureSpecBuilder())
//                .queryParam("name", "Piotr")
//                .queryParam("surname", "Kowalski")
                .when()
                .get("/api/Users/{id}", id)
                .andReturn()
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .as(UserAzure.class);

    }

}
