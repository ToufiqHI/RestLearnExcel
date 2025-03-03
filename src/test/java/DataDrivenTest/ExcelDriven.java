//package DataDrivenTest;
//
//import __3_Library.AddBook;
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//import org.apache.http.HttpStatus;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//import static io.restassured.RestAssured.given;
//
//public class ExcelDriven
//{
//    @Test(description = "test description")
//    public void postDatXml() throws Exception
//    {
//        dataDriven d=new dataDriven();
//        ArrayList data =d.getData("Addbook","TestData");
//        System.out.println("Extracted data from Excel: " + data);
////       HashMap<String,Object> map=new HashMap<>();
////
////
////        map.put("",""); //// Pass key value of body
//        HashMap<String,Object> map=new HashMap<>();
//        map.put("name",data.get(0));
//        map.put("isbn",data.get(1));
//        map.put("aisle",data.get(2));
//        map.put("author",data.get(3));
//
//        RestAssured.baseURI="http://216.10.245.166/Library/";
//        Response response= given().header("Content-Type","application/json")
////                .body(map)
//                .body(map)
//                .post("Addbook.php")
//                .then().assertThat().statusCode(HttpStatus.SC_OK).extract().response();
//           response.jsonPath().prettyPrint();
//
//    }
//}
package DataDrivenTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ExcelDriven {

    @Test(description = "Post book data from Excel")
    public void postData() throws Exception {
        dataDriven d = new dataDriven();
        ArrayList<String> data = d.getData("Addbook", "TestData");

        if (data.isEmpty()) {
            throw new IllegalStateException("No data found for the given test case!");
        }

        System.out.println("Extracted data from Excel: " + data);

        HashMap<String, Object> map = new HashMap<>();
        map.put("name", data.get(0));
        map.put("isbn", data.get(1));
        map.put("aisle", data.get(2));
        map.put("author", data.get(3));

        RestAssured.baseURI = "http://216.10.245.166/Library/";
        Response response = given()
                .header("Content-Type", "application/json")
                .body(map)
                .post("Addbook.php")
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response();

        response.jsonPath().prettyPrint();

        // Assert response contains "ID"
        Assert.assertNotNull(response.jsonPath().getString("ID"), "Book ID not generated!");
    }
}
