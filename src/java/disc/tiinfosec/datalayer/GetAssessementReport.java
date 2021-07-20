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
 * @author DANIEL112
 */
public class GetAssessementReport {
    
    public AssessmentReport GetAssessmentReportbyCloudAssessmentId(String p_cloudassessmentid) {
    try {
         AssessmentReport p = new AssessmentReport();
        InitialiseDataLayer dl = new InitialiseDataLayer();
        Connection conn = dl.getConnection();
        if(conn!= null) {
            PreparedStatement ps = conn.prepareStatement("select * from assessmentreport where cloudassessmentid = ? ");
            ps.setString(1, p_cloudassessmentid);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                p.setCloudAssessmentId(rs.getString("cloudassessmentid"));
                p.setExecutiveSummary(rs.getString("executivesummary"));
                p.setRequiresCIOReview(rs.getString("requirescioreview"));
            }
            dl.CloseConnection(conn);
            return p;
        }
                
        
    }  catch (Exception ex) {
        System.out.println(ex.getMessage());
        return null;
    } 
    return null;
    }
    
}
