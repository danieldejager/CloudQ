/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;
import disc.tiinfosec.utilities.InitialiseDataLayer;
import disc.tiinfosec.businessobjects.UserCredential;
import java.sql.*;

/**
 *
 * @author daniel112
 */
public class GetUserCredentials {
    
    public UserCredential GetSingleUserCredential(String p_username) {
        try {
            UserCredential uc = new UserCredential();
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement("select * from Users where username=?");
                ps.setString(1, p_username);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    uc.setUsername(rs.getString("username"));
                    uc.setLonghash(rs.getString("password"));
                    uc.setSalt(rs.getString("random"));
                    uc.setActivationStatus(rs.getString("status"));
                }
                
            }
            dl.CloseConnection(conn);
            return uc;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public boolean isEnabledAccount(String p_username) {
        try {
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            boolean result = false;
            if(conn != null) {
                PreparedStatement ps = conn.prepareStatement("select status from users where username = ?");
                ps.setString(1, p_username);
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    if (rs.getString("status").equals("active")) {
                        result = true;
                    }
                }
                
            }
            dl.CloseConnection(conn);
            return result;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());        
        }
            return false;
    }   
}
