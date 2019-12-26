package Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BasePage {

    protected WebDriver driver;
    protected Wait<WebDriver> wait;

    public BasePage(){
        String exePath = "/home/bateiko/Downloads/chromedriver_linux64/chromedriver";
        System.setProperty("webdriver.chrome.driver", exePath);
        this.driver = new ChromeDriver();
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(5, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
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
            /*Actions actions = new Actions(driver);
            actions.click(elem).sendKeys(Keys.chord(Keys.CONTROL, "a")).sendKeys(Keys.chord(Keys.BACK_SPACE));
            */
            elem.clear();
            elem.sendKeys(text);
            changeTimeLimit(20);

        return true;
    }
    /*public String readTextByElem(By elemLocation) throws Exception {
        return findWebElement(elemLocation).getTe            actions.click(elem).sendKeys(Keys.chord(Keys.CONTROL, "a")).sendKeys(Keys.chord(Keys.BACK_SPACE));
xt();
    }*/
    public String readTextWebElem(WebElement elem){
        return elem.getText();
    }
    public boolean click(By elemLocation) throws Exception {

        if(wait.until(ExpectedConditions.elementToBeClickable(elemLocation)) != null) {
            findWebElement(elemLocation).click();
            return true;
        }
        System.out.println("Elem not clicamble");
        return true;
    }

    public void clickWebElem(WebElement webElement) {
//        if(wait.until(ExpectedConditions.elementToBeClickable(webElement)) != null)
            webElement.click();
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

//        wait.until(ExpectedConditions.invisibilityOfElementLocated(byElem)))
        if(driver.findElements(byElem).size()>0)
            return  wait.until(ExpectedConditions.elementToBeClickable(byElem));

        return null;

    }
    public void init(){
        PageFactory.initElements(driver,this);
        changeTimeLoad(20);
    }
    /*
    public boolean makeScreenPage(String numbPage,String testName) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element1 = driver.findElement(By.xpath("//div[@id='searchform']"));
        js.executeScript("arguments[0].setAttribute('style', 'visibility: hidden;')", element1); }
        Screenshot screenshot=new AShot().coordsProvider(new WebDriverCoordsProvider()).shootingStrategy(ShootingStrategies.viewportPasting(200)).takeScreenshot(Chrome.getDriver());
        try {
            ImageIO.write(screenshot.getImage(), "PNG", new File(testName+"_Time_"+(System.currentTimeMillis()-Chrome.getTimme())+"_Page_№" + numbPage +".png"));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
*/
}
