package DAO;

import Dtos.Title;
import Dtos.User;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import interfaces.TitleDAOInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ayesha
 */
public class TitleDAO extends DAO implements TitleDAOInterface {

    public TitleDAO(String databaseName) {
        super(databaseName);
    }

    @Override
    public ArrayList<Title> viewAllTitles() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Title> titles = new ArrayList();

        try {
            con = getConnection();

            String query = "SELECT * from titles";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {

                Title c = new Title(rs.getInt("titleID"), rs.getString("novelName"), rs.getString("author"), rs.getInt("stock"), rs.getInt("onLoan"), rs.getString("titleDecription"));
                titles.add(c);
            }

        } catch (SQLException e) {
            System.out.println("Exception occured in the viewAllTitles() method");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section in the viewAllTitles() method");
            }
        }

        return titles;
    }

    public boolean addTitle(int titleID, String novelName, int stock, String titleDescription, int definedLoan) {
        Connection con = null;
        PreparedStatement ps = null;
        //This if statement will make check if the user is admin which is 1.
        try {
            con = getConnetion();
            String query = "INSERT INTO titles (titleID, novelName, stock, titleDescription, definedLoan) VALUES (?, ? , ?, ?, ? )";
            ps = con.prepareStatement(query);
            ps.setInt(1, titleID);
            ps.setString(2, novelName);
            ps.setInt(3, stock);
            ps.setString(4, titleDescription);
            ps.setInt(5, definedLoan);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception occured in the addTitle() method: " + e.getMessage());
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the addTitle() method: " + e.getMessage());
                return false;
            }
        }
        return true;
    }

    public int deleteTitleById(int titleID) {
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;
        try {
            con = getConnection();
            String query = "DELETE FROM titles WHERE titleID = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, titleID);
            rowsAffected = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception occured in the deleteTitleById() method: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the deleteTitleById() method");
                e.getMessage();
            }
        }
        return rowsAffected;
    }

    public int updateTitleDetails(int titleID, String newGenre, String newNovelName, String author, String newDescripition) {

        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;

        try {
            con = getConnection();
            String query = "UPDATE titles SET titleID = ?, genre = ?, novelName = ? , author = ? , titleDescription = ?  WHERE titleID = ?";

            ps = con.prepareStatement(query);
            ps.setInt(1, titleID);
            ps.setString(2, newGenre);
            ps.setString(3, newNovelName);
            ps.setString(4, author);
            ps.setString(5, newDescripition);
            rowsAffected = ps.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println("Exception occured in the updateTitleDetails() method: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the updateTitleDetails() method");
                e.getMessage();
            }
        }

        return rowsAffected;
    }

    public Title searchByAuthor(String author) {

        {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            Title t = null;
            try {
                con = getConnection();

                String query = "Select * from titles where author = ?";
                ps = con.prepareStatement(query);
                ps.setString(1, author);
                rs = ps.executeQuery();
                if (rs.next()) {
                    t = new Title(rs.getInt("titleID"), rs.getString("novelName"), rs.getString("author"), rs.getInt("stock"), rs.getInt("onLoan"), rs.getString("titleDecription"));
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the searchByAuthor() method: " + e.getMessage());
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (ps != null) {
                        ps.close();
                    }
                    if (con != null) {
                        freeConnection(con);
                    }
                } catch (SQLException e) {
                    System.out.println("Exception occured in the finally section of the searchByAuthor() method: " + e.getMessage());
                }
            }
            return t;
        }
    }

    public Title searchByNovelName(String novelName) {
        {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            Title t = null;
            try {
                con = getConnection();

                String query = "Select * from titles where novelName = ?";
                ps = con.prepareStatement(query);
                ps.setString(1, novelName);
                rs = ps.executeQuery();
                if (rs.next()) {
                    t = new Title(rs.getInt("titleID"), rs.getString("novelName"), rs.getString("author"), rs.getInt("stock"), rs.getInt("onLoan"), rs.getString("titleDecription"));
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the searchByNovelName() method: " + e.getMessage());
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (ps != null) {
                        ps.close();
                    }
                    if (con != null) {
                        freeConnection(con);
                    }
                } catch (SQLException e) {
                    System.out.println("Exception occured in the finally section of the searchByNovelName() method: " + e.getMessage());
                }
            }
            return t;
        }

    }

    public Title searchByGenre(int genre) {
        {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            Title t = null;
            try {
                con = getConnection();

                String query = "Select * from titlegenre where genreID = ?";
                ps = con.prepareStatement(query);
                ps.setInt(1, genre);
                rs = ps.executeQuery();
                if (rs.next()) {
                    t = new Title(rs.getInt("titleID"), rs.getString("novelName"), rs.getString("author"), rs.getInt("stock"), rs.getInt("onLoan"), rs.getString("titleDecription"));
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the searchByGenre() method: " + e.getMessage());
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (ps != null) {
                        ps.close();
                    }
                    if (con != null) {
                        freeConnection(con);
                    }
                } catch (SQLException e) {
                    System.out.println("Exception occured in the finally section of the searchByGenre() method: " + e.getMessage());
                }
            }
            return t;
        }

    }
}
