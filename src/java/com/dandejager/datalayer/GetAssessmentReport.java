/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;
import java.sql.*;
import java.util.*;
import disc.tiinfosec.businessobjects.AssessmentReport;
import disc.tiinfosec.utilities.InitialiseDataLayer;

/**
 *
 * @author daniel112
 */
public class GetAssessmentReport {
    
    public AssessmentReport getAssessmentReportByCloudAsssessmentId(String p_cloudAssessmentid) {
        try {
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            AssessmentReport report = new AssessmentReport();
            if(conn!=null) {
                PreparedStatement ps = conn.prepareStatement("select * from assessmentreport where cloudassessmentid = ?");
                ps.setString(1, p_cloudAssessmentid);
                System.out.println(ps.toString());
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    report.setCloudAssessmentId(rs.getString("cloudassessmentid"));
                    report.setExecutiveSummary(rs.getString("executiveSummary"));
                    report.setRequiresCIOReview(rs.getString("requirescioreview"));
                }
                dl.CloseConnection(conn);
                return report;
            }
                    
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
