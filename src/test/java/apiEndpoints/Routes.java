package apiEndpoints;

public class Routes {

    // Base URL ------
    public static String base_url = "https://petstore.swagger.io/v2";

    // USER urls -------

    public static String post_url = base_url+"/user";
    public static String get_url = base_url+"/user/{username}";
    public static String put_url = base_url+"/user/{username}";
    public static String delete_url = base_url+"/user/{username}";

}
