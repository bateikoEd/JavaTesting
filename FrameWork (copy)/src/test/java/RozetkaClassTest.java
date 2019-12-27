import Elements.CheckBoxClass;
import Pages.RozetkaClass;
import org.junit.AfterClass;
import org.junit.Ignore;
import org.junit.jupiter.api.*;

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
    @AfterEach
     void tearDown(){
        rozetkaPage.getWebDriver().quit();
    }

    @Ignore
    void goToTypeOfSomething() throws InterruptedException {
        String strSearch = "Ноутбук";
        String currentUrl = "https://rozetka.com.ua/ua/notebooks/c80004/";
//        rozetkaPage.clickWebElem(rozetkaPage.getSearchBox()); getSearchBox().click();
        rozetkaPage.writeTextWebElem(rozetkaPage.getSearchBox(), strSearch);
        rozetkaPage.getSearchButton().click();

        assertSame(currentUrl,rozetkaPage.currentUrl());
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

    @Ignore
    void buyItem() throws Exception {
        rozetkaPage.buyThink();
    }

    @Test
    void minAndMaxTextPrice() throws Exception {
        String currentUrl = "https://rozetka.com.ua/ua/notebooks/c80004/";
        rozetkaPage.getDriver(currentUrl);
        rozetkaPage.init();
        int minPrice = 500;

        /*True : if all price`s item more than minPrice*/
        boolean resultBool = rozetkaPage.enterTextInBox(rozetkaPage.getMinTextElemBy(),rozetkaPage.getMinTextElem(), minPrice);
        assertSame( resultBool, true);
    }


}