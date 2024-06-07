package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints1;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest1 {

	Faker fake;
	User userPayload;
	
	
	@BeforeClass
	public void setUpData() {
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

	Response response = UserEndpoints1.createUser(userPayload);
	response.then().log().all();

	Assert.assertEquals(response.getStatusCode(), 200, "Status code is not correct");

}

@Test(priority = 2)
public void testGetUser() {
		Response response = UserEndpoints1.getUser(this.userPayload.getUserName());
	response.then().log().all();
	Assert.assertEquals(response.getStatusCode(), 200, "Status code is not correct");
	
	
}
	
}
