package pom.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class Classified  extends BasePage{
    public String ilan_title =" ILan Basligi icermektedir " ;
    public String ilan_description= " Ilan Description Description ";
    @FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/header/div[1]/ul/li[6]/a")

    protected WebElement clickClassfied;

    @FindBy(css = "[icon-id='218822']")
    protected WebElement ozelDerverenler ;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/main/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div/section[2]/div/div[1]/ul/li[1]/span")
    protected WebElement liseUniversite;

    @FindBy(css = "[track-label = 'adim_adim']")
    protected WebElement devam;

    @FindBy(css = "[name='addClassifiedTitle']")
    protected WebElement classifiedTitle;

    @FindBy(css = "[name='Açıklama']")
    protected WebElement description;

    @FindBy(css = "[name='addClassifiedPrice'] ")
    protected WebElement price;

    @FindBy(css = "[for='postRulesCheck']")
    protected WebElement aggrementCheck;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/main/div[1]/div[2]/form/div[24]/button")
    protected WebElement submitButton;

    @FindBy(css = "[for='dontSelect0']")
    protected WebElement detailInfocheck;

    public Classified(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickUcretsizIlan() {
        wait.until(ExpectedConditions.visibilityOf(clickClassfied));
        wait.until(ExpectedConditions.elementToBeClickable(clickClassfied));
        clickClassfied.click();
    }
    public Classified clickCategory(){
        wait.until(ExpectedConditions.visibilityOfAllElements(ozelDerverenler));
        ozelDerverenler.click();
        return this;
    }
    public Classified clickLiseUniversite(){
        wait.until(ExpectedConditions.visibilityOfAllElements(liseUniversite));
        liseUniversite.click();
        return this;
    }
    public void devamButton(){
        wait.until(ExpectedConditions.visibilityOfAllElements(devam));
        devam.click();
    }
    public Classified enterClassifiedTitle(){
        wait.until(ExpectedConditions.visibilityOfAllElements(classifiedTitle));
        classifiedTitle.sendKeys(ilan_title);
        return this ;
    }
    public Classified enterDescription(){
        wait.until(ExpectedConditions.visibilityOf(description)).sendKeys(ilan_description);
        return this ;
    }
    public Classified enterPrice(){
        wait.until(ExpectedConditions.visibilityOf(price)).sendKeys("1222222");
        return this;
    }
    public Classified selectGender() throws InterruptedException {
        Select select = new Select(driver.findElement(By.name("a104167")));
        Thread.sleep(2000);
        select.selectByVisibleText("Erkek");
        return this;
    }
    public Classified selectCoursePlace() throws InterruptedException {
        Select select = new Select(driver.findElement(By.name("a104166")));
        Thread.sleep(2000);
        select.selectByVisibleText("Öğrencinin Evi");
        return this;
    }

    public void selectCity() throws InterruptedException {
        Select select = new Select(driver.findElement(By.name("city")));
        Thread.sleep(2000);
        select.selectByVisibleText("Aydın");
    }
    public void selectDistrict() throws InterruptedException {
        Select select = new Select(driver.findElement(By.name("town")));
        Thread.sleep(2000);
        select.selectByVisibleText("Kuşadası");
    }
    public void selectQuarter() throws InterruptedException {
        Select select = new Select(driver.findElement(By.name("quarter")));
        Thread.sleep(2000);
        select.selectByVisibleText("Kadıkalesi Mh.");
    }
    public Classified checkedAgreement(){
        wait.until(ExpectedConditions.visibilityOf(aggrementCheck));
        aggrementCheck.click();
        return this ;
    }

    public Classified clickDetailinfo(){
        wait.until(ExpectedConditions.visibilityOf(detailInfocheck));
        detailInfocheck.click();
        return this ;
    }
    public void classfiedSubmit(){
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        submitButton.click();
    }
    public Classified clickMap() {
        Actions action = new Actions(driver);
        //  action.moveToElement(driver.findElement(By.cssSelector("[aria-roledescription='map']"),100,200).click();
        action.moveToElement(driver.findElement(By.cssSelector("[aria-roledescription='map']")), 36, 40).click();
        action.build().perform();
        return this ;
    }
}
