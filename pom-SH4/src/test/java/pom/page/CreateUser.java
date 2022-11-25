package pom.page;

import org.junit.jupiter.api.Assertions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class CreateUser extends BasePage{
    public CreateUser(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(id = "name")
    protected WebElement username;
    @FindBy(id = "surname")
    protected WebElement surname;
    @FindBy(id = "email")
    protected WebElement email;
    @FindBy(id = "password")
    protected WebElement password;
    @FindBy(id="endUserLicenceAgreement")
    protected WebElement licenceAgreement;
    @FindBy(id="signUpButton")
    protected WebElement signUpButton;
    @FindBy(id="confirmSubmit")
    protected WebElement confirmButton;
    @FindBy(id="cboxContent")
    protected WebElement popUpComfirm;
    @FindBy(className = "email")
    protected WebElement lastPageMail;
    @FindBy(id = "colorbox")
    protected WebElement popUpBox;
    @FindBy(css = "[class='email']")
    protected WebElement epostaKayitMail;


    public CreateUser enterUsername(){
         wait.until(ExpectedConditions.visibilityOf(username)).sendKeys("TestUser");
        return this;
    }
    public CreateUser enterSurname(){
        wait.until(ExpectedConditions.visibilityOf(surname)).sendKeys("TestUser");
        return this;
    }
    public void enterPassword(String x){
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(x);

    }
    public void addMail(){
        wait.until(ExpectedConditions.visibilityOf(email)).sendKeys("TestUser"+( Math.random()*100) + "@mailinator.com");
    }
    public void checkAgreement(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#endUserLicenceAgreement').click()");

    }
    public void createAnAccount(){
        wait.until(ExpectedConditions.visibilityOf(signUpButton)).click();

    }
    public void clickConfirmButton(){
        wait.until(ExpectedConditions.visibilityOf(popUpComfirm));
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton));
        confirmButton.click();
    }
    public void mailAssertion(){
        wait.until(ExpectedConditions.visibilityOf(epostaKayitMail));
        String epostaKAyitmail = epostaKayitMail.getText();



    }
    public void popUpisdisplayed(){
        wait.until(ExpectedConditions.visibilityOf(popUpBox));
        Assertions.assertTrue(popUpBox.isDisplayed());
    }

}
