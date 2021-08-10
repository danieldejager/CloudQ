/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;
import disc.tiinfosec.utilities.InitialiseDataLayer;
import disc.tiinfosec.businessobjects.*;
import java.util.*;
import java.sql.*;
/**
 *
 * @author daniel112
 */
public class GetUser {
private  Connection conn;


    public GetUser(){};

    public  User getUser(String p_usr) {
        try {
            InitialiseDataLayer dl = new InitialiseDataLayer();
            conn = dl.getConnection();
            if (conn != null && !conn.getCatalog().equals("")) {
                PreparedStatement ps = conn.prepareStatement("select * from users where username = ?");
                ps.setString(1, p_usr);
                System.out.println(ps.toString());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    User user = new User();
                    user.setUsername(rs.getString("username"));
                    user.setRole(rs.getString("role"));
                    dl.CloseConnection(conn);
                    return user;
                } else {
                    dl.CloseConnection(conn);
                    return null;
                }
            } else {
                System.out.println("connection is null and catalog is incorrect");
                dl.CloseConnection(conn);
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

}
