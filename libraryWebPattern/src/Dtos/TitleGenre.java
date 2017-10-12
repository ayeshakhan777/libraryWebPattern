package Dtos;

/**
 *
 * @author Sean
 */
//Title genre is used to link Titles to genres.
//This is done by creating 2 objects: Title and Genre.
//These are stored as ID's in database but creating them as objects in application will allow for more control/freedom.

public class TitleGenre {
    private Genre genre; //What type of title the book is.
                         //Used to find books suited to users interest.
    private Title title; //Title object, Used to identify what title the genre is identifying.
    
    //Constructor for TitleGenre
    //Title and Genre object are created by method when pulling from DB.
    public TitleGenre(Title title, Genre genre) {
        this.title = title;
        this.genre = genre;
    }

    //Default Constructor
    //No info
    public TitleGenre() {
    }

    //Getters and Setters for Objects
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    //toString of TitleGenre
    //Returns all info in single string
    @Override
    public String toString() {
        return "TitleGenre{" + "genre=" + genre + ", title=" + title + '}';
    }
    
}
