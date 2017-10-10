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

    public ArrayList<User> selectUserByUsername(String firstName, String lastName);

    public ArrayList<User> selectUserContainingName(String name);

    public User findUserByID(int userID);

    public boolean addUser(User user);
}
