package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {

    protected WebDriver driver;
    protected Wait<WebDriver> wait;

    public BasePage(){
        String exePath = "/home/bateiko/Downloads/chromedriver_linux64/chromedriver";
        System.setProperty("webdriver.chrome.driver", exePath);
        this.driver = new ChromeDriver();
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .ignoring(NoSuchElementException.class);
        driver.manage().window().maximize();
    }

    public BasePage getDriver(String URL) {
        changeTimeLoad(30);
        this.driver.get(URL);
        return this;
    }
    public void clickWebElem(WebElement webElement) { webElement.click();}
    public WebDriver getWebDriver() { return driver; }
    public void changeTimeLimit(int durationSecond){ driver.manage().timeouts().implicitlyWait(durationSecond, TimeUnit.SECONDS); }
    public void changeTimeLoad(int durationSecond) { driver.manage().timeouts().pageLoadTimeout(durationSecond, TimeUnit.SECONDS);}
    public void changeTime(int durationMilisecond) throws InterruptedException { Thread.sleep(durationMilisecond); }

    public void makeScreen(String nameScreen) throws Exception {
/*
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(10000)).takeScreenshot(driver);
        try {
            ImageIO.write(screenshot.getImage(),"PNG",new File("/home/bateiko/GitCloneRepo/JavaTesting/FrameWork (copy)"));
        } catch (IOException e) {                 // TODO Auto-generated catch block
            e.printStackTrace();
        }
*/
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element1 = findWebElement(By.xpath("//div[@id='searchform']"));
        js.executeScript("arguments[0].setAttribute('style', 'visibility: hidden;')",element1);

        Screenshot screenshot=new AShot().coordsProvider(new WebDriverCoordsProvider()).shootingStrategy(ShootingStrategies.viewportPasting(200)).takeScreenshot(driver);
        try {
            ImageIO.write(screenshot.getImage(), "PNG", new File(nameScreen+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean writeTextLocation(By elemLocation, String text) throws Exception {
        WebElement elem = null;
        wait.until(ExpectedConditions.invisibilityOfElementLocated(elemLocation));
        if(findWebElement(elemLocation) != null) {
            elem = driver.findElement(elemLocation);
            return  false;
        }
        elem.clear();
        elem.sendKeys(text);
        changeTimeLimit(10);
        return true;
    }
    public boolean writeTextWebElem(WebElement elem, String text) throws InterruptedException {
        elem.clear();
        elem.sendKeys(text);
        changeTimeLimit(10);
        return true;
    }
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
    public WebElement findWebElement(By byElem) throws Exception{
        if(driver.findElements(byElem).size()>0)
            return  wait.until(ExpectedConditions.elementToBeClickable(byElem));
        return null;
    }
    public void init(){
        PageFactory.initElements(driver,this);
        changeTimeLoad(20);
    }
}
