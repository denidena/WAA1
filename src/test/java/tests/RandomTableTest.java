package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RandomTableTest {
    WebDriver driver;

    @Before
    public void setUp() {
        //v ramci triedy a vytvorenie metody - úvod
        //spustenie prehliadaca, otvorenie stranky,
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:80/tabulka.php");
    }

    @After
    public void tearDown() {
        //vytvorenie záveru ktory sa sam spusta vzdy
        driver.close();
        driver.quit();
        System.out.println("koncim...");
    }


    @Test
    public void itShouldFindLastLine() {
        System.out.println(driver.findElement(By.xpath("//table/tbody/tr[last()-1]/td[2]")).getText());
        //najdenie tlacidla podla textu cez xpath
        ////button[contains(text(),'One more button')]
    }

}
