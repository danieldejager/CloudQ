/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;
import disc.tiinfosec.utilities.InitialiseDataLayer;
import java.sql.*;
import disc.tiinfosec.businessobjects.Finding;
/**
 *
 * @author DANIEL112
 */
public class InsertUpdateFinding {
    
    public void insertNewFinding(Finding p_finding) {
        try {
                InitialiseDataLayer dl = new InitialiseDataLayer();
                Connection conn = dl.getConnection();
                if (conn!= null) {
                    PreparedStatement ps = conn.prepareStatement("insert into findings (cloudassessmentid, registrationid, severity, category, findingtext) values (?,?,?,?,?)");
                    ps.setString(1,String.valueOf(p_finding.getCloudAssessmentId()));
                    ps.setString(2, p_finding.getRegistrationid());
                    ps.setString(3, p_finding.getSeverity());
                    ps.setString(4, p_finding.getCategory());
                    ps.setString(5, p_finding.getFindingText());
                    System.out.println(ps.toString());
                    int j = ps.executeUpdate();
                }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
