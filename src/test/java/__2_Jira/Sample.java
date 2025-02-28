package __2_Jira;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Sample
{
    //given= all input details
    // when = submit the API  : resource and endpoint
    //then = validate the API

    @Test(description = "test description")
    public void testName()
    {
        RestAssured.baseURI="";
        Response response=given().headers("","")
                          .body("")
                        .when().post()
                        .then().assertThat().statusCode(HttpStatus.SC_OK).extract().response();
        Assert.assertEquals("",response);

    }
}
