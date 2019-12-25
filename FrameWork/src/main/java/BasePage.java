import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(){
        String exePath = "/home/bateiko/Downloads/chromedriver_linux64/chromedriver";
        System.setProperty("webdriver.chrome.driver", exePath);
        this.driver = new ChromeDriver();
        wait = new WebDriverWait(driver,15 );
        driver.manage().window().maximize();
    }
    public BasePage getDriver(String URL) {

        this.driver.get(URL);
        changeTimeLoad(30);
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
    public boolean writeTextLocation(By elemLocation, String text) throws Exception {
        String strResult = driver.findElement(elemLocation).getText();
        if(strResult.isEmpty())
            findWebElement(elemLocation).sendKeys(text);
        else {
            Actions actions = new Actions(driver);
            actions.doubleClick(driver.findElement(elemLocation)).perform();
            findWebElement(elemLocation).sendKeys(text);
        }
        return true;
    }

    public boolean writeTextWebElem(WebElement elem, String text) throws InterruptedException {
        String strResult = elem.getText();

        if(strResult.isEmpty())
            elem.sendKeys(text);
        else {
            Actions actions = new Actions(driver);
            actions.click(elem).sendKeys(Keys.chord(Keys.CONTROL, "a")).sendKeys(Keys.chord(Keys.BACK_SPACE));
            elem.sendKeys(text);
            changeTime(20);
        }
        return true;
    }
    public String readTextByElem(By elemLocation) throws Exception {
        return findWebElement(elemLocation).getTe            actions.click(elem).sendKeys(Keys.chord(Keys.CONTROL, "a")).sendKeys(Keys.chord(Keys.BACK_SPACE));
xt();
    }
    public String readTextWebElem(WebElement elem) throws Exception {
        return elem.getText();
    }
    public boolean click(By elemLocation){
        try
        {
            findWebElement(elemLocation).click();
        }
        catch (WebDriverException ex)
        {
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    public WebDriver getWebDriver() {
        return driver;
    }
    public void changeTimeLimit(int durationSecond){
        driver.manage().timeouts().implicitlyWait(durationSecond, TimeUnit.SECONDS);
    }
    public void changeTimeLoad(int durationSecond) { driver.manage().timeouts().pageLoadTimeout(durationSecond, TimeUnit.SECONDS);}
    public void changeTime(int durationMilisecond) throws InterruptedException {
        Thread.sleep(durationMilisecond);
    }
    public WebElement findWebElement(By byElem) throws Exception{
        return wait.until ((driver) -> driver.findElement(byElem));
    }
    public void init(){
        PageFactory.initElements(driver,this);
        changeTimeLoad(20);
    }
}
