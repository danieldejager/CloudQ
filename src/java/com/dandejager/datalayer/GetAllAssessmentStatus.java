/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;
import disc.tiinfosec.utilities.InitialiseDataLayer;
import java.sql.*;
import disc.tiinfosec.businessobjects.CloudAssessment;
import java.util.ArrayList;
/**
 *
 * @author DANIEL112
 */
public class GetAllAssessmentStatus {
    
    private ArrayList<CloudAssessment> results = new ArrayList<CloudAssessment>();
    
    public ArrayList<CloudAssessment> ReturnAllAssessmentStatusRecords() {
    try {
        InitialiseDataLayer dl = new InitialiseDataLayer();
        Connection conn = dl.getConnection();
        
        if ( conn!=null) {
            PreparedStatement ps = conn.prepareStatement("select * from cloudassessment where status <> ?");
            ps.setString(1,"closed");
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                CloudAssessment ca = new CloudAssessment();
                ca.setCloudAssessmentId(rs.getString("idCloudAssessment"));
                System.out.println(ca.getCloudAssessmentId());
                ca.setVendorName(rs.getString("VendorName"));
                ca.setStatus(rs.getString("status"));
                ca.setStartDate(rs.getString("StartDate"));
                ca.setEndDate(rs.getString("EndDate"));
                ca.setTIAssessor(rs.getString("TIAssessor"));
                ca.setRegistrationId(rs.getString("registrationid"));
                ca.setProcessStep(rs.getString("processStep"));
                ca.setCloudType(rs.getString("cloudtype"));
                ca.setNextStep(rs.getString("nextStep"));
                ca.setUserName(rs.getString("username"));
                System.out.println(ca.getUserName());
                results.add(ca);
            }
            dl.CloseConnection(conn);
            System.out.println(results.size());
            return results;
        }
    } catch(Exception ex) {
        System.out.println(ex.getMessage());
        return new ArrayList<CloudAssessment>();
    }
    System.out.println("list size equals" + results.size());
    return results;
    }
}
