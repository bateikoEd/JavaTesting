import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.concurrent.TimeUnit;

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
    @AfterClass
     void end(){
        rozetkaPage.getWebDriver().quit();
    }

    @Ignore
    void load() {
    }

    @Ignore
    void isLoaded() {
    }

    @Test
    void goToTypeOfSomething() throws InterruptedException {
        String strSearch = "Ноутбук";
        rozetkaPage.init();
        rozetkaPage.getSearchBox().click();
        rozetkaPage.writeTextWebElem(rozetkaPage.getSearchBox(), strSearch);
//        rozetkaPage.getSearchButton().submit();
//        rozetkaPage.changeTimeLimit(20);
//        rozetkaPage.getSearchButton().click();

//        assertSame(currentUrl,rozetkaPage.currentUrl());
    }

    @Ignore
    void chooseCharacteristics(){
        int indexProducer1 = 1,
            indexProducer2 = 4,
            indexProcessor = 6,
            indexRom = 2,
            indexRam = 2;
        rozetkaPage.init();
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
        rozetkaPage.buyThink();
    }

    @Test
    void minAndMaxTextPrice() throws Exception {
        String currentUrl = "https://rozetka.com.ua/ua/notebooks/c80004/";
        rozetkaPage.getDriver(currentUrl);
        int minPrice = 500, maxPrice = 10000;
        int newMinPrice,newMaxPrice;
        rozetkaPage.init();
//        rozetkaPage.changeTime(30);
//
        /*enter min price in text elem*/
        rozetkaPage.writeTextWebElem(rozetkaPage.getMinTextElem(), Integer.toString(minPrice));
//        rozetkaPage.getMinTextElem().getAttribute(Integer.toString(minPrice));
        /*waitigtime*/
        rozetkaPage.changeTime(30);
//        rozetkaPage.changeTimeLimit(30);

//        rozetkaPage.getMinTextElem().click();

        /*return current  price*/
//        newMinPrice = Integer.parseInt(rozetkaPage.readTextWebElem(rozetkaPage.getMinTextElem()));

        /*waitigtime*/
        rozetkaPage.changeTime(20);
        rozetkaPage.changeTimeLimit(30);

        /*enter max price in text elem*/
        rozetkaPage.writeTextWebElem(rozetkaPage.getMaxTextElem(), Integer.toString(maxPrice));

//        rozetkaPage.getMaxTextElem().click();

        /*return current  price*/
//        newMaxPrice = Integer.parseInt(rozetkaPage.readTextWebElem(rozetkaPage.getMaxTextElem()));
//        rozetkaPage.getMaxTextElem().click();


        rozetkaPage.changeTime(30);

        /*click button ok*/
        rozetkaPage.getOkButtonPrice().click();
//        assertSame(newMaxPrice,maxPrice);
//        assertSame( newMinPrice, minPrice);
    }


}