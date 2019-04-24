package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RandomXpathTest {

    @Test
    public void itShouldFindLastLine() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:80/xpathtrainingcenter.php");
        System.out.println(driver.findElement(By.xpath("//button[contains(@class,'btn-danger')]")).getText());
        //najdenie tlacidla podla textu cez xpath
        ////button[contains(text(),'One more button')]
        // button[contains(@class,'btn-danger')]
        driver.close();
        driver.quit();
    }


}
