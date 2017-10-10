/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Dtos.Borrowed;
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
        Borrowed customer = null;
        ArrayList<Borrowed> BorrowedList = new ArrayList();

        try {
            con = getConnection();
            String query = "SELECT * FROM borrowed WHERE borrowed = ?";
            ps = con.prepareStatement(query);

            ps.setString(1, name);
            rs = ps.executeQuery();

            while (rs.next()) {
                customer = new Customer();
                // Get the pieces of a customer from the resultset
                customer.setCustomerNumber(rs.getInt("customerNumber"));
                customer.setCreditLimit(rs.getDouble("creditLimit"));
                customer.setCustomerName(rs.getString("customerName"));
                customer.setPhone(rs.getString("phone"));
                customerList.add(customer);

            }

        } catch (SQLException e) {
            System.out.println("Exception occured in the selectCustomerByName() method");
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
                System.out.println("Exception occured in the finally section in the selectCustomerByName() method");
            }
        }

        return customerList;
    }

    @Override
    public ArrayList<Borrowed> getBorrowedByTitleID(int titleID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Borrowed> getBorrowedByStatus(int status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addBorrowed(Borrowed borrowed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
