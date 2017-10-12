/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Dtos.Borrowed;
import Dtos.User;
import java.util.ArrayList;

/**
 *
 * @author Sean
 */
public interface BorrowedDAOInterface {
    //This will return a borrowed ArrayList by their userID
    //User must be logged in to do this.
    //Method will be rejected if they are not.
    public ArrayList<Borrowed> getBorrowedByUserID(int userID);
    
    //This will return a borrowed ArrayList by their titleID
    //User must be logged in to do this.
    //Methos will be rejected if they are not.
    public ArrayList<Borrowed> getBorrowedByTitleID(int titleID);

    //This will return a borrowed ArrayList by their titleID
    //Status 1 means it is returned
    //Status 0 means it isnt returned.
    //User must be logged in to do this.
    //Method will be rejected if they are not. 
    public ArrayList<Borrowed> getBorrowedByStatus(int status);

    //This will add a borrowed object into the database.
    //Admin user is imported to check if they are a admin before adding borrowed object.
    //Method rejected if admin object isn't admin.
    public boolean addBorrowed(Borrowed borrowed, User Admin);
}
