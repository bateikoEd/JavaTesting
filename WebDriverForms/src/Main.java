import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) throws InterruptedException{
        String exePath = "/home/bateiko/Downloads/chromedriver_linux64/chromedriver";
        System.setProperty("webdriver.chrome.driver",exePath);
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.toolsqa.com/automation-practice-form/");
        /*Alert myAlert = driver.switchTo().alert();
        myAlert.accept();*/

        driver.findElement(By.id("cookie_action_close_header")).click();

        WebElement elem = driver.findElement(By.xpath("//input[@name ='firstname']"));
        elem.click();
        elem.sendKeys("Eduard");
        elem = driver.findElement(By.id("lastname"));
        elem.click();
        elem.sendKeys("Bateiko");

        elem = driver.findElement(By.id("datepicker"));
        elem.click();
        elem.sendKeys("11/21/2012");

        Select oSelect = new Select(driver.findElement(By.id("continents")));
        oSelect.selectByVisibleText("Europe");

        List<WebElement> allSelects = driver.findElements(By.tagName("select"));
        System.out.println("Coutn of Selects: " + allSelects.size());

        List<WebElement> allChckBox = driver.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println("Coutn of allChckBox: " + allChckBox.size());

//        List<WebElement> allTexBox = driver.findElements(By.xpath("//input[@type='text[@class='inputtext']"));
//        System.out.println("Coutn of allTexBox: " + allTexBox.size());

        //driver.findElement(By.id("sex-0")).click();

        List<WebElement> oRadioButton = driver.findElements(By.name("sex"));
        System.out.println("LIST SIZE: " + oRadioButton.size());

        for(int i = 0; i < oRadioButton.size(); i++)
            System.out.println(oRadioButton.get(i).getText());

        boolean boolRus = false;
        boolRus = oRadioButton.get(0).isSelected();
        if(boolRus = true)
            oRadioButton.get(1).click();
        else
            oRadioButton.get(0).click();
        driver.close();
    }
}
