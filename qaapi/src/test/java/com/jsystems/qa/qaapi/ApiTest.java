package com.jsystems.qa.qaapi;

import com.jsystems.qa.qaapi.model.error.ErrorResponse;
import com.jsystems.qa.qaapi.model.user.MyUser;
import com.jsystems.qa.qaapi.model.user.User;
import com.jsystems.qa.qaapi.model.user.UserAzure;
import com.jsystems.qa.qaapi.service.ApiService;
import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.hamcrest.core.Is.is;
//import static org.hamcrest.core.IsEqual.equalTo;
//import static org.junit.jupiter.api.Assertions.assertTrue;



@DisplayName("Api tests")
public class ApiTest {

    @Test
    public void firstApiTest(){
        RestAssured
                .given()
                .get("http://www.mocky.io/v2/5a6b69ec3100009d211b8aeb")
                .then()
                .assertThat()
                .statusCode(200)
                .body("name", equalTo("Piotr"))
                .body("surname", equalTo("Kowalski"));
    }

    @Test
    public void nestedTest() {
        RestAssured
                .given()
                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789")
                .then()
                .assertThat()
                .statusCode(200)
                .body("[0].imie", notNullValue())
                .body("[0].imie", equalTo("Piotr"))
                .body("[0].nazwisko", notNullValue())
                .body("[0].nazwisko", equalTo("Kowalski"))
                .body("[0].device[0].type", equalTo("computer"));
    }

    @Test
    @DisplayName("First test with mapping do jsonPath")
    public void jasonPathTest(){

        List<User> users = ApiService.getUsers();

//        assertThat(users.get(0).imie.isEqualTo("Piotr");
//        assertThat(users.get(0).nazwisko.isEqualTo("Kowalski");
//        assertThat(users.get(0).device.get(0).type.isEqualTo("computer");
//        assertThat(users.get(0).device.get(0).deviceModel.get(0).produce.isEqualTo("dell");
//        assertThat(users.get(0).device.get(0).deviceModel.get(0).screenSize.isEqualTo(17);

        assertThat(users.get(0).imie, equalTo("Piotr"));
        assertThat(users.get(0).nazwisko, equalTo("Kowalski"));
        assertThat(users.get(0).device.get(0).type, equalTo("computer"));
        assertThat(users.get(0).device.get(0).deviceModel.get(0).produce, equalTo("dell"));
        assertThat(users.get(0).device.get(0).deviceModel.get(0).screenSize, equalTo(17));

    }

    @Test
    @DisplayName("Test with mapped of MyUser")
    public void myUserJsonPath(){

        MyUser myUser = ApiService.getUser();

//        assertThat(myUser.name).isEqualTo("Piotr");
//        assertThat(myUser.surname).isEqualTo("Kowalski");

        assertThat(myUser.name, equalTo("Piotr"));
        assertThat(myUser.surname, equalTo("Kowalski"));

    }

    @Test
    @DisplayName("Post test")
    public void postTest(){

        String[] strings = ApiService.postMyUser(new MyUser("Piotr", "Kowalki"));
//        assertThat((strings), isEmptyString());
//        assertThat(strings).isEmpty();
        assertTrue(Arrays.asList(strings).isEmpty());

    }

    @Test
    @DisplayName("Error test")
    public void getErrorResponse() {
        ErrorResponse errorResponse = ApiService.getUserErrorResponse();

        assertThat(errorResponse.Error.errorCode, is(400));
        assertThat(errorResponse.Error.validationError, equalTo("invalid_email"));
        assertThat(errorResponse.Error.message, equalTo("your email is invalid"));
    }


    @Test
    public void azureUser(){

        UserAzure userAzure = ApiService.getUserAzureById(1);

        assertThat(userAzure.id, is(1));
        assertThat(userAzure.userName, equalTo("User_1"));
        assertThat(userAzure.password, equalTo("Password_1"));
    }

}
