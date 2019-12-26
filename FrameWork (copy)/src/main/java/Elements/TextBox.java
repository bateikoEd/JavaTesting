package Elements;

import org.openqa.selenium.WebElement;

public class TextBox extends BaseElement {
    public TextBox(WebElement element){
        super(element);
    }
}

//ExcpectesCondition<webElement > obj=new ExpectedCondition<WebElement>() {
//public WebElement apply(WebDriver driver) {
//        try {
//        return ExpectedConditions.elementIfVisible(driver.findElement(locator));
//        } catch (StaleElementReferenceException var3) {
//        return null;
//        }
//        }
