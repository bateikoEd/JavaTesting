import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.datatype.Duration;
import java.util.concurrent.TimeUnit;

public class RozetkaClass extends BasePage {

    private String baseURL = "https://rozetka.com.ua";
    private CheckBoxClass checkBoxProcessors;
    private CheckBoxClass checkBoxProducer;
    private CheckBoxClass checkBoxRAM;
    private CheckBoxClass checkBoxROM;

    @FindBy(name="search")
    WebElement searchBox;

    @FindBy(css= "header-actions__button header-actions__button_type_basket header-actions__button_state_active")
    private WebElement basketButton;

    @FindBy(xpath = "/html/body/app-root/div/div[1]/div[1]/header/div/div[2]/div[3]/form/button")
    private WebElement searchButton;

    @FindBy(xpath = "/html/body/app-root/div/div[1]/rz-catalog/div/main/ivv-catalog/div[2]/aside/ivv-filter-stack/div[3]/div/div/div/div/ivv-filter-slider/form/fieldset/div/input[2]")
    private WebElement maxTextElem;

    @FindBy(css = "body > app-root > div > div:nth-child(2) > rz-catalog > div > main > ivv-catalog > div.layout.layout_with_sidebar > aside > ivv-filter-stack > div:nth-child(3) > div > div > div > div > ivv-filter-slider > form > fieldset > div > input.slider-filter__input.ng-pristine.ng-valid.ng-touched")
    private WebElement minTextElem;

    @FindBy(xpath = "/html/body/app-root/div/div[1]/rz-catalog/div/main/ivv-catalog/div[2]/aside/ivv-filter-stack/div[3]/div/div/div/div/ivv-filter-slider/form/fieldset/div/button")
    private WebElement okButtonPrice;

    private FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);

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
        searchBox.click();
        writeTextWebElem(searchBox, strSearch);
//        searchBox.submit();
        searchButton.click();

//        click(subTypeSomething);

        return driver.getCurrentUrl();
    }

    public WebElement getSearchButton(){
        return searchButton;
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
    public RozetkaClass buyThink(){
        click(By.cssSelector("body > app-root > div > div:nth-child(2) > rz-catalog > div > main > ivv-catalog > div.layout.layout_with_sidebar > section > ivv-grid > ul > li:nth-child(1) > app-goods-tile > app-goods-tile-default > div > div.goods-tile__inner > div.goods-tile__prices > div.goods-tile__price.goods-tile__price_color_red > app-buy-button > button"));
        click(By.xpath("//a[@href='https://my.rozetka.com.ua/ua/profile/cart']"));
        click(By.xpath("//a[@href='https://my.rozetka.com.ua/ua/checkout']"));
        return this;
    }
    public WebElement getMaxTextElem() {
        return maxTextElem;
    }
    public WebElement getMinTextElem(){
        return  minTextElem;
    }
    public WebElement getOkButtonPrice(){
        return okButtonPrice;
    }

}
