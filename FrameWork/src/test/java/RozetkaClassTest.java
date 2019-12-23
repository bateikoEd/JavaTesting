import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;

class RozetkaClassTest {

    private RozetkaClass rozetkaPage;
    private CheckBoxClass checkBoxProcessors;
    private CheckBoxClass checkBoxProducer;
    private CheckBoxClass checkBoxRAM;
    private CheckBoxClass checkBoxROM;

    @BeforeEach
    void bef(){
        rozetkaPage = new RozetkaClass();
    }
    @Ignore
    void load() {
    }

    @Ignore
    void isLoaded() {
    }

    @Test
    void goToTypeOfSomething(){
        String strSearch = "Ноутбук";
        By byLap = By.xpath("//img[@alt='Тонкі та легкі']");
        String currentUrl = "https://rozetka.com.ua/ua/notebooks/c80004/filter/preset=tonkie-i-legkie/";

        rozetkaPage.goToTypeOfSomething(strSearch,byLap);

        assertSame(currentUrl,rozetkaPage.currentUrl());
    }

    @Test
    void chooseCharacteristics(){
        goToTypeOfSomething();
        int indexProducer1 = 1,
            indexProducer2 = 4,
            indexProcessor = 6,
            indexRom = 2,
            indexRam = 2;
        checkBoxProcessors = new  CheckBoxClass (rozetkaPage.getCheckBoxProcessors());
        checkBoxProducer = new  CheckBoxClass (rozetkaPage.getCheckBoxProducer());
        checkBoxRAM = new  CheckBoxClass(rozetkaPage.getCheckBoxRAM());
        checkBoxROM = new  CheckBoxClass(rozetkaPage.getCheckBoxROM());

        rozetkaPage.clickCheckBoxProducer(indexProducer1,indexProducer2);
        rozetkaPage.clickCheckBoxProcessors(indexProcessor);
        rozetkaPage.clickCheckBoxRAM(indexRam);
        rozetkaPage.clickCheckBoxROM(indexRom);

        assertNotSame(checkBoxProducer.getWebElement(indexProducer1).isSelected(),
                rozetkaPage.getCheckBoxProducer().getWebElement(indexProducer1).isSelected());

        assertNotSame(checkBoxProducer.getWebElement(indexProducer2).isSelected(),
                rozetkaPage.getCheckBoxProducer().getWebElement(indexProducer2).isSelected());

        assertNotSame(checkBoxProcessors.getWebElement(indexProcessor).isSelected(),
                rozetkaPage.getCheckBoxProcessors().getWebElement(indexProcessor).isSelected());

        assertNotSame(checkBoxRAM.getWebElement(indexRam).isSelected(),
                rozetkaPage.getCheckBoxRAM().getWebElement(indexRam).isSelected());

        assertNotSame(checkBoxROM.getWebElement(indexRom).isSelected(),
                rozetkaPage.getCheckBoxROM().getWebElement(indexRom).isSelected());
    }

    @Test
    void buyItem(){
        chooseCharacteristics();
        rozetkaPage.click(By.cssSelector("body > app-root > div > div:nth-child(2) > rz-catalog > div > main > ivv-catalog > div.layout.layout_with_sidebar > section > ivv-grid > ul > li:nth-child(1) > app-goods-tile > app-goods-tile-default > div > div.goods-tile__inner > div.goods-tile__prices > div.goods-tile__price.goods-tile__price_color_red > app-buy-button > button"));
        rozetkaPage.click(By.xpath("//a[@href='https://my.rozetka.com.ua/ua/profile/cart']"));
        rozetkaPage.click(By.xpath("//a[@href='https://my.rozetka.com.ua/ua/checkout']"));
    }

    @After
    void end(){
        rozetkaPage.exitDriver();
    }

}