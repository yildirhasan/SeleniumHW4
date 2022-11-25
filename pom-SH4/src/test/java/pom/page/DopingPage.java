package pom.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DopingPage extends BasePage{
    public DopingPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/main/div[1]/div[2]/p[1]/button")
    protected WebElement devamEtButton ;


    @FindBy(css = "[for='promotion-check-8']")
    protected WebElement detailSearchDoping;


    public void addDoping(){
        wait.until(ExpectedConditions.visibilityOfAllElements(detailSearchDoping));
        detailSearchDoping.click();
    }
    public void clickDevam(){
        wait.until(ExpectedConditions.visibilityOfAllElements(devamEtButton));
        wait.until(ExpectedConditions.elementToBeClickable(devamEtButton));
        devamEtButton.click();
    }

}
