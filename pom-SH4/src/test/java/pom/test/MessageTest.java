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
public class MessageTest extends BaseClass {
    private static final Logger logger = LogManager.getLogger(MessageTest.class);
    HomePage homePage;
    LoginPage loginPage;
    SearchResultPage searchResultPage;
    ClassifiedDetailPage classifiedDetailPage;
    MessagePage messagePage;

    YedekParcaPage yedekParcaPage;

    @BeforeEach
    public void before() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        searchResultPage = new SearchResultPage(driver);
        classifiedDetailPage = new ClassifiedDetailPage(driver);
        messagePage = new MessagePage(driver);
        yedekParcaPage = new YedekParcaPage(driver);
    }

    @Test
    @DisplayName("BireyselUserMessageTest")
    public void test() {
        try {
            homePage.acceptCookie();
        homePage.clickCarCategory();
        homePage.clickAllClassifieds();
        searchResultPage.clickFirstClassified();
        String classifiedID = classifiedDetailPage.getClassifiedID();
        logger.info(" Ilgili ilan id = "  + classifiedID);
        classifiedDetailPage.clickSendMessages();
        String popUpText = classifiedDetailPage.loginPopUpText();
        logger.info("Mesajlasma pop uyari mesaji : " + popUpText);
        loginPage.sendName("Bireysel").sendPassword().loginSubmit();
        String currentUrl = driver.getCurrentUrl();
        messagePage.sendMessage().clickGonderButton();
        logger.info(" Bireysel user ile  mesaj basarili sekilde gonderildi ");

    }
        catch (Exception exception) {
            logger.info("Error message: Test fail");
            File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            logger.info(imageFile.getPath());
        }
    }
    //anasayfayada otomobile tiklanir tum vitrin ilanlari denir ve gelen sayfadan ilk ilanin id si alinir , ve ilk ilana tiklanir
//ilan detay acilir mesaj gonder yapilir  eklenir login olmayan user oldugu icin pop up acilir ve pop up mesaji dogru geldigi  kontrol edilir
//Bireysel user ile login olunur ve ilgili ilan icin mesaj gonderilir  eklenmis olur
    @Test
    @DisplayName("KurumsaluserMessageTest" )
    public void test2() {
        try {
        homePage.acceptCookie();
        homePage.clickCarCategory();
        homePage.clickAllClassifieds();
        searchResultPage.clickFirstClassified();
        String classifiedID = classifiedDetailPage.getClassifiedID();
        logger.info(" Ilgili ilan id = "  + classifiedID);
        classifiedDetailPage.clickSendMessages();
        String popUpText = classifiedDetailPage.loginPopUpText();
        logger.info("Mesajlasma pop uyari mesaji : " + popUpText);
        loginPage.sendName("Kurumsal").sendPassword().loginSubmit();
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(popUpText, "Mesaj göndermek için giriş yapın");
        messagePage.sendMessage().clickGonderButton();
        logger.info(" Kurumsal user ile mesaj basarili sekilde gonderildi ");

    }
    catch (Exception exception) {
        logger.info("Error message: Test fail");
        File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        logger.info(imageFile.getPath());
    }
}
}
//anasayfayada otomobile tiklanir tum vitrin ilanlari tiklanip ardindan gelen sayfada, ilk  ilanin idsi alinir ve  ilk ilana tiklanir , aiclan sayfadaki ilan id ile kontrol edilir
//ilan detay acilir acilan ilan detayda mesaja gonder tiklanir ,    login olmayan user oldugu icin pop up acilir ve pop up mesaji dogru geldigi  kontrol edilir
//kurumsal user ile login olunur ve ilgili ilan icin mesaj gonderilir
