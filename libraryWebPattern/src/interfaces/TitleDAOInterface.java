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
    
    public ArrayList<Title> getTitlesByDescription(String description);
    
    public ArrayList<Title> getTitlesByAuthor(String description);
    
    public ArrayList<Title> getTitlesByName(String name);
    
    public Title getTitleByID(int id);
    
    public boolean addTitle(Title title);
}