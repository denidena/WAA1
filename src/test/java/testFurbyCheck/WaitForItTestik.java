package testFurbyCheck;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForItTestik extends TestBase {

    @Before
    public void openPage() {
        driver.get(BASE_URL + "/waitforit.php");
    }

    @Test
    public void waitForValue() {
        String expectedText = "dary !!!";
        //        Thread.sleep(5000);
        driver.findElement(By.id("startWaitForText")).click();
        WebElement input = driver.findElement(By.id("startWaitForText"));

        new WebDriverWait(driver, 5).
                until(ExpectedConditions.attributeToBe(input, "value", expectedText));
        Assert.assertEquals(expectedText, input.getAttribute("value"));

    }

    @Test
    public void waitforClass() {
        String expectedClass = "error";
        //        Thread.sleep(5000);
        driver.findElement(By.id("startWaitForProperty")).click();
        new WebDriverWait(driver, 5).
                until(ExpectedConditions.attributeContains(By.id("startWaitForProperty"), "class", expectedClass));
        //Assert.assertEquals(expectedText, input.getAttribute("class"));
    }

}
