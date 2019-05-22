package testFurbyCheck;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.PokePokePage;

public class PokemonTestik extends TestBase {

    private PokePokePage PokePokePage;

    @Before
    public void openPage() {
        //1.otvorit stranku
        driver.get(BASE_URL + "/vybersi.php");
        PokePokePage = new PokePokePage(driver);
    }

    @Test
    public void itShouldSelectPokemons() {
        String[] selectedPokemons = {"Pikachu", "Bulbasaur", "Charmander", "Diglett", "Geodude"};

        for (String pokemon : selectedPokemons) {
            //vyberiem pokemona
            PokePokePage.selectPokemon(pokemon);
            //overim hlasku
            Assert.assertEquals(PokePokePage.getExpectedMessage(pokemon), PokePokePage.getActualMessage());
        }
    }


}