package apiTests;

import apiEndpoints.UserEndpoints;
import apiPayloads.User;
import apiUtilities.DataProviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DDTests {

    @Test(priority = 1, dataProvider = "testData", dataProviderClass = DataProviders.class)
    public void postUser(String UserId, String UserName, String FirstName, String LastName, String email, String password, String phone){

        User userPayload = new User();

        userPayload.setId(Double.parseDouble(UserId));
        userPayload.setUsername(UserName);
        userPayload.setFirstName(FirstName);
        userPayload.setLastName(LastName);
        userPayload.setEmail(email);
        userPayload.setPassword(password);
        userPayload.setPhone(phone);

        System.out.println(userPayload.getUsername());

        Response response = UserEndpoints.createUser(userPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

    }
    @Test(priority = 2, dataProvider = "userName", dataProviderClass = DataProviders.class)
    public void getUser(String userName){
        System.out.println(userName);
        Response response = UserEndpoints.deleteUser(userName);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

    }
}
