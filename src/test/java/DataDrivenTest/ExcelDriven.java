package DataDrivenTest;

import __3_Library.AddBook;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ExcelDriven
{
    @Test(description = "test description")
    public void postDatXml() throws Exception
    {
        dataDriven d=new dataDriven();
        ArrayList data =d.getData("AddProfile","testData");

//        HashMap<String,Object> map=new HashMap<>();
//        map.put("",""); //// Pass key value of body
        HashMap<String,Object> map=new HashMap<>();
        map.put("name",data.get(0));




        RestAssured.baseURI="http://216.10.245.166/Library/";
        Response response= given().header("Content-Type","application/json")
//                .body(map)
                .body("")
                .post("Addbook.php")
                .then().assertThat().statusCode(HttpStatus.SC_OK).extract().response();
        String ID= response.jsonPath().getString("ID");
        response.jsonPath().prettyPrint();
        System.out.println(ID);

    }
}
