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
 * @author DANIEL112
 */
public class GetRegistrationToken {
    
    public String ReturnRegistrationToken(String p_token) {
        String realtoken="invalid";
        try {
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            
            if ( conn!= null) {
                PreparedStatement ps = conn.prepareStatement("select * from registration where token = ?");
                ps.setString(1, p_token);
                System.out.println(ps.toString());
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    realtoken = rs.getString("token");
                } 
            }
            dl.CloseConnection(conn);
            return realtoken;
        } catch (Exception ex) {
               System.out.println(ex.getMessage());
               return "invalid";
        }
    }
}
