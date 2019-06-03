package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SavingsCalculatorPage {
    WebDriver pageDriver;

    public SavingsCalculatorPage(WebDriver driver) {
        this.pageDriver = driver;
    }

    public void enterData(String fund, String sum, String email, String years) {
        //zadam zakladne udaje
        pageDriver.findElement(By.id("fundSelect")).sendKeys(fund);
        pageDriver.findElement(By.id("oneTimeInvestmentInput")).sendKeys(sum);
        pageDriver.findElement(By.id("yearsInput")).sendKeys(years);
        pageDriver.findElement(By.id("emailInput")).sendKeys(email);
    }

    public String getTextbyCss(String inputText) {
        return pageDriver.findElement(By.cssSelector(inputText)).getText();
    }

    public String getTextbyXpath(String inputText) {
        return pageDriver.findElement(By.xpath(inputText)).getText();
    }

}

