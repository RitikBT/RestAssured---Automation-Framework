package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// Created for perform CRUD (Create, Read, Update & Delete) API

public class UserEndpoints {

	public static Response createUser(User payload) {

		Response response = given().contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(payload)
				.when().post(Routes.POST_URL);
		return response;
	}
	
	public static Response getUser(String userName)
	{
		Response response = given()
		.accept(ContentType.JSON)
		.pathParam("username", userName)
		
		.when()
		.get(Routes.GET_URL);
		
		return response;
	}


	public static Response updateUser(String userName, User payload) {
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.pathParam("username", userName).body(payload)
				.when().put(Routes.UPDATE_URL);

		return response;
	}

	public static Response deleteUser(String userName) {
		Response response = given().accept(ContentType.JSON).pathParam("username", userName)
				.when().delete(Routes.DELETE_URL);

		return response;

	}

}
