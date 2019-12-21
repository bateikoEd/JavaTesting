import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        String exePath = "/home/bateiko/Downloads/chromedriver_linux64/chromedriver";
        System.setProperty("webdriver.chrome.driver",exePath);
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        String str = driver.findElement(By.className("mw-headline")).getText();
//        Alert myAlert = driver.switchTo().alert();
//        myAlert.accept();
        System.out.println("getText: " + str);

        WebElement elemWeb1 = driver.findElement(By.className("mw-headline"));
        Point point = elemWeb1.getLocation();
        System.out.println("X coordinate: " + point.x + "Y cordinate: " + point.y);

        WebElement elemWeb2 = driver.findElement(By.xpath("//div[@id='mp-topbanner']/div/div[1]"));
        System.out.println("getText: "  + new String(elemWeb2.getText()));
        System.out.println("getTag: " + new String(elemWeb2.getTagName()));
        System.out.println("id: " + new String(elemWeb2.getAttribute("id")));
        Dimension dimens = elemWeb2.getSize();
        System.out.println("Height: "  + dimens.height + " Width: " + dimens.width);
        driver.close();
    }
}
