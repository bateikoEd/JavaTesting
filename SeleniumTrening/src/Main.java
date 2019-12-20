import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        String exePath = "/home/bateiko/Downloads/chromedriver_linux64/chromedriver";
        System.setProperty("webdriver.chrome.driver",exePath);
        WebDriver driver = new ChromeDriver();

        String url = "https://en.wikipedia.org/wiki/Main_Page";
        driver.get(url);
        /*String title = driver.getTitle();
        int TitleLenght = driver.getTitle().length();
        System.out.println("Title of the page is: " + title );
        System.out.println("Lenght: " + TitleLenght);
        String actualUrl = driver.getCurrentUrl();

        if(actualUrl.equals(url))
            System.out.println("Succes");
        else
        {
            System.out.println("failed");
            System.out.println("Actual URL: " +  actualUrl);
            System.out.println("failed " + url);
        }
        String pageSource = driver.getPageSource();
        int pageSourceLength =pageSource.length();
        System.out.println("Total length: " + pageSourceLength);
        */
        driver.findElement(By.linkText("Help")).click();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().to(url);
        driver.navigate().refresh();
//        TimeUnit.sleep(5000);
        driver.quit();
    }
}
