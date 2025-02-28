package Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args)
    {
        //System.setProperty("webdriver.chrome.driver","/Users/spare/Downloads/selenium/chromedriver-mac-arm64/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("https://shopnek.com/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[.=\"Login\"]")).click();
        System.out.println( driver.findElement(By.xpath("//button[.=\"Login\"]")).getText());
        driver.findElement(By.xpath("//label[.=\"Enter your phone number\" and @for=\"react-aria5992738756-:r5:\" ]")).sendKeys("13265235667");

//        try {
//
//            driver.findElement(By.className("z-0 group relative inline-flex items-center justify-center box-border appearance-none select-none whitespace-nowrap subpixel-antialiased overflow-hidden tap-highlight-transparent outline-none data-[focus-visible=true]:z-10 data-[focus-visible=true]:outline-2 data-[focus-visible=true]:outline-focus data-[focus-visible=true]:outline-offset-2 px-4 min-w-20 gap-2 [&>svg]:max-w-[theme(spacing.8)] data-[pressed=true]:scale-[0.97] transition-transform-colors-opacity motion-reduce:transition-none data-[hover=true]:opacity-hover bg-primary-default text-white py-2 rounded-full h-12 text-base font-medium disabled:bg-grey-300 disabled:text-white")).click();
//        }
//        catch (Exception E )
//        {
//            System.out.println(" Exception");
//        }

     // driver.close();


    }
}