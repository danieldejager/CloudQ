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
public class UpdateRegistrationStatus {
    public void UpdateRegStatus(Registration p_registration) {
    try {
        InitialiseDataLayer dl = new InitialiseDataLayer();
        Connection conn = dl.getConnection();
        if ( conn != null ) {
            PreparedStatement ps = conn.prepareStatement("update registration set registrationstatus = ? , assignregistration = ? where idregistration = ?");
            ps.setString(1, p_registration.getRegistrationstatus());
            ps.setString(2, p_registration.getAssignRegistration());
            ps.setString(3, p_registration.getRegistrationID());
            System.out.println(ps.toString());
            int i = ps.executeUpdate();
        }
            dl.CloseConnection(conn);
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
    }
    }
    
    public void activateRegistration(String p_registrationCode) {
        try {
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if ( conn != null ) {
                PreparedStatement ps = conn.prepareStatement("update registration set activationstatus = 'Enabled' where token = ?");
                ps.setString(1, p_registrationCode);
                int j = ps.executeUpdate();
                dl.CloseConnection(conn);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
