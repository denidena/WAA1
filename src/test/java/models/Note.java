package models;

public class Note {
    //definujem odkaz 3 premennymi
    private String title;
    private String author;
    private String message;

    public Note(String title, String author, String message) {
        this.title = title;
        this.author = author;
        this.message = message;
    }

    //zadefinujem metody typu getter
    public String getTitle(){return title;}
    public String getAuthor(){return author;}
    public String getMessage(){return message;}

}
