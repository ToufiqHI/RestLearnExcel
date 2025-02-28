package Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Tabs extends GenericScript
{
    @Test(priority = 1)
    public void openTabs()
    {
       WebElement Gifting=driver.findElement(By.xpath("//p[.=\"Gifting\"]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(Gifting).perform();
       WebElement Earrings=driver.findElement(By.xpath("//p[.=\"Earrings\"]"));
        Actions action=new Actions(driver);
        actions.moveToElement(Earrings).perform();

       WebElement gift_for_her=driver.findElement(By.xpath("//a[.=\"Gifts For Her\"]"));
        gift_for_her.click();
        driver.navigate().back();
       WebElement gift_for_him=driver.findElement(By.xpath("//a[.=\"Gifts For Him\"]"));
        gift_for_him.click();
        driver.navigate().back();
       WebElement budget_friendly=driver.findElement(By.xpath("//a[.=\"Budget Friendly Finds\"]"));
        budget_friendly.click();
        driver.navigate().back();
       WebElement under_RS10000=driver.findElement(By.xpath("//a[.=\"Under Rs 10,000\"]"));
        under_RS10000.click();
        driver.navigate().back();
       WebElement under_Rs20000=driver.findElement(By.xpath("//a[.=\"Under Rs 20,000\"]"));
        under_Rs20000.click();
        driver.navigate().back();

        ArrayList list=new ArrayList<>();
        list.add(gift_for_her);
        list.add(gift_for_him);
        list.add(budget_friendly);
        list.add(under_RS10000);
        list.add(under_Rs20000);
       int count=list.size();
        for (int i=0; i<count; i++)
        {
          WebElement we= (WebElement) list.get(i);
          System.out.println(we.getText());
        }

    }

}
