package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    WebDriver pageDriver;

    public RegistrationPage(WebDriver driver){this.pageDriver = driver;}

    public void enterData (String email, String meno, String priezvisko, String heslo)
    {
        //zadam zakladne udaje
        pageDriver.findElement(By.name("email")).sendKeys(email);
        pageDriver.findElement(By.name("name")).sendKeys(meno);
        pageDriver.findElement(By.name("surname")).sendKeys(priezvisko);
        pageDriver.findElement(By.name("password")).sendKeys(heslo);
        pageDriver.findElement(By.name("password-repeat")).sendKeys(heslo);
    }

}
