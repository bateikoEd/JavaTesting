package Elements;

import org.openqa.selenium.*;

import java.util.Collections;
import java.util.List;

public class BaseElement {
    protected WebElement baseElement;

    public BaseElement(WebElement element){
        baseElement = element;
    }

    protected void setBaseElement(WebElement element) {
        this.baseElement=element;
    }

    protected WebElement getBaseElement(){
        return baseElement;
    }
    public BaseElement click() {
        baseElement.click();
        return this;
    }

    public void submit() {
        baseElement.submit();
    }

    public void sendKeys(CharSequence... charSequences) {
        baseElement.sendKeys(charSequences);
    }

    public void clear() {
        baseElement.clear();
    }

    public final String getTagName() {
        return baseElement.getTagName();
    }

    public final String getAttribute(String s) {
        return baseElement.getAttribute(s);
    }

    public boolean isSelected() {
        return baseElement.isSelected();
    }

    public final boolean isEnabled() {
        return baseElement.isEnabled();
    }

    public final String getText() {
        return baseElement.getText();
    }

    public List<WebElement> findElements(By by) {
        if(this.getClass().equals(baseElement.getClass()))
            return baseElement.findElements(by);
        else
            return Collections.EMPTY_LIST;
    }

    public WebElement findElement(By by) {
        return baseElement.findElement(by);
    }

    public final boolean isDisplayed() {
        return baseElement.isDisplayed();
    }

    public Point getLocation() {
        return baseElement.getLocation();
    }

    public final Dimension getSize() {
        return baseElement.getSize();
    }

    public final Rectangle getRect() {
        return baseElement.getRect();
    }

    public final String getCssValue(String s) {
        return baseElement.getCssValue(s);
    }

}
