import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

class GoogleSearchTest {

    private GoogleSearch googlePage;
    @BeforeEach
    void setUp() {
        googlePage = new GoogleSearch();
    }

    @AfterEach
    void tearDown() {
        googlePage.getWebDriver().quit();
    }

    @Test
    void firstPage() throws Exception{
        String searchText = "macpaw";
        googlePage.clickWebElem(googlePage.getSearchBoxHome());
        googlePage.writeTextWebElem(googlePage.getSearchBoxHome(), searchText);
        googlePage.submitWebElem(googlePage.getSearchBoxHome());

        assertNotEquals(googlePage.findFirstPage(By.xpath("//a[@href='https://macpaw.com/uk']"))
                , googlePage.getBaseUrl());
    }

    @Test
    void searchText() throws Exception {
        String searchText = "macpaw";
        googlePage.clickWebElem(googlePage.getSearchBoxHome());
        googlePage.writeTextWebElem(googlePage.getSearchBoxHome(), searchText);
        googlePage.submitWebElem(googlePage.getSearchBoxHome());

        googlePage.findAndScreenPages(10);

    }
}