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
public class ClassifiedDetailTest extends BaseClass {
    private static final Logger logger = LogManager.getLogger(ClassifiedDetailTest.class);
    HomePage homePage;
    Classified classified;
    LoginPage loginPage;
    SearchPage searchPage;
    SearchResultPage searchResultPage;
    ClassifiedDetailPage classifiedDetailPage;
    YedekParcaPage yedekParcaPage;

    @BeforeEach
    public void before() {
        homePage = new HomePage(driver);
        classified = new Classified(driver);
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);
        searchResultPage = new SearchResultPage(driver);
        classifiedDetailPage = new ClassifiedDetailPage(driver);
        yedekParcaPage = new YedekParcaPage(driver);

    }

    @Test
    @DisplayName("IlanDetaydanIlanSikayetEtme ")
    public void test() {
        try {
            homePage.acceptCookie();
            homePage.clickCarCategory();
            homePage.clickAllClassifieds();
            searchResultPage.clickFirstClassified();
            classifiedDetailPage.clickComplainClassfied();
            classifiedDetailPage.selecReasons();
            classifiedDetailPage.enterCompalin();
            classifiedDetailPage.sendComplain();
            String complainPopUpmesaj = classifiedDetailPage.succesComplain();
            logger.info(complainPopUpmesaj);
            classifiedDetailPage.successComplainPopup();
            Assertions.assertEquals(complainPopUpmesaj,"Teşekkürler. Şikayetiniz en kısa sürede değerlendirilecektir.");
            logger.info(" Ilan sikayeti basarili sekilde gerceklenmistir ");
        } catch (Exception exception) {
            logger.info("Error message: Test fail");
            File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            logger.info(imageFile.getPath());
        }
    }
//ilan homepage de otomobile  tiklanir ordan tum arba ilanlari tiklanir ve ardindan gelen listedeki ilk ilana tiklanip, ilan detay acilir
// ilan detay acildiktan sonra ilan sikayet edilir tiklanir ,  sikayet icin  pop up geldigi kontrol edilir ve  reason secilir , comment alanina sikayet yazilir gondere basilir
//Basarili sekilde ilanin sikayet edildigi popUp i acildigi ve sikayet mesajinin dogru geldigi kontrol edilir

    @Test
    @DisplayName("BireyselUserileFavoriEklemeveLogin")
    public void test2() {
        try {
            homePage.acceptCookie();
            homePage.clickCarCategory();
            homePage.clickAllClassifieds();
            searchResultPage.clickFirstClassified();
            classifiedDetailPage.addFavorite();
            String popUpText = classifiedDetailPage.loginPopUpText();
            Assertions.assertEquals(popUpText, "İlanı favorilerinize eklemek için giriş yapın");
            logger.info("Favori login pop uyari mesaji : " + popUpText);
            loginPage.sendName("Bireysel").sendPassword().loginSubmit();
            logger.info(" Ilan basarili sekilde favoriye eklenmistir ");

        } catch (Exception exception) {
            logger.info("Error message: Test fail");
            File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            logger.info(imageFile.getPath());
        }
    }
    //anasayfayada otomobile kismina tiklanir , tum vitrin ilanlari tiklanir ardindan  ilk ilana tiklanir
    //ilan detay sayfasi acildiktan sonra , favorilere ekle tiklanir burada , login olmayan user oldugu icin pop up acilir ve acilan favori pop up da gelen login mesaj kontrolu edilir
    //Sonrasinda bireysel user ile login olunur


    @Test
    @DisplayName("KurumsalUserileFavoriEklemeveLogin")
    public void test3() {
        try {
            homePage.acceptCookie();
            homePage.clickYedekParca();
            homePage.clickAllYedekParca();
            yedekParcaPage.clickFirstClassfieds();
            classifiedDetailPage.addFavorite();
            String popUpText = classifiedDetailPage.loginPopUpText();
            Assertions.assertEquals(popUpText, "İlanı favorilerinize eklemek için giriş yapın");
            logger.info("Favori login pop uyari mesaji : " + popUpText);
            loginPage.sendName("Kurumsal").sendPassword().loginSubmit();
            logger.info(" Ilan basarili sekilde favoriye eklenmistir ");
        }
        catch (Exception exception) {
            logger.info("Error message: Test fail");
            File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            logger.info(imageFile.getPath());
        }
    }
    //anasayfayada yedek parcaya tiklanir sonrasinda acilan sayfada  tum vitrin ilanlari denir ve gelen sayfadaki ilk ilana tiklanir
    //ilan detay acilir ve ilan  favorilere ekler e tiklanir , login olmayan user oldugu icin favori pop up acilir ve acilan pop upda favori ile iligli login mesaji kontrol edilir
    //Sonrasinda Kurumsal user ile login olunur

}