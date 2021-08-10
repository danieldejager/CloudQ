/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;
import java.sql.*;
import java.util.ArrayList;
import disc.tiinfosec.businessobjects.CloudAssessment;
import disc.tiinfosec.utilities.InitialiseDataLayer;
/**
 *
 * @author DANIEL112
 */
public class GetCompletedCloudAssessment {
    
    public ArrayList<CloudAssessment> GetAllCompletedAssessments() {
        try {
            ArrayList<CloudAssessment> toReturn = new ArrayList<CloudAssessment>();
            CloudAssessment temp = new CloudAssessment(); 
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if(conn!=null) {
                PreparedStatement ps = conn.prepareStatement("select * from CloudAssessment where status = ? and nextstep = ? and processstep = ?");
                ps.setString(1, "closed");
                ps.setString(2, "finalreport");
                ps.setString(3, "answeringCompleted");
                System.out.println(ps.toString());
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    temp.setCloudAssessmentId(rs.getString("idCloudAssessment"));
                    temp.setVendorName(rs.getString("VendorName"));
                    temp.setStatus(rs.getString("status"));
                    temp.setStartDate(rs.getString("startdate"));
                    temp.setEndDate(rs.getString("enddate"));
                    temp.setTIAssessor(rs.getString("TIAssessor"));
                    temp.setRegistrationId(rs.getString("registrationid"));
                    temp.setProcessStep(rs.getString("processstep"));
                    temp.setCloudType(rs.getString("CloudType"));
                    temp.setNextStep(rs.getString("nextstep"));
                    temp.setUserName(rs.getString("username"));
                    toReturn.add(temp);
                    temp = new CloudAssessment();
                }
                dl.CloseConnection(conn);
                return toReturn;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
     public ArrayList<CloudAssessment> GetAllCompletedAndReportedAssessments() {
        try {
            ArrayList<CloudAssessment> toReturn = new ArrayList<CloudAssessment>();
            CloudAssessment temp = new CloudAssessment(); 
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if(conn!=null) {
                PreparedStatement ps = conn.prepareStatement("select * from CloudAssessment where status = ? and nextstep = ? and processstep = ?");
                ps.setString(1, "closed");
                ps.setString(2, "none");
                ps.setString(3, "completed");
                System.out.println(ps.toString());
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    temp.setCloudAssessmentId(rs.getString("idCloudAssessment"));
                    temp.setVendorName(rs.getString("VendorName"));
                    temp.setStatus(rs.getString("status"));
                    temp.setStartDate(rs.getString("startdate"));
                    temp.setEndDate(rs.getString("enddate"));
                    temp.setTIAssessor(rs.getString("TIAssessor"));
                    temp.setRegistrationId(rs.getString("registrationid"));
                    temp.setProcessStep(rs.getString("processstep"));
                    temp.setCloudType(rs.getString("CloudType"));
                    temp.setNextStep(rs.getString("nextstep"));
                    temp.setUserName(rs.getString("username"));
                    toReturn.add(temp);
                    temp = new CloudAssessment();
                }
                dl.CloseConnection(conn);
                return toReturn;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
