/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Dtos.TitleGenre;
import java.util.ArrayList;

/**
 *
 * @author Sean
 */
public interface TitleGenreDAOInterface {
    //This will return a list of TitleGenre objects by the titleID.
    //TitleGenre objects store Title and Genre objects.
    public ArrayList<TitleGenre> getGenreByTitleID(int titleID);
}
