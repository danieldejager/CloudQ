/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;
import disc.tiinfosec.utilities.InitialiseDataLayer;
import java.sql.*;

/**
 *
 * @author daniel112
 */
public class InsertUpdateUser {

    public void activateUserAccount(String p_usr) {
        try {
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if ( conn!= null) {
                PreparedStatement ps = conn.prepareStatement("update users set status = 'active' where username = ?");
                ps.setString(1, p_usr);
                int j = ps.executeUpdate();
                dl.CloseConnection(conn);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void disableUser(String p_registrationid) {
        try {
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            PreparedStatement ps = conn.prepareStatement("update users set status = 'inactive' where registrationid = ?");
            ps.setString(1, p_registrationid);
            System.out.println(ps.toString());
            int j = ps.executeUpdate();
            dl.CloseConnection(conn);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
