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
    public void ApplyForSavingsIsEnabled() {
        // zadam vsetky informacie(fond, suma, email, roky)
        // tlacidlo 'Apply for saving' je enabled

        System.out.println("test01...");

        //insert at first the fixed variables
        String inputFund = "Tom & Jerry corp";
        String inputSum = "1000";
        String inputEmail = "1@tralala.com";
        String inputYears = "15";

        // fill in the fixed values
        driver.findElement(By.id("fundSelect")).sendKeys(inputFund);
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys(inputSum);
        driver.findElement(By.id("yearsInput")).sendKeys(inputYears);
        driver.findElement(By.id("emailInput")).sendKeys(inputEmail);

        // check if the button is enabled by cssSelector
        //expected action is that class when enabled "btn btn-block btn-success"

        // V1 Assert.assertEquals("btn btn-block btn-success", driver.findElement(By.cssSelector("button.btn-success")).getAttribute("class"));
        // V2
        Assert.assertTrue(driver.findElement(By.cssSelector("button.btn-success")).isEnabled());
    }

    @Test
    public void CheckIfSumsAreNotEmpty() {

        // zadam vsetky informacie(fond, suma, email, roky)
        // overim ze sumy nie su prazdne

        System.out.println("test02...");

        //insert at first the fixed variables
        String inputFund = "Tom & Jerry corp";
        String inputSum = "1000";
        String inputEmail = "1@tralala.com";
        String inputYears = "15";

        // fill in the fixed values
        driver.findElement(By.id("fundSelect")).sendKeys(inputFund);
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys(inputSum);
        driver.findElement(By.id("yearsInput")).sendKeys(inputYears);
        driver.findElement(By.id("emailInput")).sendKeys(inputEmail);

        //.div[1]/p" div.result matove riesenie
        // a som na to prisla presne o 18:40  (//body//div//div//div//p)[1]
        //driver.findElement(By.xpath("(//body//div//div//div//p)[1]")).getText();
        //By.xpath("(//body//div//div//div//p)[1]"), By.xpath("(//body//div//div//div//p)[2]")

        //expected action is that sums are not empty
        Assert.assertNotEquals("", driver.findElement(By.xpath("(//body//div//div//div//p)[1]")).getText());
        Assert.assertNotEquals("", driver.findElement(By.xpath("(//body//div//div//div//p)[2]")).getText());

    }

    @Test
    public void CheckIfRiskIsNotEmpty() {
        // zadam vsetky informacie(fond, suma, email, roky)
        // overim ze riziko nie je prazdne

        System.out.println("test03...");

        //insert at first the fixed variables
        String inputFund = "Tom & Jerry corp";
        String inputSum = "1000";
        String inputEmail = "1@tralala.com";
        String inputYears = "15";

        // fill in the fixed values
        driver.findElement(By.id("fundSelect")).sendKeys(inputFund);
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys(inputSum);
        driver.findElement(By.id("yearsInput")).sendKeys(inputYears);
        driver.findElement(By.id("emailInput")).sendKeys(inputEmail);

        //.div[1]/p" div.result matove riesenie
        // a som na to prisla presne o 18:40  (//body//div//div//div//p)[1]
        //driver.findElement(By.xpath("(//body//div//div//div//p)[1]")).getText();
        //By.xpath("(//body//div//div//div//p)[1]"), By.xpath("(//body//div//div//div//p)[2]")

        //expected action is that sums are not empty
        Assert.assertNotEquals("", driver.findElement(By.xpath("(//body//div//div//div//p)[3]")).getText());

    }

    @Test
    public void CheckIfRecentRequestContainsFund() {
        System.out.println("test04...");

        // zadam vsetky informacie(fond, suma, email, roky)
        // v casti recent requests sa zobrazi novy zaznam,
        // assert =  novy zaznam obsahuje nazov zvoleneho fondu.

        //insert at first the fixed variables
        String inputFund = "Tom & Jerry corp";
        String inputSum = "1000";
        String inputEmail = "1@tralala.com";
        String inputYears = "15";

        // fill in the fixed values
        driver.findElement(By.id("fundSelect")).sendKeys(inputFund);
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys(inputSum);
        driver.findElement(By.id("yearsInput")).sendKeys(inputYears);
        driver.findElement(By.id("emailInput")).sendKeys(inputEmail);


        driver.findElement(By.cssSelector("button.btn-success")).click();
        //p.fund-description
        //expected is that new note is added and the fund name is there and correct
        Assert.assertEquals(inputFund, driver.findElement(By.cssSelector("p.fund-description")).getText());
    }
}
