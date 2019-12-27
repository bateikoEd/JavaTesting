import Pages.GoogleSearch;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;

class GoogleSearchTest {

    private GoogleSearch googlePage;
    @BeforeEach
    void setUp() {
        googlePage = new GoogleSearch();
        googlePage.init();
    }

    @AfterEach
    void tearDown() {
        googlePage.getWebDriver().quit();
    }

    @Test
    void firstPage() throws Exception{
        String searchText = "macpaw";
        String namesScreen = "FirstPage";

        int numberOfPage = 1;
        googlePage.writeTextWebElem(googlePage.getSearchBoxHome(), searchText);
        googlePage.submitWebElem(googlePage.getSearchBoxHome());

        int currentNumberOfPage = googlePage.findAndScreenPages(googlePage.getFindingWeElemBy(), namesScreen);

       assertSame(currentNumberOfPage,numberOfPage);
    }

    @Test
    void setNotFirstPage() throws Exception {
        String searchText = "macpaw";
        String namesScreen = "setNotFirstPage";
        int numberOfPage = 4;

        googlePage.writeTextWebElem(googlePage.getSearchBoxHome(), searchText);
        googlePage.submitWebElem(googlePage.getSearchBoxHome());

        int currentNumberOfPage =  googlePage.findAndScreenPages(googlePage.getNotFirstPageElemBy(), namesScreen);

        assertSame(currentNumberOfPage,numberOfPage);
    }

    @Test
    void setAllPages() throws Exception {
        String searchText = "openccs";
        String namesScreen = "setAllPages";
        googlePage.writeTextWebElem(googlePage.getSearchBoxHome(), searchText);
        googlePage.submitWebElem(googlePage.getSearchBoxHome());

        googlePage.findAndScreenAllPages(googlePage.getFindingWeElemBy(), namesScreen);
    }
}