package pages;

import models.Note;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotePage {
    //find by title, autor , message, submit
    @FindBy(name = "title")
    private WebElement titleInput;

    @FindBy(name = "author")
    private WebElement authorInput;

    @FindBy(name = "message")
    private WebElement messageInput;

    @FindBy(css = "button.btn-block")
    private WebElement submitButton;

    private WebDriver pageDriver;

    public NotePage(WebDriver driver) {
        this.pageDriver = driver;
        //nainicializujeme si element pomocou this
        PageFactory.initElements(pageDriver, this);
    }

    //prepisem cez getteri
    public void enterNoteData(Note note) {
        titleInput.sendKeys(note.getTitle());
        authorInput.sendKeys(note.getAuthor());
        messageInput.sendKeys(note.getMessage());
    }

    public void submitNewNote() {
        submitButton.click();
    }

    public WebElement getLastNoteFromList() {
        return pageDriver.findElement(By.cssSelector("ul.list-of-sins > li:last-child"));
    }

    public void checkNoteDetail(Note note) {
        WebElement detail = pageDriver.findElement(By.cssSelector("div.content"));
        Assert.assertEquals(note.getTitle(), detail.findElement(By.cssSelector("h4.title")).getText());
        Assert.assertEquals(note.getAuthor(), detail.findElement(By.cssSelector("h4.recipent")).getText());
        Assert.assertEquals(note.getMessage(), detail.findElement(By.cssSelector("p")).getText());
    }

    public void checkNoteInList(String title) {
        WebElement listItem = getLastNoteFromList();
        //overim ze sa pridal novy zaznam do zoznamu
        Assert.assertTrue(listItem.getText().contains(title));
        //overenie linku
        Assert.assertTrue(listItem.findElement(By.cssSelector("div.description a")).isDisplayed());
        Assert.assertEquals("detail", listItem.findElement(By.cssSelector("div.description a")).getText());
    }


}
