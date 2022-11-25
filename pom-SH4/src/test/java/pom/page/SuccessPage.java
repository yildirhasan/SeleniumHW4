package pom.page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom.page.BasePage;

public class SuccessPage extends BasePage{

    public SuccessPage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/main/div[1]/div[2]/div/div[2]/div[2]/a")
    protected WebElement banaOzel;

    @FindBy(css = "div.pre-info h3")
    protected WebElement successMessage;


    public void clickBanaOzel(){

        wait.until(ExpectedConditions.visibilityOf(banaOzel));
        banaOzel.click();
    }
    public void successMessageCheck(){
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        Assertions.assertEquals(successMessage.getText(),"Tebrikler! İlanınızın milyonlarca kişi ile buluşmasına çok az kaldı.");
    }

 }
