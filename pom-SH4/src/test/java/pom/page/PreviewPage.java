package pom.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PreviewPage extends BasePage {
    public PreviewPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/main/div[1]/div[2]/div[1]/button")
    protected WebElement submitPreviewButton;
    public void submitPreview(){
        wait.until(ExpectedConditions.visibilityOfAllElements(submitPreviewButton));
        submitPreviewButton.click();
    }
}
