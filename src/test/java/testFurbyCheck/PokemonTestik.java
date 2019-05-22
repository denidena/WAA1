package testFurbyCheck;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.PokePokePage;

public class PokemonTestik extends TestBase {

    private PokePokePage PokePage;

    @Before
    public void openPage() {
        //1.otvorit stranku
        driver.get(BASE_URL + "/vybersi.php");
        PokePage = new PokePokePage(driver);
    }

    @Test
    public void itShouldSelectPokemons() {
        String[] selectedPokemons = {"Pikachu", "Bulbasaur", "Charmander", "Diglett", "Geodude"};

        for (String pokemon : selectedPokemons) {
            //vyberiem pokemona
            PokePage.selectPokemon(pokemon);
            //overim hlasku
            Assert.assertEquals(getFormattedMessage(pokemon), PokePage.getActualMessage());
        }
    }

    //pomocna metoda k testom len formatuje veci, nie je to akcia
    private String getFormattedMessage(String pokemonName) {
        return String.format("I choose you %s !", pokemonName);
    }

}