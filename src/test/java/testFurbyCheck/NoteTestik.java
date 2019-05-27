package testFurbyCheck;

import base.TestBase;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import models.Note;
import org.junit.Before;
import org.junit.Test;
import pages.NotePage;

import java.sql.Timestamp;

public class NoteTestik extends TestBase {
    private NotePage notePage;


    @Before
    public void openPage() {
        driver.get(BASE_URL + "/odkazovac.php");
        notePage = new NotePage(driver);
      }

    @Test
    public void itShouldAddNote() throws InterruptedException {
        //vytvorim si casovu peciatku pre unikatnost title
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Fairy fairy = Fairy.create();
        Person fakePerson = fairy.person();
        //ulozim si hodnoty do premennych

        //zabalenie
        String title = "Title " + timestamp.getTime();
        String author = fakePerson.getFirstName() + " " + fakePerson.getLastName();
        String message = "toto je velmi dlhy a zmysluplny odkaz";

        //vytvorenie pouzitie noveho objektu a Note
        Note noteToAdd = new Note(title, author, message);

        notePage.enterNoteData(noteToAdd);
        notePage.submitNewNote();
        //tu pouzivam objekt.getter
        notePage.checkNoteInList(noteToAdd.getTitle());
        notePage.getLastNoteFromList().click();
        //overim detail zaznamu
        Thread.sleep(1000);
        notePage.checkNoteDetail(noteToAdd);
    }

    private String generateUniqueTitle() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return "Title " + timestamp.getTime();
    }
}