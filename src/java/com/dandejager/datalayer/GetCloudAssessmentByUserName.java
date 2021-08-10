/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;
import disc.tiinfosec.utilities.InitialiseDataLayer;
import java.sql.*;
import disc.tiinfosec.businessobjects.CloudAssessment;

/**
 *
 * @author daniel112
 */
public class GetCloudAssessmentByUserName {
    
    public CloudAssessment GetAsessment(String p_username) {
        try {
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            CloudAssessment assessment = new CloudAssessment();
            if ( conn != null ) {
                PreparedStatement ps = conn.prepareStatement("select * from cloudassessment where username= ?");
                ps.setString(1, p_username);
                System.out.println(ps.toString());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    assessment.setCloudAssessmentId(rs.getString("idCloudAssessment"));
                    assessment.setCloudType(rs.getString("cloudtype"));
                    assessment.setEndDate(rs.getString("enddate"));
                    assessment.setNextStep(rs.getString("nextstep"));
                    assessment.setProcessStep("processstep");
                    assessment.setRegistrationId(rs.getString("registrationid"));
                    assessment.setStartDate(rs.getString("startdate"));
                    assessment.setStatus("status");
                    assessment.setTIAssessor("TIassessor");
                    assessment.setUserName("username");
                    assessment.setVendorName("vendorname");
                }
                
            }
            return assessment;
        } catch (Exception ex) {
                System.out.println(ex.getMessage());
                return new CloudAssessment();
        }
    }
    
}
