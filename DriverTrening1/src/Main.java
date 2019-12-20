import java.awt.Toolkit;
import java.util.concurrent.TimeUnit;
import java.util.function.IntToLongFunction;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        String exePath = "/home/bateiko/Downloads/chromedriver_linux64/chromedriver";
        System.setProperty("webdriver.chrome.driver",exePath);
        WebDriver dr = new ChromeDriver();
        /*
        System.out.println(dr.manage().window().getSize());

        dr.manage().window().setSize(new Dimension(500,600));
        System.out.println(dr.manage().window().getSize());

        dr.manage().window().setPosition(new Point(200,150));
        System.out.println(dr.manage().window().getSize());

        dr.manage().window().setPosition(new Point(0,0));
        dr.manage().window().setSize(new Dimension(500,600));
        */

        dr.get("https://en.wikipedia.org/wiki/Main_Page");
        java.util.List<WebElement> links = dr.findElements(By.tagName("a"));
        System.out.println(links.size());
        for(int i = 0; i < links.size(); i++){
            System.out.println(i + " " + links.get(i).getText());
        }
        dr.quit();
    }
}