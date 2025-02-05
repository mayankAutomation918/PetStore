package apiEndpoints;

import apiPayloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class UserEndpoints2 {

    static ResourceBundle getURL(){

        ResourceBundle resourceBundle = ResourceBundle.getBundle("routes");
        return resourceBundle;
    }

    public static Response createUser(User user){

        String post_url = getURL().getString("post_url");

        Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(user)
                .when().post(post_url);

        return response;
    }
    public static Response getUser(String userName){

        String get_url = getURL().getString("get_url");

        Response response = given().pathParam("username",userName)
                .when().get(get_url);
        return response;
    }
    public static Response updateUser(User payload,String userName){

        String put_url = getURL().getString("put_url");

        Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).pathParam("username",userName).body(payload)
                .when().put(put_url);

        return response;
    }
    public static Response deleteUser(String userName){

        String delete_url = getURL().getString("delete_url");

        Response response = given().pathParam("username",userName)
                .when().delete(delete_url);
        return response;
    }

}
