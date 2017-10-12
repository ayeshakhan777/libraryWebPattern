/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Dtos.User;
import java.util.ArrayList;

/**
 *
 * @author Sean
 */
public interface UserDAOInterface {
    //This will allow the user to call users by their first name and last name
    //Both variables must be exactly right, Case sensitive
    public ArrayList<User> selectUserByUsername(String firstName, String lastName);

    //This will allow the user to call users by their name
    //This will check first and last name, if the substring is inside.
    //Case sensitive.
    public ArrayList<User> selectUserContainingName(String name);

    //This will call a user by their ID
    public User findUserByID(int userID);

    //This will add a user into the system
    //Admin user is imported to check if they are a admin before adding user
    //Method rejected if admin object isn't admin.
    public boolean addUser(User user, User admin);
}
