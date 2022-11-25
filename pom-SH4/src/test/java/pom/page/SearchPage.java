package pom.page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends BasePage {

    @FindBy(css = "[href='/arama/detayli?category=3518']")
    protected WebElement realEstate;
    @FindBy(css = "[data-label='istanbul (tumu)']")
    protected WebElement district;
    @FindBy(className = "faceted-select")
    protected WebElement city;


    @FindBy(css = "[name='price_min']")
    protected WebElement minPrice;
    @FindBy(css = "[value='Arama Yap']")
    protected WebElement search;

    @FindBy(css = "[name='price_max']")
    private WebElement maxPrice;


    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickRealEstate() {

        wait.until(ExpectedConditions.visibilityOfAllElements(realEstate));
        realEstate.click();
    }

    public void selectCity() {

        wait.until(ExpectedConditions.visibilityOfAllElements(city));
        city.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(district));
        district.click();
    }

    public void enterMinPrice() {

        wait.until(ExpectedConditions.visibilityOfAllElements(minPrice));
        minPrice.sendKeys("700");

    }

    public void enterMaxPrice() {

        wait.until(ExpectedConditions.visibilityOfAllElements(maxPrice));
        maxPrice.sendKeys("1300000");
    }

    public void applySearch() {
        wait.until(ExpectedConditions.visibilityOfAllElements(search));
        search.click();
    }
    public void searchTitleAssertion(){
        Assertions.assertEquals("https://www.sahibinden.com/otomobil", driver.getCurrentUrl());
        String categoryText = driver.findElement(By.cssSelector(".result-text-sub-group > div > h1")).getText();
        Assertions.assertEquals("Otomobil", categoryText);
    }

}
