package pom.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;

import java.util.ArrayList;
import java.util.List;

public class BaseClass {

    WebDriver driver;

    private static final Logger logger = LogManager.getLogger(BaseClass.class);

    @BeforeAll
    public static void beforeall() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.get("http://sahibinden.com/");
        setCookie();
    }


    @AfterEach
    public void afterTest() {

        logger.info(" Driver Kapaniyor ");
        driver.quit();
    }
    public void setCookie() {
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        localStorage.setItem("feature_discovery_data",
                "{\"add-to-favorites\":{\"count\":1,\"displayedAt\":1666694107010},\"extended\":true}");
        SessionStorage sessionStorage = ((WebStorage) driver).getSessionStorage();
        sessionStorage.setItem("feature_discovery_displayed", "true");
        List<Cookie> cookieList = new ArrayList<>();
        cookieList.add(new Cookie("testBox", "5", ".sahibinden.com", "/", null));
        cookieList.add(new Cookie("tbSite", "x", ".sahibinden.com", "/", null));
        cookieList.forEach(cookie -> driver.manage().addCookie(cookie));
        Cookie cookie = driver.manage().getCookieNamed("testBox");
        Cookie cookie2 = driver.manage().getCookieNamed("tbSite");
        logger.info(" Cookieler set edildi " + cookie + cookie2);


    }
}



