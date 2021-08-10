/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;

import disc.tiinfosec.utilities.InitialiseDataLayer;
import disc.tiinfosec.businessobjects.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author daniel112
 */
public class GetUserBytOken {
    public User getUserStatusByToken(String p_token) {
        User u = new User();
        try {
            
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection con = dl.getConnection();
            if ( con != null ) {
                PreparedStatement ps = con.prepareStatement("select * from registration where token = ?");
                ps.setString(1, p_token);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String id  = rs.getString("idregistration");
                    ps = con.prepareStatement("select * from users where registrationid = ?");
                    ps.setString(1, id);
                    ResultSet rx = ps.executeQuery();
                    if (rx.next()) {
                        //what is the activationcode
                        u.setStatus(rx.getString("status"));
                    }
                }
            }
            dl.CloseConnection(con);
            return u;
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return u;
    }
}
