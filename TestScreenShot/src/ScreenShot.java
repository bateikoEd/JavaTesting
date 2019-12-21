import java.io.File;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ScreenShot {
    static WebDriver driver;
    @Before
    public void setUp(){
        String exePath = "/home/bateiko/Downloads/chromedriver_linux64/chromedriver";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
    }
    @Test
    public void aTest(){
        driver.get("https://www.google.com/search?q=google&oq=goog&aqs=chrome.0.0l3j69i60l3j69i65l2.1135j0j7&sourceid=chrome&ie=UTF-8");

    }

    @After
    public void tearDown(){
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(scrFile, new File("java.png"));
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    driver.quit();
}
