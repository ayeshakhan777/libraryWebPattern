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

    public ArrayList<Title> getTitlesByUserID(int userID);

    public User getUserByOrderID(int userID);
}
