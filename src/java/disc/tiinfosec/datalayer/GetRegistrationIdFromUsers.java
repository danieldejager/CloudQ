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
public class GetRegistrationIdFromUsers {
    public String GetRegId(String p_username) {
        try {
            String toReturnId = "";
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if ( conn != null ) {
                PreparedStatement ps = conn.prepareStatement("select * from users where username = ? ");
                ps.setString(1, p_username);
                System.out.println(ps.toString());
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    toReturnId = rs.getString("registrationid");
                    System.out.println(toReturnId);
                }
            }
            dl.CloseConnection(conn);
            return toReturnId;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "";
        }
        
    }
}
