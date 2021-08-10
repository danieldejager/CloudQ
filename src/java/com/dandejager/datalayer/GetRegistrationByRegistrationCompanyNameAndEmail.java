/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;
import disc.tiinfosec.utilities.InitialiseDataLayer;
import java.sql.*;
import disc.tiinfosec.businessobjects.Registration;
/**
 *
 * @author daniel112
 */
public class GetRegistrationByRegistrationCompanyNameAndEmail {
    
    public Registration getRegistration(Registration p_registration) {
        try {
            Registration new_registration = new Registration();
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if ( conn != null ) {
                PreparedStatement ps = conn.prepareStatement("select * from registration where emailaddress = ? and firstname = ? and activationstatus = 'disabled'");
                ps.setString(1, p_registration.getEmail());
                ps.setString(2, p_registration.getFirstName());
                System.out.println(ps.toString());
                ResultSet rs = ps.executeQuery();
                if ( rs.next() ) {
                    new_registration.setToken(rs.getString("token"));
                    new_registration.setEmail(rs.getString("EmailAddress"));
                    new_registration.setFirstName(rs.getString("FirstName"));
                    new_registration.setLastName(rs.getString("LastName"));
                    new_registration.setRegistrationId(rs.getString("idregistration"));
                    dl.CloseConnection(conn);
                }
                
                return new_registration;
            }
        } catch (Exception ex ){
            System.out.println(ex.getMessage());
            return null;
        }
          return new Registration();
    }
}
