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

    /**
     * This will return an ArrayList of Titles by their description.<p>
     * Method will check for substring inside titleDescription row.<p>
     * Case Sensitive
     * @param description This will allow for title to be found based on user input.
     * @return ArrayList of relevant Titles.
     */
    public ArrayList<Title> getTitlesByDescription(String description);
    

    /**
     * This will return an ArrayList of Titles by their Author.<p>
     * Method will check for exact name, not substring.<p>
     * Case Sensitive.
     * @param description This will allow for title to be found based on user input.
     * @return ArrayList of relevant Titles.
     */
    public ArrayList<Title> getTitlesByAuthor(String description);


    /**
     * This will return Substring of Titles by their name.<p>
     * This will check for exact name, not substring.<p>
     * Case Sensitive.
     * @param name This will allow for user to find title by Author
     * @return ArrayList of relevant Titles.
     */
    public ArrayList<Title> getTitlesByName(String name);
    

    /**
     * This will return a title from the Database based on id.
     * This will allow for specific title to be pulled or for other methods to utilize if needed.
     * @param id
     * @return Title object based on ID.
     */
    public Title getTitleByID(int id);
    

    /**
     * This will add a title into the database.
     * This must be done by a User with admin status.
     * Method will be rejected if they are not.
     * @param title used to be added to database.
     * @param admin Used to confirm admin user is executing add method.
     * @return Confirmation if add was successful.
     */
    public boolean addTitle(Title title, User admin);
}
