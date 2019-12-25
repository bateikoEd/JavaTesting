import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

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
    @Ignore
    void load() {
    }

    @Ignore
    void isLoaded() {
    }

    @Test
    void goToTypeOfSomething(){
        String strSearch = "Ноутбук";
//        By byLap = By.xpath("//img[@alt='Тонкі та легкі']");
//        String currentUrl = "https://rozetka.com.ua/ua/notebooks/c80004/filter/preset=tonkie-i-legkie/";
        rozetkaPage.init();
        rozetkaPage.getSearchBox().click();
        rozetkaPage.writeTextWebElem(rozetkaPage.getSearchBox(), strSearch);
//        rozetkaPage.getSearchButton().click();
//        rozetkaPage.getSearchButton().click();

//        click(subTypeSomething);

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
    void minAndMaxTextPrice(){
        String currentUrl = "https://rozetka.com.ua/ua/notebooks/c80004/";
        rozetkaPage.getDriver(currentUrl);
        int minPrice = 100, maxPrice = 500;
        rozetkaPage.init();
        rozetkaPage.writeTextWebElem(rozetkaPage.getMinTextElem(), Integer.toString(50));
        rozetkaPage.writeTextWebElem(rozetkaPage.getMaxTextElem(), Integer.toString(100));
        rozetkaPage.getOkButtonPrice().click();

        assertSame(rozetkaPage.tex,);
    }
   /* @AfterAll
    void end(){
//        rozetkaPage.exitDriver();
    }*/

}