package FibrRule;

import DataDrivenTest.dataDriven;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class Runner
{
       dataDriven d=new dataDriven();
     @Test(description = "test description")
     public void rule() throws Exception
     {
         ArrayList<String> testData = d.getData("", "");
         FibeRuleEngine fileRuleEngine = new FibeRuleEngine();
         // Map Excel values to FileRuleEngine properties with proper type conversion
         fileRuleEngine.setAge(testData.get(0)); // String
         fileRuleEngine.setIncome(Integer.parseInt(testData.get(1))); // int
         fileRuleEngine.setSalaried(Boolean.parseBoolean(testData.get(2))); // boolean
         fileRuleEngine.setResidentialCityTier(Integer.parseInt(testData.get(3))); // int
         fileRuleEngine.setResidentialPinCodeServiceable(Boolean.parseBoolean(testData.get(4))); // boolean
         fileRuleEngine.setOfficeCityTier(Integer.parseInt(testData.get(5))); // int
         fileRuleEngine.setOfficePinCodeServiceable(Boolean.parseBoolean(testData.get(6))); // boolean
         fileRuleEngine.setTotalDue(Integer.parseInt(testData.get(7))); // int


     }
}
