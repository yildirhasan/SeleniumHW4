package pom.test;

import extension.TestExtension;
import extension.TestStatusExtension;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.FindBy;
import pom.page.CreateUser;
import pom.page.HomePage;
import pom.page.LoginPage;

import java.io.File;

@ExtendWith({TestExtension.class, TestStatusExtension.class})
public class UserCreationTest extends BaseClass {

    private static final Logger logger = LogManager.getLogger(UserCreationTest.class);
    HomePage homePage;
    LoginPage loginPage;
    CreateUser createUser;

    @BeforeEach
    public void before() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        createUser = new CreateUser(driver);
    }
    @Tag("USER_CREATION")
    @DisplayName("BireyselUserOlusturmaTesti")
    @Test
    public void test() throws InterruptedException {
        try {
            homePage.acceptCookie();
            homePage.createAccount();
            createUser.enterUsername().enterSurname();
            createUser.enterPassword("Ab123456.");
            createUser.addMail();
            createUser.checkAgreement();
            createUser.createAnAccount();
            createUser.popUpisdisplayed();
            createUser.clickConfirmButton();
            createUser.mailAssertion();
            logger.info(" Basarili sekilde bireysel user olusturuldu ");
        } catch (Exception exception) {
            logger.info("Error message: Test fail");
            File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            logger.info(imageFile.getPath());
        }
    }
}
//Anasayfadan kayit ol basilir username surname mail anlasma yapilir createa acacoutn denir succes mesaj ve popup in goruntulendigi check edilir


