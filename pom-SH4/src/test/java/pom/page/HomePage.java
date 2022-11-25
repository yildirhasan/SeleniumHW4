package pom.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    private static final Logger logger = LogManager.getLogger(HomePage.class);
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css ="[title='Hesap Aç']")
    protected WebElement createAccount;
    @FindBy(css = "[title='Detaylı Arama']")
    protected WebElement detailedSearch;
    @FindBy(css = "[title='Emlak360']")
    protected WebElement realEstate360;

    @FindBy(css = "[title='Otomobil']")
    protected WebElement car;

    @FindBy(css = "[title='Tüm vitrin ilanlarını göster']")
    protected WebElement tumilanlar;

    @FindBy(css = "[title='Emlak']")
    protected WebElement realEstate;
    @FindBy(css = "[title='Yedek Parça, Aksesuar, Donanım & Tuning']")
    protected WebElement yedepParcaKategorisi;
    @FindBy(id = "onetrust-accept-btn-handler")
    protected WebElement cookieAccept;

    @FindBy(className = "all-classifieds-link")
    protected WebElement showAllCarClassified;
    @FindBy(css = "[title='iphone 12 mini']")
    protected WebElement populerSearch1;

    @FindBy(css ="[class='classifiedTitle']")
    protected WebElement title;
    @FindBy( css = ".searchResultsPriceValue > div span")
    protected WebElement price;
    @FindBy(css = " .classifiedDetailTitle h1")
    protected WebElement classfiedTitle;
    public void clickRealEstateCategory() {
        wait.until(ExpectedConditions.visibilityOf(realEstate)).click();

    }
    public void clickYedekParca(){
        wait.until(ExpectedConditions.visibilityOf(yedepParcaKategorisi)).click();
    }
    public void clickAllYedekParca(){
        wait.until(ExpectedConditions.visibilityOf(tumilanlar)).click();
    }
    public void clickCarCategory() {
        wait.until(ExpectedConditions.visibilityOfAllElements(car));
        car.click();
    }
    public void acceptCookie() {
        wait.until(ExpectedConditions.visibilityOf(cookieAccept));
        cookieAccept.click();
    }
    public void createAccount(){
        wait.until(ExpectedConditions.visibilityOf(createAccount));
        createAccount.click();
    }

    public void clickDetailedSearch() {
        wait.until(ExpectedConditions.visibilityOfAllElements(detailedSearch));
        detailedSearch.click();
    }
    public void clickAllClassifieds(){
        wait.until(ExpectedConditions.visibilityOf(showAllCarClassified));
        showAllCarClassified.click();
    }
    public void clickRealEstate360(){
        wait.until(ExpectedConditions.visibilityOf(realEstate360));
        realEstate360.click();
    }
    public void clickPopuler1() {

        wait.until(ExpectedConditions.visibilityOf(populerSearch1));
        populerSearch1.click();
    }



    public String getTitle()throws InterruptedException{
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(classfiedTitle));
        return classfiedTitle.getText();
    }
    public String getPrice() throws InterruptedException{
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(price));
        return price.getText();
    }


}
