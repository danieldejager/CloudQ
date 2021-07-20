/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;
import disc.tiinfosec.utilities.InitialiseDataLayer;
import java.sql.*;
import disc.tiinfosec.businessobjects.*;

/**
 *
 * @author daniel112
 */
public class InsertNewRegistration {

    public  void addNewRegistration(Registration p_registration) {
        try {
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if (conn != null & !conn.getCatalog().equals("")) {
                PreparedStatement ps = conn.prepareStatement("insert into registration (firstname, lastname,emailaddress,companyname,mobile,registrationstatus,token, activationstatus) values (?,?,?,?,?,?,?,?)");
                ps.setString(1, p_registration.getFirstName());
                ps.setString(2, p_registration.getLastName());
                ps.setString(3, p_registration.getEmail());
                ps.setString(4, p_registration.getCompanyName());
                ps.setString(5, p_registration.getMobile());
                ps.setString(6, "Pending");
                ps.setString(7, p_registration.getToken());
                ps.setString(8, p_registration.getActivationStatus());
                int i = ps.executeUpdate();
                
            } else {
                System.out.println("Connection is either null or catalog is not defined");
            }
                 dl.CloseConnection(conn);
        } catch (Exception ex ) {
            System.out.println(ex.getMessage());
        }
    }

}
