import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.IOException;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(){
        String exePath = "/home/bateiko/Downloads/chromedriver_linux64/chromedriver";
        System.setProperty("webdriver.chrome.driver", exePath);
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    public BasePage getDriver(String URL) {

        this.driver.get(URL);
        return this;
    }
    public BasePage makeScreen(String nameScreen){
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(scrFile, new File(String.format("%s.png", nameScreen)));
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        return this;
    }
    public boolean writeTextLocation(By elemLocation, String text){

        String strResult = driver.findElement(elemLocation).getText();
        if(strResult.equals(""))
            driver.findElement(elemLocation).sendKeys(text);
        else {
            Actions actions = new Actions(driver);
            actions.doubleClick(driver.findElement(elemLocation)).perform();
            driver.findElement(elemLocation).sendKeys(text);
        }
        return true;
    }

    public boolean writeTextWebElem(WebElement elem, String text){

        String strResult = elem.getText();
        if(strResult.equals(""))
            elem.sendKeys(text);
        else {
            Actions actions = new Actions(driver);
            actions.doubleClick(elem).perform();
            elem.sendKeys(text);
        }
        return true;
    }

    public String readText(By elemLocation){
        return driver.findElement(elemLocation).getText();
    }
    public boolean click(By elemLocation){
        try
        {
//            new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(elemLocation));
            driver.findElement(elemLocation).click();
        }
        catch (WebDriverException ex)
        {
            return false;
        }
        return true;
    }
}
