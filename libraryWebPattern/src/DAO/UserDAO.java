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
 * @author Sean
 */
public class UserDAO extends DAO implements UserDAOInterface {

    @Override
    public ArrayList<User> selectUserByUsername(String firstName, String lastName) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        ArrayList<User> userList = new ArrayList();

        try {
            con = getConnection();
            String query = "SELECT * FROM users WHERE firstName = ? AND lastName = ?";
            ps = con.prepareStatement(query);

            ps.setString(1, firstName);
            ps.setString(2, lastName);
            rs = ps.executeQuery();

            while (rs.next()) {
                user = new User();
                // Get the pieces of a customer from the resultset
                user.setUserID(rs.getInt("userID"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setCountry(rs.getString("country"));
                user.setAddressLine1(rs.getString("addressLine1"));
                user.setAddressLine2(rs.getString("addressLine2"));
                user.setIsAdmin(rs.getInt("isAdmin"));
                userList.add(user);

            }

        } catch (SQLException e) {
            System.out.println("Exception occured in the selectUserByUsername() method");
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
                System.out.println("Exception occured in the finally section in the selectUserByUsername() method");
            }
        }

        return userList;
    }

    @Override
    public ArrayList<User> selectUserContainingName(String name) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        ArrayList<User> userList = new ArrayList();

        try {
            con = getConnection();
            String query = "SELECT * FROM users WHERE firstName LIKE ? OR lastName LIKE ?";
            ps = con.prepareStatement(query);

            ps.setString(1, "%" + name + "%");
            ps.setString(2, "%" + name + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                user = new User();
                // Get the pieces of a customer from the resultset
                user.setUserID(rs.getInt("userID"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setCountry(rs.getString("country"));
                user.setAddressLine1(rs.getString("addressLine1"));
                user.setAddressLine2(rs.getString("addressLine2"));
                user.setIsAdmin(rs.getInt("isAdmin"));
                userList.add(user);

            }

        } catch (SQLException e) {
            System.out.println("Exception occured in the selectUserContainingName() method");
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
                System.out.println("Exception occured in the finally section in the selectUserContainingName() method");
            }
        }

        return userList;
    }

    @Override
    public User findUserByID(int userID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try {
            con = getConnection();
            String query = "SELECT * FROM users WHERE userID = ?";
            ps = con.prepareStatement(query);

            ps.setInt(1, userID);
            rs = ps.executeQuery();

            while (rs.next()) {
                user = new User();
                // Get the pieces of a customer from the resultset
                user.setUserID(rs.getInt("userID"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setCountry(rs.getString("country"));
                user.setAddressLine1(rs.getString("addressLine1"));
                user.setAddressLine2(rs.getString("addressLine2"));
                user.setIsAdmin(rs.getInt("isAdmin"));
            }

        } catch (SQLException e) {
            System.out.println("Exception occured in the findUserByID() method");
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
                System.out.println("Exception occured in the finally section in the findUserByID() method");
            }
        }

        return user;
    }

    @Override
    public boolean addUser(User user) {
        Connection con = null;
        PreparedStatement ps = null;
        int rs = 0;
        User userTemp = null;
        Boolean result = null;

        try {
            con = getConnection();
            String query = "INSERT INTO users VALUES(NULL,?,?,?,?,?,?,?,?,NULL)";
            ps = con.prepareStatement(query);
            String email = user.getEmail();
            String password = user.getPassword();
            String firstName = user.getFirstName();
            String lastName = user.getLastName();
            String country = user.getCountry();
            String addressLine1 = user.getAddressLine1();
            String addressLine2 = user.getAddressLine2();
            int isAdmin = user.getIsAdmin();

            // Fill in the blanks, i.e. parameterize the query
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, firstName);
            ps.setString(4, lastName);
            ps.setString(5, country);
            ps.setString(6, addressLine1);
            ps.setString(7, addressLine2);
            ps.setInt(8, isAdmin);

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
