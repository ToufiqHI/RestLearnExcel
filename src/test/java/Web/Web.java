package Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class Web
{
    public static WebDriver driver;
    @BeforeMethod
    public void openTab()
    {
//            System.setProperty("webdriver.chrome.driver", "/Users/spare/Downloads/selenium/chromedriver-mac-arm64/chromedriver");
            driver = new ChromeDriver();
            driver.get("https://www.myjar.app/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);

    }

    @Test(description = "test description")
    public void Run()
    {
//        driver.findElement(By.className(""));
        String Title=driver.getTitle();
        System.out.println(Title);
       WebElement ele=driver.findElement(By.xpath("(//div[.=\"About us\"])[1]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(ele).perform();
    }

        @AfterMethod
        public void closeTab()
        {
//            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            driver.quit();
        }


}
