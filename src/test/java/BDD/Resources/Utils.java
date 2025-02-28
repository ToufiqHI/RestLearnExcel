package BDD.Resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils
{
    public static RequestSpecification req;
    public static RequestSpecification requestSpecification() throws Exception
    {
        if (req==null)
        {
            // Correcting PrintStream instantiation
            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
            req = new RequestSpecBuilder()
                    .setBaseUri(getGlobalValue("baseUri"))
                    .setContentType(ContentType.JSON)
                    .addQueryParam("key","qaclick123")
                    .addFilter(RequestLoggingFilter.logRequestTo(log)) // Logging requests
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .build();
            return req;
        }
        return req;
    }
    public static String getGlobalValue(String key) throws Exception
    {
        Properties prop = new Properties();
        String path = System.getProperty("user.dir") + "/src/test/java/BDD/Resources/Global.properties";
        FileInputStream file = new FileInputStream(path);
        prop.load(file);

        if (prop.getProperty(key) != null) {
            return prop.getProperty(key);
        } else {
            throw new Exception("Key '" + key + "' not found in Global.properties");
        }
    }
    public String getJsonPath(Response response , String key)
    {
       String resp=response.asString();
      JsonPath js=new JsonPath(resp);
              return js.get(key).toString();

    }

}
