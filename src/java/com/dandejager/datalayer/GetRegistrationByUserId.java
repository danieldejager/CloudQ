/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;
import disc.tiinfosec.utilities.InitialiseDataLayer;
import java.sql.*;
import disc.tiinfosec.businessobjects.Registration;
import disc.tiinfosec.businessobjects.User;
/**
 *
 * @author DANIEL112
 */
public class GetRegistrationByUserId {
    
    public Registration GetRegbyUserId(String p_userid) {
     try {
         Registration toReturn = new Registration();
         User user = new User();
        InitialiseDataLayer dl = new InitialiseDataLayer();
        Connection conn = dl.getConnection();
        if ( conn != null ){
            PreparedStatement ps = conn.prepareStatement("select * from users where username = ?");
            ps.setString(1, p_userid);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            if  (rs.next() ){
                user.setRegistrationId(rs.getString("registrationid"));
                user.setUsername(rs.getString("username"));
                PreparedStatement ps2 = conn.prepareStatement("select * from registration where idregistration = ?");
                ps2.setString(1, user.getRegistrationId());
                System.out.println(ps2.toString());
                ResultSet rs2 = ps2.executeQuery();
                if ( rs2.next()) {
                    toReturn.setRegistrationID(rs2.getString("idregistration"));
                    toReturn.setAssignRegistration(rs2.getString("assignregistration"));
                    toReturn.setCompanyName(rs2.getString("companyname"));
                    toReturn.setActivationStatus(rs2.getString("activationstatus"));
                    toReturn.setEmail(rs2.getString("emailaddress"));
                    toReturn.setMobile(rs2.getString("Mobile"));
                    toReturn.setFirstName(rs2.getString("FirstName"));
                    toReturn.setLastName(rs2.getString("LastName"));
                }
            }
        }
       return toReturn;
     } catch (Exception ex) {
         System.out.println(ex.getMessage());
         return null;
     }
    }
}

