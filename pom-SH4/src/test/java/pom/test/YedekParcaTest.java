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

import java.io.File;

@ExtendWith({TestExtension.class, TestStatusExtension.class})
public class YedekParcaTest extends BaseClass{
    private static final Logger logger = LogManager.getLogger(YedekParcaTest.class);
    HomePage homePage;
    LoginPage loginPage;

    YedekParcaPage yedekParcaPage;

    @BeforeEach
    public void before() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        yedekParcaPage = new YedekParcaPage(driver);
    }

    @DisplayName("YedekParcaFiltrelemeTesti")
    @Test
    public void test()throws InterruptedException{
        try {
        homePage.acceptCookie();
        homePage.clickYedekParca();
        homePage.clickAllYedekParca();
        logger.info(" Yedek Parca kategorisine tiklandi ordan tum vitrin ilanlarina gidildi ");
        yedekParcaPage.clickCondition().clickSearch();
        yedekParcaPage.conditonCheck();
        Assertions.assertTrue(driver.getCurrentUrl().contains("condition=used"));
        String classfiedID = yedekParcaPage.getClassfiedID();
        logger.info(" Ilgili Yedek parca ilani id = " + classfiedID);
        yedekParcaPage.clickFirstClassfieds();
        Thread.sleep(2000);
        Assertions.assertTrue(driver.getCurrentUrl().contains(classfiedID));
        logger.info(" Yedek Parca Kategor testi basarili sonuclandi ");

    }
        catch (Exception exception) {
            logger.info("Error message: Test fail");
            File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            logger.info(imageFile.getPath());
        }
    }
}
//Anasayfadan Yedek Parca ya tiklanir , tum vitrim ilanlari na tiklanir , acilan liste sayfasinda solda filtreme seceneklerinden durumuna ikinci el olarak isaretlenip
//tekrar ara buttonuna basilir ve search yaptirilir , search sonrasi url den filtrelemenin geldigi kontrolu yapilir , burdaki sayfadan ilk ilanin id si alinir ve ona tiklanir ,
//acilan sayfadki ilan current url icinde id nin oldugu kontrol edlir