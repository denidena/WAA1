package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConchitaTest {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //0.spustit prehliadac
        driver = new ChromeDriver();
        //1.otvorit stranku
        driver.get("http://localhost:80/zenaalebomuz.php");
    }

    @After
    public void tearDown() {
        //vytvorenie záveru ktory sa sam spusta vzdy
        //4.zatvorit prehliadac
        driver.close();
        //5. ukoncit session
        driver.quit();
        System.out.println("koncim...");
    }

    @Test
    public void noOptionShouldBeSelected() {
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='wurst']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Zena']/input")).isSelected());
    }

    @Test
    public void itShouldSelectMale() {
        driver.findElement(By.xpath("//input[@value='wurst']")).click();
        //overit hlasku
        String expectedMessage = "It's wurst";
        String actualMessage = driver.findElement(By.cssSelector("h1.description")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);
        //overit ze moznost zena nie je vybrata
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Zena']/input")).isSelected());
    }

    @Test
    public void imgShouldBeVisible() {
        Assert.assertTrue(driver.findElement(By.cssSelector("img")).isDisplayed());
    }


}

