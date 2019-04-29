package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathTest {
    WebDriver driver;
    @Before
    public void setUp() {
        //v ramci triedy a vytvorenie metody - úvod
        //spustenie prehliadaca, otvorenie stranky,
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:80/xpathtrainingcenter.php");
    }
    @After
    public void tearDown() {
        //vytvorenie záveru ktory sa sam spusta vzdy
        driver.close();
        driver.quit();
        System.out.println("koncim...");
    }

    @Test
    public void itShouldDisplayAction() {
        String ButtonToClick="//button[contains(text(),'One more button')]";
        driver.findElement(By.xpath(ButtonToClick)).click();
        String AktualMessage = driver.findElement(By.cssSelector("div.output h2 span")).getText();
        Assert.assertEquals("you clicked one more button", AktualMessage);
        System.out.println(driver.findElement(By.xpath(ButtonToClick)).getText());
    }

    @Test
    public void itShouldDisplayEnteredMessage() {
        String message = "vonku prsi";
        driver.findElement(By.cssSelector("input")).sendKeys(message);
        //stalcim tladidlo hit me a overim hlasku
        driver.findElement(By.id("hitme")).click();
        //precitam hodnotu zo stranky a ulozim do premennej
        String actualMessage = driver.findElement(By.cssSelector("div.output h2 span")).getText();
        //pouzijem hodnotu
        Assert.assertEquals("you entered "+message, actualMessage);
    }
}
