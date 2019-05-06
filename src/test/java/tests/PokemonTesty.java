package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PokemonTesty {

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
        driver.get("http://localhost:80/vybersi.php");
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
    public void itShouldSelectPikaPika() {
        String selectedPokemon = "Pikachu";
        //najdem element select
        WebElement pokemonSelect = driver.findElement(By.cssSelector("select"));
        //vyberniem pokemona cez novu instanciu
        new Select(pokemonSelect).selectByVisibleText(selectedPokemon);
        //overim hlasku
        Assert.assertEquals("I choose you "+selectedPokemon+" !", driver.findElement(By.cssSelector("div h3")).getText());

    }
    @Test
    public void itShouldSelectAndCheckAllPokemons() {
        String[] selectedPokemons = {"Pikachu","Bulbasaur", "Charmander","Squirtle","Diglett","Geodude"};
        //najdem element select
        WebElement pokemonSelect = driver.findElement(By.cssSelector("select"));

        for (String pokemon : selectedPokemons) {
            //vyberiem pokemona
            new Select(pokemonSelect).selectByVisibleText(pokemon);
            //overim hlasku
            String actualMessage = driver.findElement(By.cssSelector("div h3")).getText();
            //String expectedMessage ="I choose you "+pokemon+" !";
            //zaujimavost ohladom textu
            String expectedMessageByFormat = String.format("I choose you %s !",pokemon);
            Assert.assertEquals(expectedMessageByFormat,actualMessage);
            System.out.println(pokemon);
        }
    }
}
