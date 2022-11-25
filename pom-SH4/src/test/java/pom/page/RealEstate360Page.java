package pom.page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RealEstate360Page extends BasePage{

    public RealEstate360Page(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(id = "btnCreateRei")
    protected WebElement createEndex;
    @FindBy(css = "[title='Emlak360']")
    protected WebElement pageTitle;



    public void selectCity()throws InterruptedException{
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlReiCity")));
        Select select = new Select(driver.findElement(By.name("ddlReiCity")));
        Thread.sleep(2000);
        select.selectByVisibleText("istanbul");
        //select.selectByValue("34");
       // select.selectByVisibleText("İstanbul");

       // select.selectByVisibleText("İstanbul");
       // select.selectByVisibleText("istanbul");
    }
    public void selectDistrict()throws InterruptedException{
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlReiTown")));
        Select select = new Select(driver.findElement(By.name("ddlReiTown")));
        Thread.sleep(2000);
        select.selectByValue("420");
       // select.selectByVisibleText("Adalar");
    }
    public String pageTitleCheck(){
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        return pageTitle.getText().toLowerCase();
    }
    public void selectQuarter()throws InterruptedException {
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlReiQuarter")));
        Select select = new Select(driver.findElement(By.name("ddlReiQuarter")));
        Thread.sleep(2000);
        select.selectByValue("52014");
       // select.selectByVisibleText("Heybeliada Mah.");
    }
    public void createAnEndex(){
        wait.until(ExpectedConditions.visibilityOf(createEndex));
        createEndex.click();
    }



}
