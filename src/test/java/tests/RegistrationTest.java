package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationTest {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:80/registracia.php");
        System.out.println("open...");
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
        System.out.println("exit...");
    }

    @Test
    public void itShouldRegisterValidUser() {
        System.out.println("TestRun...");
        //definovanie premennych
        String meno = "branislava";
        String priezvisko = "mojsejova";
        String email = meno + "." + priezvisko + "@gmail.sk";
        String heslo = "333666999";
        // vyplnenie udajov na stranke
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("name")).sendKeys(meno);
        driver.findElement(By.name("surname")).sendKeys(priezvisko);
        driver.findElement(By.name("password")).sendKeys(heslo);
        driver.findElement(By.name("password-repeat")).sendKeys(heslo);

        //kliknut na chaeckbox ze som robot
        driver.findElement(By.id("checkbox")).click();
        //kliknut na tlacidlo registrivat sa
        driver.findElement(By.cssSelector("button")).click();
        //overenie zobrazenie elementu
        //driver.findElement(By.cssSelector("div.alert-success"));
        //over ze ci je pravda ze tento element je zobrazerny
        Assert.assertTrue(driver.findElement(By.cssSelector("div.alert-success")).isDisplayed());
        //over ze ci je nepravda ze tento element nie je zobrazerny
        Assert.assertFalse(!driver.findElement(By.cssSelector("div.alert-success")).isDisplayed());
        //porovnanie ocakavaneho s hodnotou v hlaske
        Assert.assertEquals("Registracia uspesna!", driver.findElement(By.cssSelector("div.alert-success")).getText());
    }

    @Test
    public void itShouldRegisterNonValidUser() {
        System.out.println("TestRun...");
        //definovanie premennych
        String meno = "branislava";
        String priezvisko = "mojsejova";
        String email = meno + "." + priezvisko + "@gmail.sk";
        String heslo = "333666999";
        // vyplnenie udajov na stranke
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("name")).sendKeys(meno);
        driver.findElement(By.name("surname")).sendKeys(priezvisko);
        driver.findElement(By.name("password")).sendKeys(heslo);

        //kliknut na chaeckbox ze som robot
        driver.findElement(By.id("checkbox")).click();
        //kliknut na tlacidlo registrivat sa
        driver.findElement(By.cssSelector("button")).click();
        //overenie zobrazenie elementu
        //driver.findElement(By.cssSelector("div.alert-danger"));
        //over ze ci je pravda ze tento element je zobrazerny
        Assert.assertTrue(driver.findElement(By.cssSelector("div.alert-danger")).isDisplayed());
        //porovnanie ocakavaneho s hodnotou v hlaske
        Assert.assertEquals("Registracia neuspesna!", driver.findElement(By.cssSelector("div.alert-danger")).getText());
    }

}
