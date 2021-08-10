/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;

import disc.tiinfosec.utilities.InitialiseDataLayer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.activation.DataSource;
import disc.tiinfosec.businessobjects.UserCredential;

/**
 *
 * @author daniel112
 */
public class UpdatePassword {
    
    public void updatePassword(UserCredential p_uc) {
        try {
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
          if ( conn!= null) {
            PreparedStatement ps = conn.prepareStatement("update users set password = ?, random = ? where username = ?");
            ps.setString(1, p_uc.getLonghash());
            ps.setString(2, p_uc.getSalt());
            ps.setString(3,p_uc.getUsername());
            int i = ps.executeUpdate();
            
          } else {
              System.out.println("The connection is null");
          }
          dl.CloseConnection(conn);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
