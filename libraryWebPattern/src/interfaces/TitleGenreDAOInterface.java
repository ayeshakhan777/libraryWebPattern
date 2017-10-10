/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Dtos.Genre;
import java.util.ArrayList;

/**
 *
 * @author Sean
 */
public interface TitleGenreDAOInterface {

    public ArrayList<Genre> getGenreByTitleID(int titleID);
}
