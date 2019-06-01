package testFurbyCheck;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JakubecTestik extends TestBase {

    @Before
    public void openPage(){
        driver.get(BASE_URL + "/geriatriahladasuperstar.php");
    }

    @Test
    public void itShouldDisplayImage() throws InterruptedException {
        driver.findElement(By.id("showHim")).click();
        By locator = By.cssSelector("img.superstar");
        //nespravny sposob a cakat kym sa zobrazí
        // Thread.sleep(3000);

        //cakaj maximalne 10 sekund
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.visibilityOfElementLocated(locator));
        Assert.assertTrue(driver.findElement(locator).isDisplayed());
    }
}
