/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;

import disc.tiinfosec.businessobjects.User;
import disc.tiinfosec.utilities.InitialiseDataLayer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author daniel112
 */
public class GetAllUsers {
    
    public ArrayList<User> GetAllUsers() {
        try {
            ArrayList<User> list = new ArrayList<User>();
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if(conn != null ) {
                PreparedStatement ps = conn.prepareStatement("select * from users");
                ResultSet rs = ps.executeQuery();
                System.out.println(ps.toString());
                while (rs.next()) {
                    User u = new User();
                    u.setIdUser(rs.getString("idUsers"));
                    u.setUsername(rs.getString("username"));
                    u.setRole(rs.getString("role"));
                    u.setRegistrationId(rs.getString("registrationid"));
                    u.setStatus(rs.getString("status"));
                    list.add(u);
                }
                dl.CloseConnection(conn);
                return list;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return null;
    }
    
}
