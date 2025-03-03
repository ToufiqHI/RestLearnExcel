package DataDrivenTest;

import Exa.LoginResponse;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class LoginViaExcel
{
    @Test(description = "test description")
    public void Login() throws Exception
    {
        dataDriven d = new dataDriven();
        ArrayList<String> data = d.getData("login", "Test");
        HashMap<String, Object> map = new HashMap<>();
        map.put("userEmail", data.get(0));
        map.put("userPassword", data.get(1));

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        Response response = given().relaxedHTTPSValidation().log().all()
                .header("Content-Type", "application/json")
                .header("Content-Length","<calculated when request is sent>")
                .header("Host","<calculated when request is sent>").log().all()
                .body(map)
                .log().all()
                .post("/api/ecom/auth")
                .then().log().all()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response();
        System.out.println(response.jsonPath().prettyPrint());




    }
}
