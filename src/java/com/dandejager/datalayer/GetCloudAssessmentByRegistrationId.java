/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;

import disc.tiinfosec.utilities.InitialiseDataLayer;
import disc.tiinfosec.businessobjects.CloudAssessment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DANIEL112
 */
public class GetCloudAssessmentByRegistrationId {


 public CloudAssessment GetAsessment(String p_registrationid) {
        try {
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            CloudAssessment assessment = new CloudAssessment();
            if ( conn != null ) {
                PreparedStatement ps = conn.prepareStatement("select * from cloudassessment where registrationid= ?");
                ps.setString(1, p_registrationid);
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
