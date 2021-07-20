/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;
import disc.tiinfosec.utilities.InitialiseDataLayer;
import java.sql.*;
import java.util.*;
import disc.tiinfosec.businessobjects.Registration;
/**
 *
 * @author daniel112
 */
public class GetAllRegistrations {

    public GetAllRegistrations(){};

    public  List<Registration> GetAllRegistrations() {
    try {
        Registration registration;
        ArrayList<Registration> registrationlist = new ArrayList<Registration>();
        InitialiseDataLayer dl = new InitialiseDataLayer();
        Connection connection = dl.getConnection();
        if ( connection != null && !connection.getCatalog().equals("")) {
            PreparedStatement ps = connection.prepareStatement("select * from registration where registrationstatus = 'Pending'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                registration = new Registration();
                registration.setRegistrationID(rs.getString("idregistration"));
                registration.setCompanyName(rs.getString("companyname"));
                registration.setEmail(rs.getString("emailaddress"));
                registration.setFirstName(rs.getString("firstname"));
                registration.setLastName(rs.getString("lastname"));
                registration.setMobile(rs.getString("mobile"));
                registration.setRegistrationstatus(rs.getString("registrationstatus"));
                registration.setAssignRegistration(rs.getString("assignregistration"));
                registrationlist.add(registration);
            }
            dl.CloseConnection(connection);
        }
        return registrationlist;
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
        return null;
    }
    }
}
