package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GossingatorPage {

    //vzdy ked vytvory objeckt tak sa nachadza RyanButton amusi ho najst
    @FindBy(id = "addRyan")
    private WebElement addRyanButton;

    @FindBy(css = "div.ryan-counter h3")
    private WebElement ryanDescription;

    WebDriver pageDriver;


    public GossingatorPage(WebDriver driver) {
        this.pageDriver = driver;
        //nainicializujeme si element pomocou this
        PageFactory.initElements(pageDriver, this);
    }

    public void addRyan() {
        addRyanButton.click();
    }

    public String getRyanCounterNumber() {
        return pageDriver.findElement(By.id("ryanCounter")).getText();
    }

    public String getCounterDescription() {
        return ryanDescription.getText();
    }

    public int getNumberOfRyanImages() {
        return pageDriver.findElements(By.cssSelector("img")).size();
    }


}
