package waaVystupnyTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SavingsCalculatorPage;

public class SavingsCalculatorTest {
    private SavingsCalculatorPage savePage;
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:80/savingscalculator.php");
        savePage = new SavingsCalculatorPage(driver);
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
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
        savePage.enterData(inputFund, inputSum, inputEmail, inputYears);

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
        savePage.enterData(inputFund, inputSum, inputEmail, inputYears);

        //.div[1]/p" div.result matove riesenie
        // a som na to prisla presne o 18:40  (//body//div//div//div//p)[1]
        //driver.findElement(By.xpath("(//body//div//div//div//p)[1]")).getText();
        //By.xpath("(//body//div//div//div//p)[1]"), By.xpath("(//body//div//div//div//p)[2]")

        //expected action is that sums are not empty
        Assert.assertNotEquals("", savePage.getTextbyXpath("(//body//div//div//div//p)[1]"));
        Assert.assertNotEquals("", savePage.getTextbyXpath("(//body//div//div//div//p)[2]"));
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
        savePage.enterData(inputFund, inputSum, inputEmail, inputYears);

        //.div[1]/p" div.result matove riesenie
        // a som na to prisla presne o 18:40  (//body//div//div//div//p)[1]
        //driver.findElement(By.xpath("(//body//div//div//div//p)[1]")).getText();
        //By.xpath("(//body//div//div//div//p)[1]"), By.xpath("(//body//div//div//div//p)[2]")
        //expected action is that sums are not empty

        Assert.assertNotEquals("", savePage.getTextbyXpath("(//body//div//div//div//p)[3]"));
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
        savePage.enterData(inputFund, inputSum, inputEmail, inputYears);
        driver.findElement(By.cssSelector("button.btn-success")).click();
        //p.fund-description
        //expected is that new note is added and the fund name is there and correct
        Assert.assertEquals(inputFund, savePage.getTextbyCss("p.fund-description"));
    }
}
