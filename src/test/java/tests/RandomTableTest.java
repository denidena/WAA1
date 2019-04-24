package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RandomTableTest {

    @Test
    public void itShouldFindLastLine() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:80/tabulka.php");
        System.out.println(driver.findElement(By.xpath("//table/tbody/tr[last()-1]/td[2]")).getText());
        //najdenie tlacidla podla textu cez xpath
        ////button[contains(text(),'One more button')]
        

        driver.close();
        driver.quit();
    }

}
