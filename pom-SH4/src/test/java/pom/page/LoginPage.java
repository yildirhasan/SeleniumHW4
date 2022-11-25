package pom.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
    private static final Logger logger = LogManager.getLogger(LoginPage.class);
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "username")
    protected WebElement loginUsername;

    @FindBy(id = "password")
    protected WebElement loginPassword;

    @FindBy(id = "userLoginSubmitButton")
    protected WebElement submitButton;

    @FindBy(className = "forgot-guest-buy")
    protected WebElement forgetPassword;

    @FindBy(id="txtEmail")
    protected WebElement email;

    @FindBy(css = "[for='txtEmail']")
    protected WebElement forgetMailtext;

    @FindBy(id = "secure-login")
    protected WebElement loginButton;

    @FindBy(css = "#loginForm > dl > dd:nth-child(2) > label")
    protected WebElement errorMessage;

    @FindBy(id = "usernameArea")
    protected WebElement usernameArea;

    @FindBy(id="btnSubmitFpEmailForm")
    protected WebElement forgetEmailDevametbutton;


    @FindBy(css="[class='splash-price-history-icon ng-scope']")
    private WebElement splash;
    public void clickSplash(){
        wait.until(ExpectedConditions.visibilityOf(splash)).click();
    }
    public LoginPage clickLogin(){
        wait.until(ExpectedConditions.visibilityOf(loginButton)).click();
        return this;
    }
    public LoginPage sendName(String usertype){

        wait.until(ExpectedConditions.visibilityOf(loginUsername));
        if( usertype=="Bireysel" ) {
            loginUsername.sendKeys("rooter_canchi");
            return this;
        }
        else{
            loginUsername.sendKeys("emlaknormalmagaza");
            return this;
        }
    }
    public LoginPage sendPassword() {
        wait.until(ExpectedConditions.visibilityOf(loginPassword));
        loginPassword.sendKeys("password");
        return this;
    }
    public void loginSubmit(){
        submitButton.click();
    }

    public void clickforgetPassword() {
        wait.until(ExpectedConditions.visibilityOf(forgetPassword));
        forgetPassword.click();
    }
    public void assertionTextForgetPassword(){
        wait.until(ExpectedConditions.visibilityOf(forgetMailtext));
        Assertions.assertEquals(forgetMailtext.getText(), "E-posta Adresiniz");
    }
    public void sendMailForgetPassword() {
        wait.until(ExpectedConditions.visibilityOf(forgetMailtext));
        email.sendKeys("emlaknormalmagaza@sahibinden.com");
        logger.info(" Forget Password text check edildi " );
    }
    public LoginPage loginPageUrlcheck(){
        wait.until(ExpectedConditions.visibilityOf(usernameArea));
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(currentUrl,"https://banaozel.sahibinden.com/");
        return this;
    }

    public LoginPage sendKeysMethd(){
        wait.until(ExpectedConditions.visibilityOf(loginUsername)).sendKeys("abc");
        return this;
    }
    public void failedLoginMessageCheck(){
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        Assertions.assertEquals("Şifrenizi girin.",errorMessage.getText());
        logger.info(" ilgili error message  " + errorMessage.getText());
    }

}
