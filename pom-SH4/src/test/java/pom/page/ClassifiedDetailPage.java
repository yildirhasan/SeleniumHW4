package pom.page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.swing.*;

public class ClassifiedDetailPage extends BasePage {

    public ClassifiedDetailPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = ".classifiedDetailTitle h1")
    protected WebElement classifiedTitle;

    @FindBy(className = "classifiedAddFavorite")
    protected WebElement addFavorite;
    @FindBy(className = "classifiedFeedback")
    protected WebElement classifiedComplainButton;

    @FindBy(id = "btnSubmit")
    protected WebElement gonderComplainButton;

    @FindBy(id="rdReason1")
    protected WebElement selectReason;


    @FindBy(css = "[name='taInformation']")
    protected WebElement complainDescription;
    @FindBy(className = "form-success")
    protected WebElement complainPopup;

    @FindBy(css = "[class='btn btn-360 with-shadow dialog-closer']")
    protected WebElement closeComplain;

    @FindBy(id = "askQuestionLink")
    protected WebElement messageButton;

    @FindBy(id = "classifiedId")
    protected WebElement classifiedId;

    @FindBy(id= "loginPopupTitle")
    protected WebElement loginPopUptext;
    @FindBy(css = ".form-success > p")
    protected WebElement complainPopUpmesaj;


    public String getClassifiedTitle() {
        return classifiedTitle.getText();
    }
    public void addFavorite(){
        wait.until(ExpectedConditions.visibilityOf(addFavorite));
        addFavorite.click();

    }
    public void clickComplainClassfied(){
        wait.until(ExpectedConditions.visibilityOf(classifiedComplainButton));
        classifiedComplainButton.click();
    }
    public void selecReasons(){
        wait.until(ExpectedConditions.visibilityOf(selectReason));
        selectReason.click();
    }
    public void enterCompalin(){
        wait.until(ExpectedConditions.visibilityOf(complainDescription));
        complainDescription.sendKeys("Abc Abc abc abc");
    }
    public void sendComplain(){
        wait.until(ExpectedConditions.visibilityOf(gonderComplainButton));
        gonderComplainButton.click();
    }
    public void successComplainPopup(){
        wait.until(ExpectedConditions.visibilityOf(closeComplain));
        closeComplain.click();
    }
    public String succesComplain(){
        wait.until(ExpectedConditions.visibilityOf(complainPopUpmesaj));
        return complainPopUpmesaj.getText();
    }
    public void clickSendMessages(){
        wait.until(ExpectedConditions.visibilityOf(messageButton));
        messageButton.click();
    }
    public String getClassifiedID(){
        return classifiedId.getText();
    }
    public String loginPopUpText(){
        wait.until(ExpectedConditions.visibilityOf(loginPopUptext));
        return loginPopUptext.getText();
    }

}
