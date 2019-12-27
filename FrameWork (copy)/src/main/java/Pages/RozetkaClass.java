package Pages;

import Elements.CheckBoxClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class RozetkaClass extends BasePage {

    private String baseURL = "https://rozetka.com.ua";
    private CheckBoxClass checkBoxProcessors;
    private CheckBoxClass checkBoxProducer;
    private CheckBoxClass checkBoxRAM;
    private CheckBoxClass checkBoxROM;

    @FindBy(name="search")
    @CacheLookup
    WebElement searchBox;

    @FindBy(css= "header-actions__button header-actions__button_type_basket header-actions__button_state_active")
    private WebElement basketButton;

    @FindBy(xpath = "/html/body/app-root/div/div[1]/div[1]/header/div/div[2]/div[3]/form/button")
    @CacheLookup
    private WebElement searchButton;

    @FindBy(xpath = "/html/body/app-root/div/div[1]/rz-catalog/div/main/ivv-catalog/div[2]/aside/ivv-filter-stack/div[3]/div/div/div/div/ivv-filter-slider/form/fieldset/div/input[2]")
    @CacheLookup
    private WebElement maxTextElem;

    @FindBy(xpath = "/html/body/app-root/div/div[1]/rz-catalog/div/main/ivv-catalog/div[2]/aside/ivv-filter-stack/div[3]/div/div/div/div/ivv-filter-slider/form/fieldset/div/input[1]")
    @CacheLookup
    private WebElement minTextElem;

    @FindBy(xpath = "/html/body/app-root/div/div[1]/rz-catalog/div/main/ivv-catalog/div[2]/aside/ivv-filter-stack/div[3]/div/div/div/div/ivv-filter-slider/form/fieldset/div/button")
    private WebElement okButtonPrice;

    @FindBy(className = "goods-tile__price-value")
    private List<WebElement> priceList;
    public RozetkaClass() {
        super();
        getDriver(baseURL);
        System.out.println("Firsr dim");
        /*checkBoxProducer = new CheckBoxClass(driver,By.xpath("//ul[@id=sort_producer]/li"));
        checkBoxProcessors = new CheckBoxClass(driver,By.xpath("//ul[@id=sort_processor]/li"));
        checkBoxRAM = new CheckBoxClass(driver,By.xpath("//ul[@id=sort_20882]/li"));
        checkBoxROM = new CheckBoxClass(driver,By.xpath("//ul[@id=sort_20863]/li"));*/
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
    public WebElement getSearchButton(){
        return searchButton;
    }
    public String currentUrl(){
        return driver.getCurrentUrl();
    }
    public CheckBoxClass clickCheckBoxProducer(int Index1, int Index2){ return checkBoxProducer.clickIndexElement(Index1).clickIndexElement(Index2);}
    public CheckBoxClass clickCheckBoxProcessors(int Index1){
        return checkBoxProcessors.clickIndexElement(Index1);
    }
    public CheckBoxClass clickCheckBoxRAM(int Index1){
        return checkBoxRAM.clickIndexElement(Index1);
    }
    public CheckBoxClass clickCheckBoxROM(int Index1){
        return checkBoxROM.clickIndexElement(Index1);
    }
    public WebElement getMaxTextElem() {
        return maxTextElem;
    }
    public By getMaxTextElemBy(){return By.xpath("/html/body/app-root/div/div[1]/rz-catalog/div/main/ivv-catalog/div[2]/aside/ivv-filter-stack/div[3]/div/div/div/div/ivv-filter-slider/form/fieldset/div/input[2]"); }
    public By getMinTextElemBy(){return By.xpath("/html/body/app-root/div/div[1]/rz-catalog/div/main/ivv-catalog/div[2]/aside/ivv-filter-stack/div[3]/div/div/div/div/ivv-filter-slider/form/fieldset/div/input[1]"); }
    public WebElement getMinTextElem(){ return  minTextElem; }
    public WebElement getOkButtonPrice(){
        return okButtonPrice;
    }

    public boolean enterTextInBox(By elementBy, WebElement element, int minPrice) throws Exception {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(elementBy));
        writeTextWebElem(element,Integer.toString(minPrice));
        element.submit();
        clickWebElem(okButtonPrice);
        init();

        for(WebElement priceElem: priceList){
            String text = priceElem.getText().replaceAll("[^0-9]","");
            if( Integer.parseInt(text) < minPrice)
                return false;
        }
        return true;
    }
    public String goToTypeOfSomething(String strSearch, By subTypeSomething) throws InterruptedException {
        searchBox.click();
        writeTextWebElem(searchBox, strSearch);
        searchBox.submit();
//        searchButton.click();

        return driver.getCurrentUrl();
    }
    public RozetkaClass buyThink() throws Exception {
        clickWebElem(basketButton);
        click(By.xpath("//a[@href='https://my.rozetka.com.ua/ua/profile/cart']"));
        click(By.xpath("//a[@href='https://my.rozetka.com.ua/ua/checkout']"));
        return this;
    }


}
