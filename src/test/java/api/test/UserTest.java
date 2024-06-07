package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {

	Faker fake;
	User userPayload;

	@BeforeClass
	public void generateTestData() {
		fake = new Faker();
		userPayload = new User();

		userPayload.setId(fake.idNumber().hashCode());
		userPayload.setUserName(fake.name().username());
		userPayload.setFirstName(fake.name().firstName());
		userPayload.setLastName(fake.name().lastName());
		userPayload.setEmail(fake.internet().safeEmailAddress());
		userPayload.setPassword(fake.internet().password(5, 10));
		userPayload.setPhone(fake.phoneNumber().cellPhone());
	}

	@Test(priority = 1)
	public void testPostUser() {

		Response postResponse = UserEndpoints.createUser(userPayload);
		postResponse.then().log().all();

		Assert.assertEquals(postResponse.getStatusCode(), 200, "Status code is not correct");

	}

	@Test(priority = 2)
	public void testGetUser() {
		Response getResponse = UserEndpoints.getUser(this.userPayload.getUserName());
		getResponse.then().log().all();
		Assert.assertEquals(getResponse.getStatusCode(), 200, "Status code is not correct");

	}

	@Test(priority = 3)
	public void testUpdateUser() {

		userPayload.setFirstName(fake.name().firstName());
		Response updateResponse = UserEndpoints.updateUser(userPayload.getUserName(), userPayload);

		updateResponse.then().log().all();
		Assert.assertEquals(updateResponse.getStatusCode(), 200, "Status code is not correct");

//		Response responsePostResponse = UserEndpoints.getUser(this.userPayload.getUserName());
//		responsePostResponse.then().log().all();
	}
	
	@Test(priority = 4)
	public void testDeleteUser() {
		Response deleteResponse = UserEndpoints.deleteUser(userPayload.getUserName());
		deleteResponse.then().log().all();
		
		Assert.assertEquals(deleteResponse.statusCode(), 200, "Status code is  not matched");
		
	}

}
