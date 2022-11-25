package pom.test;

import extension.TestExtension;
import extension.TestStatusExtension;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pom.page.*;

@ExtendWith({TestExtension.class,TestStatusExtension.class})
public class CreateClassifiedTest extends BaseClass {
    private static final Logger logger = LogManager.getLogger(CreateClassifiedTest.class);
    HomePage homePage;

    LoginPage loginPage;

    Classified classified;
    PreviewPage previewPage;
    DopingPage dopingPage;
    SuccessPage successPage;
    CreateUser createUser;


    @BeforeEach
    public void before() {
        homePage = new HomePage(driver);
        classified = new Classified(driver);
        createUser = new CreateUser(driver);
        loginPage = new LoginPage(driver);
        previewPage = new PreviewPage(driver);
        dopingPage = new DopingPage(driver);
        successPage = new SuccessPage(driver);
    }

    @Tag("CREATE_CLASSIFIED")
    @Test
    @DisplayName("OzelDersVerenlerIlanVermeTests")
    public void test() throws InterruptedException {
        logger.info(" Ilan verme testi basladi ");
        loginPage.clickLogin();
        homePage.acceptCookie();
        loginPage.sendName("Bireysel").sendPassword();
        loginPage.loginSubmit();
        loginPage.clickSplash();
        classified.clickUcretsizIlan();
        classified.clickCategory().clickLiseUniversite().devamButton();
        classified.enterClassifiedTitle().enterDescription().enterPrice();
        classified.selectCoursePlace().selectGender().selectCity();
        classified.selectDistrict();
        classified.selectQuarter();
        classified.clickMap().clickDetailinfo().checkedAgreement().classfiedSubmit();
        previewPage.submitPreview();
        dopingPage.clickDevam();
        Thread.sleep(2000);
        successPage.successMessageCheck();
        successPage.clickBanaOzel();
        logger.info(" Basarili sekilde ilan verilmistir ");

    }
}
//Anasayfa acilir ,giris yap denir ve username ve password girildiikten sonra ucretsiz ilan ver tiklanir  Kategori olarak Ozel ders
//Verenler secilir ve Lise Universite ye tiklanir devam et denir sonrasinad ilan adi aciklamsi ucret bilgisi girilir
//Ders alani secilir sonrsainda cinsiyet tercihleri secilir , il ilce ve mahale biglisi girildikten sonra haritada yer tiklanir
//Anlasma imzalanir ve devm et e basilir sonrasinda preview adimi gelr burada ilerle denir doping adiminda devam et deendikten sonra
//
// Basarili ilan verildigi success mesaji gorulur ve onun kontrolu ile  ilan verme tamamlanir



