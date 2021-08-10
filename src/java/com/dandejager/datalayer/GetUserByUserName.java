/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;
import java.sql.*;
import disc.tiinfosec.businessobjects.User;
import disc.tiinfosec.utilities.InitialiseDataLayer;

/**
 *
 * @author DANIEL112
 */
public class GetUserByUserName {
    
    public User getUser(String p_userName) {
        try {
            User u = new User();
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if(conn!= null) {
                PreparedStatement ps = conn.prepareStatement("select * from users where username = ? ");
                ps.setString(1, p_userName);
                System.out.println(ps.toString());
               
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    System.out.println("Ok I did get an object back from mysql");
                    u.setUsername(rs.getString("username"));
                    u.setRegistrationId(rs.getString("registrationid"));
                    u.setRole(rs.getString("role"));
                    u.setStatus(rs.getString("status"));
                }
                if (u!= null) {
                    System.out.println("Ok the object is not null");
                    return u;
                } else {
                    System.out.println("The object is null");
                    return new User();
                }
                
            }
        } catch (Exception ex) {
            System.out.println("This is throwing some kind of exception");
            System.out.println(ex.getMessage());
            return new User();
        }
        return new User();
    }
    
}
