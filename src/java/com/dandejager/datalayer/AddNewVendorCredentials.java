/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;
import disc.tiinfosec.utilities.InitialiseDataLayer;
import disc.tiinfosec.businessobjects.User;
import disc.tiinfosec.businessobjects.UserCredential;
import disc.tiinfosec.security.Crypto;
import java.sql.*;
/**
 *
 * @author daniel112
 */
public class AddNewVendorCredentials {
    
    public void addUser(User p_usr) {
    try { 
        // get ready
         
        
        InitialiseDataLayer dl = new InitialiseDataLayer();
        Connection conn = dl.getConnection();
        if ( conn != null ) {
            PreparedStatement ps = conn.prepareStatement("insert into users (username, password, role, registrationid, random, status) values (?,?,?,?,?,?)");
            UserCredential cred = new UserCredential();
            byte[] salt = Crypto.getSalt();
            cred = Crypto.generateStrongPasswordHash(p_usr.getPassword(), salt);
            
            p_usr.setRandom(cred.getSalt());
            p_usr.setPassword(cred.getLonghash());
            
            ps.setString(1,p_usr.getUsername());
            ps.setString(2,p_usr.getPassword());
            ps.setString(3, p_usr.getRole());
            ps.setString(4, p_usr.getRegistrationId());
            ps.setString(5,p_usr.getRandom());
            ps.setString(6,p_usr.getStatus());
            System.out.println(ps.toString());
            int j = ps.executeUpdate();
        }
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
    }
    }
    
}
