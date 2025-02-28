package __4_PojoSample;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class Test2 {
    public static void main(String[] args) {
        String response = given()
                .formParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
                .formParams("grant_type", "client_credentials")
                .formParams("scope", "trust")
                .when().log().all()
                .post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token")
                .asString();

        System.out.println("Raw Token Response: " + response);

        JsonPath jsonPath = new JsonPath(response);
        String accessToken = jsonPath.getString("access_token");
        System.out.println("Access Token: " + accessToken);

        // Fetch API response
        String rawResponse = given()
                .queryParams("access_token", accessToken)
                .when()
                .get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
                .asString();

        System.out.println("Raw API Response: " + rawResponse);

        // Deserialize response
        GetCourse response1 = given()
                .queryParams("access_token", accessToken)
                .when()
                .get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
                .as(GetCourse.class);

        if (response1 == null) {
            System.out.println("Deserialization failed: response1 is null");
            return;
        }

        System.out.println("LinkedIn: " + response1.getLinkedIn());
        System.out.println("URL: " + response1.getUrl());

        if (response1.getCourses() == null) {
            System.out.println("Courses object is null!");
            return;
        }

        // Print API courses
        if (response1.getCourses().getApi() != null) {
            System.out.println("API Courses:");
            for (ApiCourse course : response1.getCourses().getApi()) {
                System.out.println("Course Title: " + course.getCourseTitle());
                System.out.println("Price: " + course.getPrice());
            }
        }

        // Print Web Automation courses
        if (response1.getCourses().getWebAutomation() != null) {
            System.out.println("\nWeb Automation Courses:");
            for (ApiCourse course : response1.getCourses().getWebAutomation()) {
                System.out.println("Course Title: " + course.getCourseTitle());
                System.out.println("Price: " + course.getPrice());
            }
        }

        // Print Mobile courses
        if (response1.getCourses().getMobile() != null) {
            System.out.println("\nMobile Courses:");
            for (ApiCourse course : response1.getCourses().getMobile()) {
                System.out.println("Course Title: " + course.getCourseTitle());
                System.out.println("Price: " + course.getPrice());
            }
        }
    }
}
