package testFurbyCheck;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.GossingatorPage;

public class RyanGoslingTestik extends TestBase {

    private GossingatorPage gossPage;
    private String actualNumberOfRyans; //private = viditelna len pre triedu

    @Before
    public void openPage() {
        //1.otvorit stranku
        driver.get(BASE_URL + "/gosslingator.php");
        gossPage = new GossingatorPage(driver);
    }

    @Test
    public void itShouldAddOneRyan() {
        //v ramci kazdeho testu vytvorim novu triedu a instanciu triedy
        //2.kliknut na tlacidlo pridat
        gossPage.addRyan();
        //3.overit pocitanie ryanov
        Assert.assertEquals("1", gossPage.getRyanCounterNumber());
        // vypisem si do console aktualny pocet z pocitadla ryanov
        Assert.assertEquals("ryan", gossPage.getCounterDescription());
    }

    @Test
    public void itShouldTwoRyans() {
        //2.kliknut na tlacidlo pridat
        gossPage.addRyan();
        gossPage.addRyan();
        //3.overit pocitanie ryanov
        Assert.assertEquals("2", gossPage.getRyanCounterNumber());
        Assert.assertEquals("ryans", gossPage.getCounterDescription());
    }

    @Test
    public void itShouldDisplayTitle() {
        System.out.println(driver.findElement(By.cssSelector(".ryan-title")).getText());
        Assert.assertEquals("GOSLINGATE ME", driver.findElement(By.cssSelector(".ryan-title")).getText());
    }

    @Test
    public void itShouldDisplayWarningMessage() {
        //toto raz bude for cyklus
        for (int i = 0; i < 50; i++) {
            //2.kliknut na tlacidlo pridat
            gossPage.addRyan();
            //porovnam skutocnu hodnotu zo stranky s hodnotou indexu +1
            //index si musim premenit na String aby som ich mohol porovnat
            Assert.assertEquals(String.valueOf(i + 1), gossPage.getRyanCounterNumber());

            //overit sklonovanie pomocou podmienky
            if (i + 1 == 1) {
                Assert.assertEquals("ryan", gossPage.getCounterDescription());
            }
            if (i + 1 >= 2) {
                Assert.assertEquals("ryans", gossPage.getCounterDescription());
            }

            //overim pocet obrazkov ryana
            Assert.assertEquals(i + 1, gossPage.getNumberOfRyanImages());
            System.out.println("index i = " + i);
            System.out.println("pocet ryanov = " + gossPage.getRyanCounterNumber());
        }
        Assert.assertEquals(
                "NUMBER OF\n" +
                        "RYANS\n" +
                        "IS TOO DAMN\n" +
                        "HIGH",
                driver.findElement(By.cssSelector("h1.tooManyRyans")).getText()
        );
    }

    @Test
    public void itShouldDisplayWarningMessageUsingWhileCycle() {
        //while cyklus sa vykona vzdy ak je podmienka "true"
        int clicksLimit = 30;
        int clicks = 0;
        while (!gossPage.getRyanCounterNumber().equals("50") && clicks < clicksLimit) {
            gossPage.addRyan();
            clicks++;
        }
    }

    //  #2priklad: otestujte v cykle pocet zobrazenych obrazkov ryana.
    @Test
    public void itShouldDisplayNoRyanOnPageOpen() {
        Assert.assertEquals(0, gossPage.getNumberOfRyanImages());
    }


}