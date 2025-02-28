package __5_Pojo.ValidateBody;

import io.restassured.path.json.JsonPath;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Test2
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
        GetCourse response1 = given().queryParams("access_token", accessToken)
            .when()
            .get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(GetCourse.class);

        System.out.println( response1.getLinkedIn());
        System.out.println( response1.getUrl());
        System.out.println(response1.getCourses().getApi().get(1).getCourseTitle());
        List<Api> courseAPI=response1.getCourses().getApi();
        for (int i=0;i<courseAPI.size();i++)
        {
          System.out.println( courseAPI.get(i).getCourseTitle());
          System.out.println( courseAPI.get(i).getPrice());
        }
        System.out.println(accessToken);

         ValidatingBody res = given().queryParams("access_token", accessToken)
            .when()
            .get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(ValidatingBody.class);
        System.out.println( response1.getLinkedIn());
        System.out.println( response1.getUrl());

}


}