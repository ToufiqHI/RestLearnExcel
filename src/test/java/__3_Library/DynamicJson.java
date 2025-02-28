package __3_Library;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DynamicJson
{
    public static String ID;
    //given= all input details
        // when = submit the API  : resource and endpoint
        //then = validate the API
    //Add book
    @Test(dataProvider ="BooksData" )
    public  void addBook(String isbn,String aisle)
    {
        RestAssured.baseURI="http://216.10.245.166/Library/";
        Response response= given().header("Content-Type","application/json")
                .body(AddBook.addBook(isbn,aisle))// when  there is  multiple data
                //.body(AddBook.addBook("agdg","873487))  only one value we have passed
                .post("Addbook.php")
                .then().assertThat().statusCode(HttpStatus.SC_OK).extract().response();
        String ID= response.jsonPath().getString("ID");
        response.jsonPath().prettyPrint();
        System.out.println(ID);
    }
    // Delete book
//    @Test
//    public void deleteBook()
//    {
//        RestAssured.baseURI="http://216.10.245.166Library/";
//        Response response=given().header("Content-Type","application/json")
//                .body("ID")
//                .post("DeleteBook.php")
//                .then().assertThat().statusCode(200).extract().response();
//        response.jsonPath().prettyPrint();
//    }
    // Parameter passing
    @DataProvider(name = "BooksData")
    // array = collection of element
    // multidimensional arrays = collection arrays
    public Object[][] getData()
    {
        return new Object[][]{{"adfrshj","376476"},{"ghvdsa","1763674"},{"ghdghfgdh","6782466"}};
    }
}
