package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//komentar
public class GosslingatorTest {

    WebDriver driver;

    @Before
    public void setUp() {
        //v ramci triedy a vytvorenie metody - úvod
        //spustenie prehliadaca, otvorenie stranky,
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //0. spustit prehliadac
        //co znamena ten zapis => vytvaram novu instanciu , chcem vytvorit novy objekt "driver" z triedy WebDriver
        driver = new ChromeDriver();
        //1. otvorit stranku
        driver.get("http://localhost:80/gosslingator.php");
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
    public void itShouldAddOneRyan() {
        //vytvorenie elementu a najdenie iba raz ale pouzitie viackrat
        WebElement addRyanBtn = driver.findElement(By.id("addRyan"));
        //2. kliknut na tlacitko pridat
        addRyanBtn.click();
        //addRyanBtn.click();
        //addRyanBtn.click();
        // 3. overit pocitanie ryanov
        Assert.assertEquals("1", driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
        Assert.assertEquals("ryan", driver.findElement(By.cssSelector("div.ryan-counter h3")).getText());
        // vypisem do konzoly pocitadlo ryanov
        System.out.println("Number of Ryans is: " + driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
        // driver.findElement(By.id("ryanCounter")).getText();
    }

    @Test
    public void itShouldAddTwoRyans() {
        //2. kliknut na tlacitko pridat
        //for (int i = 0; i < 51; i++)
        //definovanie webelementov
        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        WebElement removeRyanButton = driver.findElement(By.id("removeRyan"));
        //alt+J oznacenie kazdeho dalsieho  vyskytu
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        removeRyanButton.click();
        // 3. overit pocitanie ryanov
        String NumberOfRyan = "div.ryan-counter ";
        String actualNumberOfRyans = driver.findElement(By.cssSelector(NumberOfRyan + "h2")).getText();
        String actualRyanDesc = driver.findElement(By.cssSelector(NumberOfRyan + "h3")).getText();
        Assert.assertEquals("2", actualNumberOfRyans);
        Assert.assertEquals("ryans", actualRyanDesc);
        System.out.println("Number of Ryans is: " + actualNumberOfRyans);
    }

    @Test
    public void itShouldDisplayTitle() {
        System.out.println(driver.findElement(By.cssSelector(".ryan-title")).getText());
        Assert.assertEquals("GOSLINGATE ME", driver.findElement(By.cssSelector(".ryan-title")).getText());

    }

    @Test
    public void itShouldAdd50RyansAndShowMessage() {
        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        for (int i = 0; i < 50; i++) {
            addRyanButton.click();
        }
        Assert.assertEquals("50", driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
        Assert.assertEquals("ryans", driver.findElement(By.cssSelector("div.ryan-counter h3")).getText());
        //System.out.println("message  " + driver.findElement(By.cssSelector("h1.tooManyRyans")).getText());
        Assert.assertEquals("NUMBER OF\n" +
                "RYANS\n" +
                "IS TOO DAMN\n" +
                "HIGH", driver.findElement(By.cssSelector("h1.tooManyRyans")).getText());
    }

    @Test
    public void itShoudlCheckTheNumberOfRyansOnFlyWithFor() {
        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        for (int i = 0; i < 50; i++) {
            //System.out.println(i);
            addRyanButton.click();
            String actualNoOfRyans = driver.findElement(By.id("ryanCounter")).getText();
            //prevedenie na string oba retazce
            Assert.assertEquals(String.valueOf(i + 1), actualNoOfRyans);

            //overit sklonovanie pomocou podmienky
            String actulalDescription = driver.findElement(By.cssSelector("div.ryan-counter h3")).getText();
            if (i + 1 == 1) {
                Assert.assertEquals("ryan", actulalDescription);
            }
            if (i + 1 >= 2) {
                Assert.assertEquals("ryans", actulalDescription);
            }
            //prevedenie oba retazce na cisla
            //int result = Integer.parseInt(actualNoOfRyans);
            //Assert.assertEquals(i+1, result);
        }
    }

    @Test
    public void itShoudlCheckTheNumberOfRyansOnFlyWithWhile() {
        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        String actualNoOfRyan = driver.findElement(By.id("ryanCounter")).getText();
        //! je negacia
        int clicksLimit =30;
        int clicks=0;
        while ((!actualNoOfRyan.equals("50")) && clicks<clicksLimit) {
            System.out.println(actualNoOfRyan);
            addRyanButton.click();
            actualNoOfRyan = driver.findElement(By.id("ryanCounter")).getText();
            clicks++;
        }
    }




}
