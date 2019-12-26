package Pages;

import Elements.CheckBoxClass;
//import com.sun.org.apache.bcel.internal.generic.ARETURN;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class GoogleSearch extends BasePage {

    private String  baseUrl= "https://www.google.com";
    @FindBy(xpath = "//*[@id='tsf']/div[2]/div[1]/div[1]/div/div[2]/input")
    private WebElement searchBoxHome;


    @FindBy(xpath = "//a[@href='https://macpaw.com/uk']")
    private WebElement findingWeElem;

    @FindBy(xpath = "//a [@href ='https://ua.indeed.com/Macpaw-%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D0%B0-%D0%9A%D0%B8%D0%B5%D0%B2']")
    private WebElement notFirstPageWebElem;

    @FindBy(id="pnnext")
    @CacheLookup
    private WebElement buttonNextPage;

    private CheckBoxClass linkList;

    public GoogleSearch(){
        super();
        getDriver(baseUrl);
    }
    public By getNotFirstPageElemBy(){
        return By.xpath("//a [@href ='https://ua.indeed.com/Macpaw-%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D0%B0-%D0%9A%D0%B8%D0%B5%D0%B2']");
    }
    public WebElement getButtonNextPage(){
        return buttonNextPage;
    }
    public WebElement getFindingWeElem(){
        return findingWeElem;
    }
    public By getFindingWeElemBy() {return By.xpath("//a[@href='https://macpaw.com/uk']");}
    public String getBaseUrl(){
        return baseUrl;
    }
    public WebElement getSearchBoxHome(){
        return searchBoxHome;
    }
    public WebElement getNextPageButton(){
        return buttonNextPage;
    }

    public boolean findButtonNextPage() throws Exception {
        if(findWebElement(By.id("pnnext")) != null)
            return true;
        return false;
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
    public GoogleSearch findAndScreenAllPages(By byElem) throws Exception {
        int i = 1;
        while(findButtonNextPage()){
            if( findWebElement(byElem) != null){
                makeScreen(Integer.toString(i) + "macpawfind");
                return this;
            }
            init();
            clickWebElem(buttonNextPage);
            i++;
        }

        makeScreen(Integer.toString(i) + "macpawfind");

        return this;
    }
    public String findFirstPage(By byFindElem) throws Exception{
        click(byFindElem);
        makeScreen("macpaw");
        return driver.getCurrentUrl();
    }
}
