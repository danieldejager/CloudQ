/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;
import disc.tiinfosec.businessobjects.CloudAssessment;
import disc.tiinfosec.utilities.InitialiseDataLayer;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author daniel112
 */
public class GetReportedCloudAssessments {
    
    public ArrayList<CloudAssessment> GetReportedCloudAssessments() {
        try {
            ArrayList<CloudAssessment> list = new ArrayList<CloudAssessment>();
            CloudAssessment temp = new CloudAssessment();
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if(conn!=null){
                PreparedStatement ps = conn.prepareStatement("select * from CloudAssessment where nextstep = ?");
                ps.setString(1, "none");
                System.out.println(ps.toString());
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    temp.setCloudAssessmentId(rs.getString("idCloudAssessment"));
                    temp.setCloudType(rs.getString("cloudtype"));
                    temp.setEndDate(rs.getString("enddate"));
                    temp.setNextStep(rs.getString("nextstep"));
                    temp.setProcessStep(rs.getString("processstep"));
                    temp.setRegistrationId(rs.getString("registrationid"));
                    temp.setStartDate(rs.getString("startdate"));
                    temp.setStatus(rs.getString("status"));
                    temp.setTIAssessor(rs.getString("TIassessor"));
                    temp.setUserName(rs.getString("username"));
                    temp.setVendorName(rs.getString("vendorname"));
                    list.add(temp);
                    temp = new CloudAssessment();
                }
            }
            dl.CloseConnection(conn);
            return list;
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
}
