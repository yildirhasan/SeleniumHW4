package pom.page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class YedekParcaPage extends BasePage{
    public YedekParcaPage(WebDriver webDriver) {
        super(webDriver);
    }


    @FindBy(css = "[data-id='34']")
    protected WebElement filtreCity;

    @FindBy(css = "[title='İl']")
    protected WebElement filtre;

    @FindBy(css = "[class='sticky-search-button fixed with-disclaimer-bar'] > button")
    protected WebElement searchButton;

    @FindBy(css = "[data-id='condition']")
    protected WebElement condition;

    @FindBy(css = "[title='İkinci El']")
    protected WebElement conditionTitle;
    @FindBy(css = ".searchGalleryBorder tr td:nth-child(1)")
    protected List<WebElement> searchResultClassifeids;

    @FindBy(css = "#searchResultsGallery tr td:nth-child(1) tr")
    protected List<WebElement> searchResultClassifeidsID;


    public void clickSearch(){
        wait.until(ExpectedConditions.visibilityOfAllElements(searchButton));
        searchButton.click();
    }
    public void selectCity () throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOfAllElements(filtre));
        Select select = new Select(driver.findElement(By.name("il")));
        Thread.sleep(2000);
        select.selectByVisibleText("Aydın");;
    }
    public YedekParcaPage clickCondition(){
        wait.until(ExpectedConditions.visibilityOf(condition)).click();
        return this;
    }
    public YedekParcaPage conditonCheck(){
        wait.until(ExpectedConditions.visibilityOf(conditionTitle));
        Assertions.assertTrue(driver.getCurrentUrl().contains("category=39"));
        return this;
    }
    public void clickFirstClassfieds(){
        searchResultClassifeids.get(0).click();
    }
    public String getClassfiedID(){
        return searchResultClassifeidsID.get(0).getAttribute("data-id");
    }







}
