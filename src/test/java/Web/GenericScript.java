package Web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class GenericScript
{
   public static WebDriver driver;
    @BeforeMethod
    public void openApp()
    {
        System.setProperty("webdriver.chrome.driver","/Users/spare/Downloads/selenium/chromedriver-mac-arm64/chromedriver");
        driver=new ChromeDriver();
        driver.get("https://shopnek.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void closeApp()
    {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.close();
    }
}
