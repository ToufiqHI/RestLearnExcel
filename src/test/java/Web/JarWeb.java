package Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JarWeb
{
    public static void main(String[] args)
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.myjar.app/");
        driver.manage().window().maximize();
        WebElement features=driver.findElement(By.xpath("//div[.=\"Features\"]"));
        driver.close();
    }
}
