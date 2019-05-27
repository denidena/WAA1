package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KoncitaPage {

    private WebDriver pageDriver;
    public KoncitaPage(WebDriver driver) {
        this.pageDriver = driver;
    }

    public void SelectedOptionYesNoByXpath(String whatString) {
        Assert.assertFalse(pageDriver.findElement(By.xpath(whatString)).isSelected());
    }

    public String getActualKonchitaMessage() {
        return pageDriver.findElement(By.cssSelector("h1.description")).getText();
    }

    public void clickOnWurst() {
        pageDriver.findElement(By.xpath("//input[@value='wurst']")).click();
    }
}
