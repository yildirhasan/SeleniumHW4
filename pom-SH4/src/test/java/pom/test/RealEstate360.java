package pom.test;

import extension.TestExtension;
import extension.TestStatusExtension;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pom.page.HomePage;
import pom.page.LoginPage;
import pom.page.RealEstate360Page;

import java.io.File;


@ExtendWith({TestExtension.class, TestStatusExtension.class})
public class RealEstate360 extends BaseClass {
    private static final Logger logger = LogManager.getLogger(RealEstate360.class);


    HomePage homePage;
    LoginPage loginPage;

    RealEstate360Page realEstate360Page;

    @BeforeEach
    public void before() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        realEstate360Page = new RealEstate360Page(driver);

    }
    @Tag("Emlak_360")
    @DisplayName("Emlak360Test")
    @Test
    public void test() throws InterruptedException {
        try {
        homePage.acceptCookie();
        homePage.clickRealEstate360();
        Thread.sleep(2000);
        String pageTitle = driver.getCurrentUrl().substring(27);;
        logger.info(pageTitle);
        String title = realEstate360Page.pageTitleCheck();
        logger.info(title);
        Assertions.assertEquals(pageTitle,title);


    }
     catch (Exception exception) {
        logger.info("Error message: Test fail");
        File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        logger.info(imageFile.getPath());
    }
}
}
//Anasayfadan Emlak 360 a tiklanir acilan sayfaki logo Emlka-360 yazisi ile current urldeki Emlak360 title eslesdigi check edilir
