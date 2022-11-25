package pom.test;


import extension.TestExtension;
import extension.TestStatusExtension;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pom.page.*;
import pom.test.BaseClass;
import pom.test.LoginTest;

import java.io.File;

@ExtendWith({TestExtension.class, TestStatusExtension.class})
public class SearchTest extends BaseClass {
    private static final Logger logger = LogManager.getLogger(SearchTest.class);
    HomePage homePage;
    Classified classified;
    LoginPage loginPage;
    SearchPage searchPage;
    SearchResultPage searchResultPage;
    ClassifiedDetailPage classifiedDetailPage;

    @BeforeEach
    public void before() {
        homePage = new HomePage(driver);
        classified = new Classified(driver);
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);
        searchResultPage = new SearchResultPage(driver);
        classifiedDetailPage = new ClassifiedDetailPage(driver);

    }
    @Tag("Detayli_Arama")
    @Test
    @DisplayName("DetayliAramaFiltreEklemeTesti")
    public void test() throws InterruptedException {
        homePage.clickRealEstateCategory();
        homePage.clickDetailedSearch();
        searchPage.clickRealEstate();
        searchPage.selectCity();
        searchPage.enterMinPrice();
        searchPage.enterMaxPrice();
        searchPage.applySearch();
        Thread.sleep(2000);

        try {
            Assertions.assertTrue(driver.getCurrentUrl().contains("istanbul"));
            logger.info(" Detayli Emlak Arama gerceklendirildi ");


        } catch (Exception exception) {
            logger.info("Error message: Test fail");
            File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            logger.info(imageFile.getPath());
        }
    }

    //Anasayfadan emlak sonrasinda da , Detayli aramaya tiklanir emlak secilir fiyat bilgileri ve sehir secildikten sonra arama yapilir  urlin icinde yer bilgisi oldugu dogrulanir

    @Tag("Populer_ARAMA")
    @Test
    @DisplayName("PopulerSearch")
    public void test2() throws InterruptedException {
        homePage.acceptCookie();
        homePage.clickPopuler1();
        Thread.sleep(2000);
        String titleSearch = searchResultPage.getFirstClassifiedTitle();
        String searchPrice = homePage.getPrice();
        logger.info("Populer Searchdeki aramadaki title : " + titleSearch);
        logger.info("Popular search search page price  : " + searchPrice);
        searchResultPage.clickFirstClassified();
        String classifiedDetailTitle = homePage.getTitle();
        logger.info("Populer Search ilan detay title : " + classifiedDetailTitle);
        String detailPrice = searchResultPage.getFirstClassifiedPrice();
        logger.info("Populer Search de ilan Acildiktan sonraki  title : " + detailPrice);
        try {
            Assertions.assertAll
                    (
                            () -> Assertions.assertEquals(titleSearch, classifiedDetailTitle),
                            () -> Assertions.assertEquals(searchPrice, detailPrice)
                    );


        } catch (Exception exception) {
            logger.info("Error message: Test fail");
            File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            logger.info(imageFile.getPath());
        }
    }
}
//Anasayfadan Populer aramaya ilk siradakine tiklar tiklanir  ,acilan liste sayfasi olur ve bu sayfadan ilk ilan title ile foyat bilgisi alinir
//Acilan sayfadki ilk ilana tiklanir ve ilan detaya gidilir burada search sayfasindan aldigimiz fiyat ve title bilgisinin dogru oldugu kontrol edilir
