package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTest {
	
	
	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testPostUser(String UserID, String userName, String fname, String lname, String userEmail, String password, String phone) {
		
		User user = new User();
		user.setId(Integer.valueOf(UserID));
		user.setUserName(userName);
		user.setFirstName(fname);
		user.setLastName(lname);
		user.setPassword(password);
		user.setPhone(phone);
		user.setEmail(userEmail);
		
		

		Response response = UserEndpoints.createUser(user);
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200, "Status code is not correct");

	}

}
