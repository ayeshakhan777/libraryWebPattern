/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Dtos.User;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import interfaces.UserDAOInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sami
 * @version 1.0
 * @since 14/10/17
 */
public class UserDAO extends DAO implements UserDAOInterface {

    /**
     * This will allow the user to call users by their first name and last name
     * Both variables must be exactly right, Case sensitive
     *
     * @param firstName
     * @param lastName
     * @return ArrayList with users from the db matching the first and last name
     * parameters
     */
    @Override
    public ArrayList<User> selectUserByUsername(String firstName, String lastName) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        ArrayList<User> userList = new ArrayList();

        try {
            conn = getConnection();

            String query = "SELECT * FROM users WHERE firstName = ? AND lastName = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, firstName);
            ps.setString(2, lastName);

            while (rs.next()) {
                u = new User();
                u.setUserID(rs.getInt("userID"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setFirstName(rs.getString("firstName"));
                u.setLastName(rs.getString("lastName"));
                u.setCountry(rs.getString("country"));
                u.setAddressLine1(rs.getString("addressLine1"));
                u.setAddressLine2(rs.getString("addressLine2"));
                u.setUserID(rs.getInt("userID"));
                u.setIsAdmin(rs.getInt("isAdmin"));
                userList.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the selectUserByUsername() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    closeConnection(conn);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the selectUserByUsername() method: " + e.getMessage());
            }
        }
        return userList;
    }

    /**
     * This will allow the user to call users by their name. This will check
     * first and last name, if the substring is inside. Case sensitive.
     *
     * @param name
     * @return ArrayList with users from the database with a name containing the
     * name parameter
     */
    public ArrayList<User> selectUserContainingName(String name) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        ArrayList<User> userList = new ArrayList();

        try {
            conn = getConnection();

            String query = "SELECT * FROM user WHERE firstName LIKE ? OR lastName LIKE ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + name + "%");
            ps.setString(2, "%" + name + "%");

            while (rs.next()) {
                u = new User();
                u.setUserID(rs.getInt("userID"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setFirstName(rs.getString("firstName"));
                u.setLastName(rs.getString("lastName"));
                u.setCountry(rs.getString("country"));
                u.setAddressLine1(rs.getString("addressLine1"));
                u.setAddressLine2(rs.getString("addressLine2"));
                u.setUserID(rs.getInt("userID"));
                u.setIsAdmin(rs.getInt("isAdmin"));
                userList.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the selectUserContainingName() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    closeConnection(conn);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the selectUserByUsername() method: " + e.getMessage());
            }
        }
        return userList;
    }

    /**
     * This will check the database for a user with userID of the param and
     * return the user
     *
     * @param userID
     * @return User
     */
    public User findUserByID(int userID) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;

        try {
            conn = getConnection();

            String query = "SELECT * FROM user WHERE userID = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, userID);
            rs = ps.executeQuery();

            if (rs.next()) {
                u = new User(rs.getInt("userID"), rs.getString("email"), rs.getString("password"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("country"), rs.getString("addressLine1"), rs.getString("addressLine2"), rs.getInt("isAdmin"));
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the findUserByID() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    closeConnection(conn);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the findUserByID() method: " + e.getMessage());
            }
        }
        return u;
    }

    /**
     *This method will take input from the console and create a user object. The user must 
     * be an admin to use this method.
     * @param user
     * @param admin
     * @return boolean indicating if the add was executed or not.
     */
    public boolean addUser(User user, User admin) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rs = 0;
        User u = null;
        Boolean result = null;

        try {
            conn = getConnection();
            String query = "INSERT INTO users VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, NULL)";
            ps = conn.prepareStatement(query);
            ps.setString(1, u.getEmail());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getFirstName());
            ps.setString(4, u.getLastName());
            ps.setString(5, u.getCountry());
            ps.setString(6, u.getAddressLine1());
            ps.setString(7, u.getAddressLine2());
            ps.setInt(8, u.getIsAdmin());

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
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    closeConnection(conn);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section in the addUser() method");
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
