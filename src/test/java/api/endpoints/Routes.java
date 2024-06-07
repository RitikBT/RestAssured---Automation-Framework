package api.endpoints;



public class Routes {
	
	/**
	 * Only we put URL in this clss...
	 */
	
	
	/*
	 
	 Swagger URI - https://petstore.swagger.io/
	 
	 Create user(Post) :  https://petstore.swagger.io/v2/user
	 get user(Get)	   : https://petstore.swagger.io/v2/user/{username}
	 Update user (Put) : https://petstore.swagger.io/v2/user/{username}
	 Delete user (Delete) : https://petstore.swagger.io/v2/user/{username}
	 
	 */
	
	public static final String BASE_URL = "https://petstore.swagger.io/v2";
	
	
	// User Module
	public static String POST_URL = BASE_URL + "/user";
	public static String  GET_URL = BASE_URL + "/user/{username}";
	public static String  UPDATE_URL = BASE_URL + "/user/{username}";
	public static String  DELETE_URL = BASE_URL + "/user/{username}";
	
	// Store Module
		// Here we will create store module URL's
	
	
	//  Pet Module
		// Here we will create pet module URL's
	

}
