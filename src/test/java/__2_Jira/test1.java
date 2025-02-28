package __2_Jira;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class test1
{
    public static void main(String[] args) throws InterruptedException
{

    String response = given().formParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
            .formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
            .formParams("grant_type", "client_credentials")
            .formParams("scope", "trust").when().log().all()
            .post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();

    System.out.println(response);

    JsonPath jsonPath = new JsonPath(response);

     String accessToken = jsonPath.getString("access_token");
    System.out.println(accessToken);
    Response response1 = given().queryParams("access_token", accessToken)
            .when()
            .get("https://rahulshettyacademy.com/oauthapi/getCourseDetails");

        int count=response1.jsonPath().get("courses.size()");
        System.out.println(response1.jsonPath().prettyPrint());

}


}