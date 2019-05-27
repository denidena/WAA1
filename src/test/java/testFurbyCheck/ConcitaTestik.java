package testFurbyCheck;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.KoncitaPage;

public class ConcitaTestik extends TestBase {
    //si to tu rovno spravim a potom som vybavena
    private KoncitaPage koncita;

    @Before
    public void openPage() {
        //1.otvorit stranku
        driver.get(BASE_URL + "/zenaalebomuz.php");
        koncita= new KoncitaPage(driver);
    }

    @Test
    public void noOptionShouldBeSelected() {
        koncita.SelectedOptionYesNoByXpath("//input[@value='wurst']");
        koncita.SelectedOptionYesNoByXpath("//label[text()='Zena']/input");
    }

    @Test
    public void itShouldSelectMale() {
        koncita.clickOnWurst();
        //overit hlasku
        Assert.assertEquals("It's wurst", koncita.getActualKonchitaMessage());
        //overit ze moznost zena nie je vybrata
        koncita.SelectedOptionYesNoByXpath("//label[text()='Zena']/input");
    }

}