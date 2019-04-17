package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//komentar
public class GosslingatorTest {

    @Test
    public void  itShouldAddOneRyan(){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");

        //0. spustit prehliadac
        //co znamena ten zapis => vytvaram novu instanciu , chcem vytvorit novy objekt "driver" z triedy WebDriver
        WebDriver driver = new ChromeDriver();
        //1. otvorit stranku
        driver.get("http://localhost:80/gosslingator.php");
        //2. kliknut na tlacitko pridat
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("removeRyan")).click();
        // 3. overit pocitanie ryanov
        Assert.assertEquals("1", driver.findElement(By.id("ryanCounter")).getText());
        //4.zatvorit prehliadac
        driver.close();
        //5. ukoncit session
        driver.quit();
        // driver.findElement(By.id("ryanCounter")).getText();

    }

}
