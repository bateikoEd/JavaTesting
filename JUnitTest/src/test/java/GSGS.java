import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

import static org.junit.jupiter.api.Assertions.*;

public class GSGS {

    static WebDriver driver;
    @org.junit.jupiter.api.Test
    void main() {
    }


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
        driver.quit();
    }
}
