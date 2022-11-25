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
public class LoginTest extends BaseClass {
    private static final Logger logger = LogManager.getLogger(LoginTest.class);
    HomePage homePage;
    LoginPage loginPage;


    @BeforeEach
    public void before() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);

    }

    @DisplayName("BasariliLoginSenaryosu")
    @Test
    public void test() {
        try {
        loginPage.clickLogin();
        loginPage.sendName("Bireysel").sendPassword();
        homePage.acceptCookie();
        loginPage.loginSubmit();
        loginPage.loginPageUrlcheck();
        logger.info(" Basarili login testi gecti ");

    }
        catch (Exception exception) {
            logger.info("Error message: Test fail");
            File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            logger.info(imageFile.getPath());
        }
    }
    //anasayfadan giris yap a tiklanir username ve password girilir login submit olur ve oage in bana ozel oldugu ile giris yapitigi konrol edilir

    @Test
    @DisplayName("ForgetPassswordKontrol ")
    public void Test2() {
        try {
        loginPage.clickLogin();
        homePage.acceptCookie();
        loginPage.sendName("Bireysel").clickforgetPassword();
        loginPage.assertionTextForgetPassword();
        loginPage.sendMailForgetPassword();
        logger.info(" Forget Password bassarili sekilde gecti ");

    }
    catch (Exception exception) {
        logger.info("Error message: Test fail");
        File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        logger.info(imageFile.getPath());
    }
}
//anasayfadan giris yap a basilir username tiklanir sonrasinda sifremi unuttum denir gelen sayfada text assertion yapilir
    //mail adresi girilir ve gondere basilir

    @Test
    @DisplayName("Login Page ErrorMessage i kontrolu ")
    public void Test3() {
        try {
        loginPage.clickLogin();
        homePage.acceptCookie();
        loginPage.sendName("Bireysel");
        loginPage.loginSubmit();
        loginPage.failedLoginMessageCheck();
        logger.info("Basarisiz login olma senaryosu error mesaj kontrolu gerceklendi ");

    }
        catch (Exception exception) {
            logger.info("Error message: Test fail");
            File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            logger.info(imageFile.getPath());
        }
    }

}
//anasayfadan girise basilir username girilir subtmie tiklanir sifre giriniz error mesajini geldigi check edilir