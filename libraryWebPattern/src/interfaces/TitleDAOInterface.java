/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Dtos.Title;
import Dtos.User;
import java.util.ArrayList;

/**
 *
 * @author Sean
 */
public interface TitleDAOInterface {
    //This will return an Arraylist of Titles by their description.
    //Method will check for substring inside titleDescription row.
    //Case Sensitive
    public ArrayList<Title> getTitlesByDescription(String description);
    
    //THis will return an ArrayList of Titles by their Author.
    //Method will check for eact name, not substring.
    //Case Sensitive.
    public ArrayList<Title> getTitlesByAuthor(String description);
    
    //This will return Substring of Titles by their name.
    //This will check for exact name, not substring.
    //Case Sensitive.
    public ArrayList<Title> getTitlesByName(String name);
    
    //This will return a title by their id.
    //Single Title.
    public Title getTitleByID(int id);
    
    //This will add a title into the database.
    //This must be done by a admin User.
    //Method will be rejected if they are not.
    public boolean addTitle(Title title, User admin);
}
