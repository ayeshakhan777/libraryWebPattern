/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dtos;

/**
 *
 * @author Sean
 */
public class TitleGenre {
    private Genre genre;
    private Title title;
    
    public TitleGenre(Title title, Genre genre) {
        this.title = title;
        this.genre = genre;
    }

    public TitleGenre() {
    }

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

    @Override
    public String toString() {
        return "TitleGenre{" + "genre=" + genre + ", title=" + title + '}';
    }
    
}
