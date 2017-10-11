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
public class Genre {
    private int genreID;
    private String genre;

    public Genre(int genreID, String genre) {
        this.genreID = genreID;
        this.genre = genre;
    }

    public Genre(String genre) {
        this.genre = genre;
    }
    
    public Genre() {
        
    }

    public int getGenreID() {
        return genreID;
    }
    
    public void setGenreID(int genreID) {
        this.genreID = genreID;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    
}
