package pom.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MessagePage extends BasePage{

    private static final Logger logger = LogManager.getLogger(MessagePage.class);
    public MessagePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css="[ng-bind='topicHolder.classified.id']")
    protected WebElement classfiedID;

    @FindBy(id = "messageContent")
    protected WebElement messageBox;

    @FindBy(xpath = "/html/body/div[1]/div[1]/main/div/div/div/div[2]/div[3]/form/ul/li/button")
    protected WebElement sendMessageButton;

    public MessagePage sendMessage(){
        wait.until(ExpectedConditions.visibilityOf(messageBox)).sendKeys(" Test Mesaji girildi ");
        logger.info("Mesaj girildi ") ;
        return this;
    }
    public void clickGonderButton(){
        wait.until(ExpectedConditions.visibilityOf(sendMessageButton)).click();

    }


}
