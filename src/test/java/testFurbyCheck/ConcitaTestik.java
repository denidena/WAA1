package testFurbyCheck;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.KoncitaPage;

public class ConcitaTestik extends TestBase {

    private KoncitaPage Koncita;

    @Before
    public void openPage() {
        //1.otvorit stranku
        driver.get(BASE_URL + "/zenaalebomuz.php");
        Koncita = new KoncitaPage(driver);
    }

    @Test
    public void noOptionShouldBeSelected() {
        Koncita.SelectedOptionYesNoByXpath("//input[@value='wurst']");
        Koncita.SelectedOptionYesNoByXpath("//label[text()='Zena']/input");
    }

    @Test
    public void itShouldSelectMale() {
        Koncita.clickOnWurst();
        //overit hlasku
        Assert.assertEquals("It's wurst", Koncita.getActualKonchitaMessage());
        //overit ze moznost zena nie je vybrata
        Koncita.SelectedOptionYesNoByXpath("//label[text()='Zena']/input");
    }

}