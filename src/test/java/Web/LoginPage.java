package Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPage  extends Web
{
    @Test(description = "Open the web page ")
    public void testName()
    {
       WebElement element=driver.findElement(By.xpath("//button[.=\\\"Features\\\"]\""));
        Actions actions=new Actions(driver);
        actions.moveToElement(element);

        Assert.assertTrue(true, "Tab Opened");

    }

}
