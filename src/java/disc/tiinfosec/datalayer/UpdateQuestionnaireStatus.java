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
public class UpdateQuestionnaireStatus {
    
    public void updateQStatus(String p_newStatus, String p_registrationid, String p_user) {
        try {
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if ( conn!=null) {
                PreparedStatement ps = conn.prepareStatement("update cloudassessment set nextStep = ? where registrationid = ? and username = ?");
                ps.setString(1, p_newStatus);
                ps.setString(2, p_registrationid);
                ps.setString(3, p_user);
                int j = ps.executeUpdate();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
