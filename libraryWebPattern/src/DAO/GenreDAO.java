/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Dtos.Genre;
import interfaces.GenreDAOInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Seanoh
 */
public class GenreDAO extends DAO implements GenreDAOInterface {

    @Override
    public Genre getGenreByID(int genreID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Genre genre = new Genre();
        ArrayList<Genre> Genre = new ArrayList();

        try {
            con = getConnection();
            String query = "SELECT * FROM genre WHERE genreID = ?";
            ps = con.prepareStatement(query);

            ps.setInt(1, genreID);
            rs = ps.executeQuery();

            while (rs.next()) {
                genre.setGenreID(rs.getInt("genreID"));
                genre.setGenre(rs.getString("genre"));

            }

        } catch (SQLException e) {
            System.out.println("Exception occured in the GenreDAO() method");
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
                System.out.println("Exception occured in the finally section in the GenreDAO() method");
            }
        }

        return genre;
    }
    
}
