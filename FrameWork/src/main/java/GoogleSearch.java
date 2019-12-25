import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.charset.CharsetEncoder;

public class GoogleSearch extends BasePage {

    private String  baseUrl= "https://www.google.com";
    private WebElement searchBoxHome;

    @FindBy(id="pnnext")
    private WebElement nextPageButton;

    @FindBy(xpath = "//*[@id='nav']/tbody/tr/td[last() -1 ]")
    private WebElement lastWebElemOfLinks;

    @FindBy(id="pnnext")
    private WebElement buttonNextPage;

    /*@FindBy(xpath = "//*[@id='tsf']/div[2]/div[1]/div[1]/div/div[2]/input")
    @CacheLookup
    WebElement searchBoxHome;*/
    //@FindBy(xpath = "//*[@id='tsf']/div[2]/div[1]/div[2]/div/div[2]/input")
    //private WebElement searchBox;

    private CheckBoxClass linkList;

    public GoogleSearch(){
        super();
        getDriver(baseUrl);
        searchBoxHome = driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div[1]/div[1]/div/div[2]/input"));
    }

    public WebElement getButtonNextPage(){
        return buttonNextPage;
    }
    public WebElement getLastWebElemOfLinks(){
        return lastWebElemOfLinks;
    }
    public String getBaseUrl(){
        return baseUrl;
    }
    public WebElement getSearchBoxHome(){
        return searchBoxHome;
    }
    public WebElement getNextPageButton(){
        return nextPageButton;
    }
    public void searchText(String searchText){
        //linkList = new CheckBoxClass( driver,By.xpath("//*[@id='nav']/tbody/tr"));

    }
    public void clickWebElem(WebElement webElement){
        webElement.click();
    }

    public void submitWebElem(WebElement webElement){
        webElement.submit();
    }

    public GoogleSearch createCheckBoxClass(By byElem){
        linkList = new CheckBoxClass(driver,byElem);
        return this;
    }

    public GoogleSearch setLinkList(CheckBoxClass list){
        linkList.setWebElementList(list.getWebElementList());
        return  this;
    }
    public CheckBoxClass getLinkList(){
        return linkList;
    }
    public GoogleSearch findAndScreenPages(int n) throws Exception {
        for(int i = 0; i < n; i++){
            init();
            getButtonNextPage().click();
            makeScreen(Integer.toString(i));
        }
        return this;
    }
    public String findFirstPage(By byFindElem) throws Exception{
        click(byFindElem);
        makeScreen("macpaw");
        return driver.getCurrentUrl();
    }
}
