import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class Rozetka {


    public static void main(String[] args) {
        Rozetka objRoz = new Rozetka();
        String exePath = "/home/bateiko/Downloads/chromedriver_linux64/chromedriver";
        System.setProperty("webdriver.chrome.driver",exePath);
        WebDriver driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/ua/");
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement searchBox = driver.findElement(By.xpath("/html/body/app-root/div/div[1]/div[1]/header/div/div[2]/div[3]/form/div/div[1]/input"));
        WebElement basketButton = driver.findElement(By.xpath("/html/body/app-root/div/div[1]/div[1]/header/div/div[2]/ul/li[5]/div/div/a"));


        basketButton.click();
        searchBox.click();
        searchBox.sendKeys("Ноутбук");
        searchBox.submit();
        //driver.findElements(By.xpath("//img[@alt='Тонкі та легкі']"));
        driver.quit();
    }
}
