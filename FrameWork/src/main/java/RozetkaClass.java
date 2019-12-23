import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class RozetkaClass extends BasePage {

    private String baseURL = "https://rozetka.com.ua/ua/";
    private CheckBoxClass checkBoxProcessors;
    private CheckBoxClass checkBoxProducer;
    private CheckBoxClass checkBoxRAM;
    private CheckBoxClass checkBoxROM;

    @FindBy(name="search")
    WebElement searchBox;

    public RozetkaClass() {
        super();
        getDriver(baseURL);
        System.out.println("Firsr dim");
        checkBoxProducer = new CheckBoxClass(driver,By.xpath("//ul[@id=sort_producer]/li"));
        checkBoxProcessors = new CheckBoxClass(driver,By.xpath("//ul[@id=sort_processor]/li"));
        checkBoxRAM = new CheckBoxClass(driver,By.xpath("//ul[@id=sort_20882]/li"));
        checkBoxROM = new CheckBoxClass(driver,By.xpath("//ul[@id=sort_20863]/li"));
    }

    public WebElement getSearchBox(){
        return  searchBox;
    }
    public CheckBoxClass getCheckBoxProcessors() {
        return checkBoxProcessors;
    }

    public CheckBoxClass getCheckBoxProducer() {
        return checkBoxProducer;
    }

    public CheckBoxClass getCheckBoxRAM() {
        return checkBoxRAM;
    }

    public CheckBoxClass getCheckBoxROM() {
        return checkBoxROM;
    }
    public String getBaseURL(){
        return baseURL;
    }

    public String goToTypeOfSomething(String strSearch, By subTypeSomething){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        searchBox.click();
        writeTextWebElem(searchBox, strSearch);
        searchBox.submit();
        click(subTypeSomething);
        return driver.getCurrentUrl();
    }

    public String currentUrl(){
        return driver.getCurrentUrl();
    }
    public CheckBoxClass clickCheckBoxProducer(int Index1, int Index2){
         return checkBoxProducer.clickIndexElement(Index1).clickIndexElement(Index2);
    }

    public CheckBoxClass clickCheckBoxProcessors(int Index1){
        return checkBoxProcessors.clickIndexElement(Index1);
    }

    public CheckBoxClass clickCheckBoxRAM(int Index1){
        return checkBoxRAM.clickIndexElement(Index1);
    }

    public CheckBoxClass clickCheckBoxROM(int Index1){
        return checkBoxROM.clickIndexElement(Index1);
    }

    public void exitDriver(){
        driver.quit();
    }
}
