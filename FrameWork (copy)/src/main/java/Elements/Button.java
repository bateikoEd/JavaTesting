package Elements;

import org.openqa.selenium.WebElement;

public class Button extends BaseElement {
    public Button(WebElement element) {
        super(element);
    }
    @Override
    public void submit() {
        return;
    }
    @Override
    public void sendKeys(CharSequence...sequences){return;}
    @Override
    public void clear(){
        return;
    }
    @Override
    public boolean isSelected(){
        return false;
    }

}
