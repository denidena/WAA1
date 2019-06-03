package waaVystupnyTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SavingsCalculatorTest {

    WebDriver driver;

    @Before
    public void setUp() {
        //spustenie prehliadaca, otvorenie stranky,
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //0. spustit prehliadac
        driver = new ChromeDriver();
        //1. otvorit stranku
        driver.get("http://localhost:80/savingscalculator.php");
        System.out.println("init...");
    }

    @After
    public void tearDown() {
        //4.zatvorit prehliadac
        driver.close();
        //5. ukoncit session
        driver.quit();
        System.out.println("exiting...");
    }


    @Test
    public void test01ApplyForSavingsIsEnabled()
    {
        System.out.println("test1...");
        //insert at first the fixed variables
        // Test01 = zadam vsetky informacie(fond, suma, email, roky)
        String inputFund = "Tom & Jerry corp";
        String inputSum = "1000";
        String inputEmail= "1@tralala.com";
        String inputYears = "15";

        // fill in the fixed values
        driver.findElement(By.id("fundSelect")).sendKeys(inputFund);
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys(inputSum);
        driver.findElement(By.id("yearsInput")).sendKeys(inputYears);
        driver.findElement(By.id("emailInput")).sendKeys(inputEmail);

        // check if the button is enabled by cssSelector
        //expected action is that class when enabled "btn btn-block btn-success"

        //driver.findElement(By.cssSelector("button.btn-success")).isEnabled();
        //Assert.assertEquals("btn btn-block btn-success", driver.findElement(By.cssSelector("button.btn-success")).getAttribute("class"));
        Assert.assertTrue(driver.findElement(By.cssSelector("button.btn-success")).isEnabled());
    }

    @Test
    public void test02CheckIfSumsAreNotEmpty()
    {
        System.out.println("test2...");
    }

    @Test
    public void test03CheckIfRiskIsNotEmpty()
    {
        System.out.println("test3...");
    }

    @Test
    public void test04CheckIfRecentRequestContainsFund()
    {
        System.out.println("test4...");
    }


}
