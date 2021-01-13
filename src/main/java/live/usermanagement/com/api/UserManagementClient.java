package live.usermanagement.com.api;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import live.usermanagement.com.api.model.User;

public class UserManagementClient {
		private static final String GET_USERS_ENDPOINT_URL="http://localhost:8080/api/users";
		private static final String GET_USER_ENDPOINT_URL = "http://localhost:8080/api/users/{id}";
	    private static final String CREATE_USER_ENDPOINT_URL = "http://localhost:8080/api/users";
	    private static final String UPDATE_USER_ENDPOINT_URL = "http://localhost:8080/api/users/{id}";
	    private static final String DELETE_USER_ENDPOINT_URL = "http://localhost:8080/api/users/{id}";
	    
	    private static RestTemplate restTemplate = new RestTemplate();
	    
	    public static void main(String[] args) {
	    	UserManagementClient userManagementClient = new UserManagementClient();
	    	
	    	userManagementClient.createUser();
	    	userManagementClient.getUserById();
	    	userManagementClient.getUsers();
	    	userManagementClient.updateUser();
	    	userManagementClient.deleteUser();
	    	
	    }
	    
	    private void getUsers() {
	    	 HttpHeaders headers = new HttpHeaders();
	         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	         HttpEntity < String > entity = new HttpEntity < String > ("parameters", headers);

	         ResponseEntity < String > result = restTemplate.exchange(GET_USERS_ENDPOINT_URL, HttpMethod.GET, entity,
	             String.class);

	         System.out.println(result);
	    }
	    
	    private void getUserById() {

	        Map < String, String > params = new HashMap < String, String > ();
	        params.put("id", "9");

	        RestTemplate restTemplate = new RestTemplate();
	        User result = restTemplate.getForObject(GET_USER_ENDPOINT_URL, User.class, params);

	        System.out.println(result);
	    }

	    private void createUser() {

	        User newUser = new User(9, "admin", "admin", "admin@gmail.com");

	        RestTemplate restTemplate = new RestTemplate();
	        User result = restTemplate.postForObject(CREATE_USER_ENDPOINT_URL, newUser, User.class);

	        System.out.println(result);
	    }

	    private void updateUser() {
	        Map < String, String > params = new HashMap < String, String > ();
	        params.put("id", "9");
	        User updatedUser = new User(9, "admin123", "admin123", "admin123@gmail.com");
	        RestTemplate restTemplate = new RestTemplate();
	        restTemplate.put(UPDATE_USER_ENDPOINT_URL, updatedUser, params);
	    }

	    private void deleteUser() {
	        Map < String, String > params = new HashMap < String, String > ();
	        params.put("id", "9");
	        RestTemplate restTemplate = new RestTemplate();
	        restTemplate.delete(DELETE_USER_ENDPOINT_URL, params);
	    }
}
