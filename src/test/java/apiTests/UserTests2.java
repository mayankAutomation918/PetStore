package apiTests;

import apiEndpoints.UserEndpoints2;
import apiPayloads.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTests2 {

    Faker data;
    User user;
    public Logger logger;
    @BeforeClass
    public void userTest(){

        data = new Faker();
        user = new User();

        user.setUserStatus(1);
        user.setFirstName(data.name().firstName());
        user.setLastName(data.name().lastName());
        user.setEmail(data.internet().emailAddress());
        user.setPassword(data.internet().password());
        user.setUsername(data.name().username());
        user.setPhone(data.phoneNumber().cellPhone());
        user.setId(data.idNumber().hashCode());
        System.out.println(user.getUsername());

        logger= LogManager.getLogger(this.getClass());
        logger.debug("-------Debugging-----------");

    }
   @Test(priority = 1)
    public void postUser(){
        logger.info("------------User Creation---------------");
        Response response = UserEndpoints2.createUser(user);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
       logger.info("------------User Created Successfully---------------");
    }
    @Test(priority = 2)
    public void getUser(){
        logger.info("------------Fetching User Details---------------");
        Response response = UserEndpoints2.getUser(user.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("------------User's Details Fetched Successfully---------------");
    }
    @Test(priority = 3)
    public void updateUser(){
        logger.info("------------Update User Details---------------");
        Response response = UserEndpoints2.updateUser(user, user.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("------------User Details Updated Successfully---------------");
    }
    @Test(priority = 4)
    public void deleteUser(){
        logger.info("------------User Deletion---------------");
        Response response = UserEndpoints2.deleteUser(user.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("------------User Deleted Successfully---------------");
    }

}
