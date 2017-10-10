/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Dtos.Borrowed;
import java.util.ArrayList;

/**
 *
 * @author Sean
 */
public interface BorrowedDAOInterface {

    public ArrayList<Borrowed> getBorrowedByUserID(int userID);

    public ArrayList<Borrowed> getBorrowedByTitleID(int titleID);

    public ArrayList<Borrowed> getBorrowedByStatus(int status);

    public boolean addBorrowed(Borrowed borrowed);
}
