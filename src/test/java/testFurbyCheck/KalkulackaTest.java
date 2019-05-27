package testFurbyCheck;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class KalkulackaTest {


    @Test
    public void testujemeSpocitaj() {
        WebDriver driver;
        //spustenie prehliadaca, otvorenie stranky,
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:80/kalkulacka.php");
        String prveCislo;
        String druheCislo;
        prveCislo="10";
        druheCislo = "20";

        driver.findElement(By.id("firstInput")).sendKeys(prveCislo);
        driver.findElement(By.id("secondInput")).sendKeys(druheCislo);
        driver.findElement(By.id("count")).click();
        //testujem ze ci sa spocita spravne
        System.out.println(driver.findElement(By.id("result")).getText());
        Assert.assertEquals("30",driver.findElement(By.id("result")).getText());
        //testujem ci vysledky su spravne vlastne
        System.out.println(driver.findElement(By.cssSelector("div div ul li")).getText());
        Assert.assertEquals("10+20 = 30",driver.findElement(By.cssSelector("div div ul li")).getText());

        driver.close();
        driver.quit();
    }


    @Test
    public void testujemeOdpocitaj() {
        WebDriver driver;
        //spustenie prehliadaca, otvorenie stranky,
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:80/kalkulacka.php");
        String prveCislo;
        String druheCislo;
        prveCislo="10";
        druheCislo = "20";

        driver.findElement(By.id("firstInput")).sendKeys(prveCislo);
        driver.findElement(By.id("secondInput")).sendKeys(druheCislo);
        driver.findElement(By.id("deduct")).click();
        //testujem ze ci sa spocita spravne
        System.out.println(driver.findElement(By.id("result")).getText());
        Assert.assertEquals("-10",driver.findElement(By.id("result")).getText());
        //testujem ci vysledky su spravne vlastne
        System.out.println(driver.findElement(By.cssSelector("div div ul li")).getText());
        Assert.assertEquals("10-20 = -10",driver.findElement(By.cssSelector("div div ul li")).getText());

        driver.close();
        driver.quit();
    }


}
