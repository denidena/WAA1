package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//komentar
public class GosslingatorTest {

    @Test
    public void itShouldAddOneRyan() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        //0. spustit prehliadac
        //co znamena ten zapis => vytvaram novu instanciu , chcem vytvorit novy objekt "driver" z triedy WebDriver
        WebDriver driver = new ChromeDriver();
        //1. otvorit stranku
        driver.get("http://localhost:80/gosslingator.php");
        //2. kliknut na tlacitko pridat
        driver.findElement(By.id("addRyan")).click();
        //driver.findElement(By.id("addRyan")).click();
        //driver.findElement(By.id("removeRyan")).click();
        // 3. overit pocitanie ryanov
        Assert.assertEquals("1", driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
        Assert.assertEquals("ryan", driver.findElement(By.cssSelector("div.ryan-counter h3")).getText());
        // vypisem do konzoly pocitadlo ryanov
        System.out.println("Number of Ryans is: " + driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
        //4.zatvorit prehliadac
        driver.close();
        //5. ukoncit session
        driver.quit();
        // driver.findElement(By.id("ryanCounter")).getText();

    }

    @Test
    public void itShouldAddTwoRyans() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        //0. spustit prehliadac
        //co znamena ten zapis => vytvaram novu instanciu , chcem vytvorit novy objekt "driver" z triedy WebDriver
        WebDriver driver = new ChromeDriver();
        //1. otvorit stranku
        driver.get("http://localhost:80/gosslingator.php");
        //2. kliknut na tlacitko pridat
        //for (int i = 0; i < 51; i++)

        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("removeRyan")).click();
        // 3. overit pocitanie ryanov
        Assert.assertEquals("2", driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
        Assert.assertEquals("ryans", driver.findElement(By.cssSelector("div.ryan-counter h3")).getText());
        System.out.println("Number of Ryans is: " + driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
        //4.zatvorit prehliadac
        driver.close();
        //5. ukoncit session
        driver.quit();
        // driver.findElement(By.id("ryanCounter")).getText();

    }

    @Test
    public void itShouldDisplayTitle() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:80/gosslingator.php");
        System.out.println(driver.findElement(By.cssSelector(".ryan-title")).getText());
        Assert.assertEquals("GOSLINGATE ME", driver.findElement(By.cssSelector(".ryan-title")).getText());
        driver.close();
        driver.quit();
    }

    @Test
    public void itShouldAdd50RyansAndShowMessage() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:80/gosslingator.php");
        for (int i = 0; i < 50; i++) {
            driver.findElement(By.id("addRyan")).click();
        }
        Assert.assertEquals("50", driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
        Assert.assertEquals("ryans", driver.findElement(By.cssSelector("div.ryan-counter h3")).getText());

        System.out.println("message  " + driver.findElement(By.cssSelector("h1.tooManyRyans")).getText());
        Assert.assertEquals("NUMBER OF\n" +
                "RYANS\n" +
                "IS TOO DAMN\n" +
                "HIGH", driver.findElement(By.cssSelector("h1.tooManyRyans")).getText());

        driver.close();
        driver.quit();

    }


}
