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

    /**
     * This is used to create a genre object.<p>
     * Not useful on its own but is used mainly to create a titleGenre object.
     * @param genreID Used to identify spot in database. Primary key.
     * @param genre Stores what genre it is.
     */
    public Genre(int genreID, String genre) {
        this.genreID = genreID;
        this.genre = genre;
    }

    /**
     * Same usage as Main constructor.<p>
     * Only use when creating a genre object not pulled from database.
     * @param genre
     */
    public Genre(String genre) {
        this.genre = genre;
    }
    
    /**
     *
     */
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
