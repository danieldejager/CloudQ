/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;
import disc.tiinfosec.utilities.InitialiseDataLayer;
import disc.tiinfosec.businessobjects.CloudAssessment;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author DANIEL112
 */
public class InsertUpdateCloudAssessment {
    
    public void InsertCloudAssessment(CloudAssessment p_assessment) {
        try {
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if ( conn != null ) {
                PreparedStatement ps = conn.prepareStatement("insert into cloudassessment (vendorname, status, startdate, registrationid, processstep, cloudtype, nextstep, username) values (?,?,?,?,?,?,?,?)");
                ps.setString(1,p_assessment.getVendorName());
                ps.setString(2, p_assessment.getStatus());
                ps.setString(3, p_assessment.getStartDate());
                ps.setString(4, p_assessment.getRegistrationId());
                ps.setString(5, p_assessment.getProcessStep());
                ps.setString(6, p_assessment.getCloudType());
                ps.setString(7, p_assessment.getNextStep());
                ps.setString(8, p_assessment.getUserName());
                System.out.println(ps.toString());
                int j = ps.executeUpdate();
                dl.CloseConnection(conn);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void UpdateCloudAssessmentToCompleted(String p_registrationid, String p_username) {
        try {
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if (conn!= null) {
                PreparedStatement ps = conn.prepareStatement("update CloudAssessment set status=?, processStep=?, nextStep=? where registrationid=? and username=?");
                System.out.println(ps.toString());
                ps.setString(1,"completedbyVendor");
                ps.setString(2,"answeringCompleted");
                ps.setString(3,"InternalAssessment");
                ps.setString(4,p_registrationid);
                ps.setString(5, p_username);
                int j = ps.executeUpdate();
                dl.CloseConnection(conn);
            }
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    public void UpdateCloudAssessmentStartDate(CloudAssessment p_cloud) {
        try {
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if ( conn!= null) {
                PreparedStatement ps = conn.prepareStatement("update cloudassessment set startdate = ? where registrationid = ? ");
                ps.setString(1, p_cloud.getStartDate());
                ps.setString(2, p_cloud.getRegistrationId());
                System.out.println(ps.toString());  
                int j = ps.executeUpdate();
            }
            dl.CloseConnection(conn);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void updateCloudAssessmentNextStep(String p_nextStep,String p_registrationId) {
        try {
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if (conn!= null) {
                PreparedStatement ps = conn.prepareStatement("update cloudassessment set nextstep=? where registrationid = ?");
                ps.setString(1, p_nextStep);
                ps.setString(2, p_registrationId);
                System.out.println(ps.toString());
                int j = ps.executeUpdate();
            }
            dl.CloseConnection(conn);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void closeOutCloudAssessmentByRegistrationId(String p_registrationid, String p_TI_Assessor) {
       /*
        status = closed
        enddate must be set
        current user logged in must be stored for TI_Assessor
        */ 
       try {
           InitialiseDataLayer dl = new InitialiseDataLayer();
           Connection conn = dl.getConnection();
           if(conn!=null) {
               PreparedStatement ps = conn.prepareStatement("update cloudassessment set status = ?, EndDate =  ? , TIAssessor = ?, nextstep = ? where registrationid = ?");
               DateFormat format = new SimpleDateFormat("YYYY-mm-dd");
               Date d = new Date();
               String today = format.format(d);
               ps.setString(1, "closed");
               ps.setString(2, today);
               ps.setString(3, p_TI_Assessor);
               ps.setString(4, "finalreport");
               ps.setString(5, p_registrationid);
               System.out.println(ps.toString());
               int j = ps.executeUpdate();
           }
           dl.CloseConnection(conn);
       } catch (Exception ex) {
           System.out.println(ex.getMessage());
       }
    }
    
    public void updateCloudAssessmentCompleteCloseOut(String p_registrationId) {
        try {
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if (conn!= null) {
                PreparedStatement ps = conn.prepareStatement("update cloudassessment set nextstep = ?, processStep = ? where registrationid = ?");
                ps.setString(1,"none");
                ps.setString(2,"completed");
                ps.setString(3, p_registrationId);
                System.out.println(ps.toString());
                int j = ps.executeUpdate();
            }
            dl.CloseConnection(conn);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
