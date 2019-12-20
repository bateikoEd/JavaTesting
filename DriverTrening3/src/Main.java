import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        String exePath = "/home/bateiko/Downloads/chromedriver_linux64/chromedriver";
        System.setProperty("webdriver.chrome.driver",exePath);
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.investing.com/crypto/xrp/xrp-usd?cid=1010782");
        driver.findElement(By.className("popupCloseIcon largeBannerCloser")).click();
        Alert myAlert = driver.switchTo().alert();
        myAlert.accept();
        driver.close();
    }
}
