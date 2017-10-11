/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Dtos.Borrowed;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import interfaces.BorrowedDAOInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sean
 */
public class BorrowedDAO extends DAO implements BorrowedDAOInterface {

    @Override
    public ArrayList<Borrowed> getBorrowedByUserID(int userID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Borrowed borrowed = null;
        UserDAO userdao = new UserDAO();
        TitleDAO titledao = new TitleDAO();
        ArrayList<Borrowed> borrowedList = new ArrayList();

        try {
            con = getConnection();
            String query = "SELECT * FROM borrowed WHERE userID = ?";
            ps = con.prepareStatement(query);

            ps.setInt(1, userID);
            rs = ps.executeQuery();

            while (rs.next()) {
                borrowed = new Borrowed();
                // Get the pieces of a customer from the resultset
                borrowed.setUser(userdao.findUserByID(rs.getInt("userID")));
                borrowed.setTitle(titledao.getTitleByID(rs.getInt("titleID")));
                borrowed.setDaysBorrowed(rs.getInt("daysBorrowed"));
                borrowed.setStatus(rs.getInt("status"));
                borrowedList.add(borrowed);

            }

        } catch (SQLException e) {
            System.out.println("Exception occured in the getBorrowedByUserID() method");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    closeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section in the getBorrowedByUserID() method");
            }
        }

        return borrowedList;
    }

    @Override
    public ArrayList<Borrowed> getBorrowedByTitleID(int titleID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Borrowed borrowed = null;
        UserDAO userdao = new UserDAO();
        TitleDAO titledao = new TitleDAO();
        ArrayList<Borrowed> borrowedList = new ArrayList();

        try {
            con = getConnection();
            String query = "SELECT * FROM borrowed WHERE titleID = ?";
            ps = con.prepareStatement(query);

            ps.setInt(1, titleID);
            rs = ps.executeQuery();

            while (rs.next()) {
                borrowed = new Borrowed();
                // Get the pieces of a customer from the resultset
                borrowed.setUser(userdao.findUserByID(rs.getInt("userID")));
                borrowed.setTitle(titledao.getTitleByID(rs.getInt("titleID")));
                borrowed.setDaysBorrowed(rs.getInt("daysBorrowed"));
                borrowed.setStatus(rs.getInt("status"));
                borrowedList.add(borrowed);

            }

        } catch (SQLException e) {
            System.out.println("Exception occured in the getBorrowedByTitleID() method");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    closeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section in the getBorrowedByTitleID() method");
            }
        }

        return borrowedList;
    }

    @Override
    public ArrayList<Borrowed> getBorrowedByStatus(int status) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Borrowed borrowed = null;
        UserDAO userdao = new UserDAO();
        TitleDAO titledao = new TitleDAO();
        ArrayList<Borrowed> borrowedList = new ArrayList();

        try {
            con = getConnection();
            String query = "SELECT * FROM borrowed WHERE status = ?";
            ps = con.prepareStatement(query);

            ps.setInt(1, status);
            rs = ps.executeQuery();

            while (rs.next()) {
                borrowed = new Borrowed();
                // Get the pieces of a customer from the resultset
                borrowed.setUser(userdao.findUserByID(rs.getInt("userID")));
                borrowed.setTitle(titledao.getTitleByID(rs.getInt("titleID")));
                borrowed.setDaysBorrowed(rs.getInt("daysBorrowed"));
                borrowed.setStatus(rs.getInt("status"));
                borrowedList.add(borrowed);

            }

        } catch (SQLException e) {
            System.out.println("Exception occured in the getBorrowedByStatus() method");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    closeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section in the getBorrowedByStatus() method");
            }
        }

        return borrowedList;    }

    @Override
    public boolean addBorrowed(Borrowed borrowed) {
        Connection con = null;
        PreparedStatement ps = null;
        int rs = 0;
        Borrowed tempBorrowed = null;
        Boolean result = null;

        try {
            con = getConnection();
            String query = "INSERT INTO borrowed VALUES(NULL,?,?,?,?)";
            ps = con.prepareStatement(query);
            int userID = borrowed.getUser().getUserID();
            int titleID = borrowed.getTitle().getTitleID();
            int daysBorrowed = borrowed.getDaysBorrowed();
            int status = borrowed.getStatus();


            // Execute the query
            rs = ps.executeUpdate();

        } catch (MySQLIntegrityConstraintViolationException e) {
            System.out.println("Constraint Exception occurred: " + e.getMessage());
            // Set the rowsAffected to -1, this can be used as a flag for the display section
            rs = -1;

        } catch (SQLException se) {
            System.out.println("SQL Exception occurred: " + se.getMessage());
            se.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
        } // Now that the program has completed its database access component, 
        // close the open access points (resultset, preparedstatement, connection)
        // Remember to close them in the OPPOSITE ORDER to how they were opened
        // Opening order: Connection -> PreparedStatement -> ResultSet
        // Closing order: ResultSet -> PreparedStatement -> Connection
        finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    closeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section in the addBorrowed() method");
            }
        }

        if (rs > 0) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }
    
}
