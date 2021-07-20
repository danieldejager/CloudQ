/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;
import java.sql.*;
import disc.tiinfosec.businessobjects.AssessmentReport;
import disc.tiinfosec.utilities.InitialiseDataLayer;
/**
 *
 * @author daniel112
 */
public class InsertAssessmentReport {
    
    public void InsertNewAssessmentReport(AssessmentReport p_report) {
        try {
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if(conn!=null) {
                PreparedStatement ps = conn.prepareStatement("insert into assessmentreport (executiveSummary, cloudassessmentid, requirescioreview) values (?,?,?)");
                ps.setString(1, p_report.getExecutiveSummary());
                ps.setString(2, p_report.getCloudAssessmentId());
                ps.setString(3, p_report.getRequiresCIOReview());
                System.out.println(ps.toString());
                int j = ps.executeUpdate();
            }
            dl.CloseConnection(conn);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
