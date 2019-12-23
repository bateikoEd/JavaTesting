import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CheckBoxClass {
    private List<WebElement> webElementList;

    public CheckBoxClass(WebDriver driver, By findByElements){
        webElementList = driver.findElements(findByElements);
    }
    public CheckBoxClass(CheckBoxClass obj2){
        this.webElementList = obj2.getWebElementList();
    }
    public WebElement getWebElement(int Index){
        return webElementList.get(Index);
    }

    public CheckBoxClass clickIndexElement(int Index){
        webElementList.get(Index).click();
        return this;
    }
    public List<WebElement> getWebElementList(){
        return webElementList;
    }
    public boolean isSelectedWebElement(int Index){
        return webElementList.get(Index).isSelected();
    }
}
