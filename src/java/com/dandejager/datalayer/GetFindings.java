/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;
import disc.tiinfosec.utilities.InitialiseDataLayer;
import java.sql.*;
import disc.tiinfosec.businessobjects.Finding;
import java.util.*;
/**
 *
 * @author DANIEL112
 */
public class GetFindings {
    
    public ArrayList<Finding> GetFindingByRegistrationId(String p_registrationid) {
        try {
            ArrayList<Finding> list = new ArrayList<Finding>();
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if(conn!=null) {
                PreparedStatement ps = conn.prepareStatement("select * from Findings where registrationid = ?");
                ps.setString(1, p_registrationid);
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    Finding f = new Finding();
                    f.setCloudAssessmentId(rs.getString("cloudassessmentid"));
                    f.setRegistrationid(rs.getString("registrationid"));
                    f.setSeverity(rs.getString("severity"));
                    f.setCategory(rs.getString("category"));
                    f.setFindingId(rs.getString("idfinding"));
                    f.setFindingText(rs.getString("findingtext"));
                    list.add(f);
                }
                dl.CloseConnection(conn);
                return list;
                
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public ArrayList<Finding> GetFindingByCloudAssessmentId(String p_cloudassessmentid) {
        try {
            ArrayList<Finding> list = new ArrayList<Finding>();
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if(conn!=null) {
                PreparedStatement ps = conn.prepareStatement("select * from Findings where cloudassessmentid = ?");
                ps.setString(1, p_cloudassessmentid);
                System.out.println(ps.toString());
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    Finding f = new Finding();
                    f.setCloudAssessmentId(rs.getString("cloudassessmentid"));
                    f.setRegistrationid(rs.getString("registrationid"));
                    f.setSeverity(rs.getString("severity"));
                    f.setCategory(rs.getString("category"));
                    f.setFindingId(rs.getString("idfinding"));
                    f.setFindingText(rs.getString("findingtext"));
                    list.add(f);
                }
                dl.CloseConnection(conn);
                return list;
                
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public ArrayList<Finding> GetFindingBySeverity(String p_severity) {
         try {
            ArrayList<Finding> list = new ArrayList<Finding>();
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if(conn!=null) {
                PreparedStatement ps = conn.prepareStatement("select * from Findings where severity = ?");
                ps.setString(1, p_severity);
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    Finding f = new Finding();
                    f.setCloudAssessmentId(rs.getString("cloudassessmentid"));
                    f.setRegistrationid(rs.getString("registrationid"));
                    f.setSeverity(rs.getString("severity"));
                    f.setCategory(rs.getString("category"));
                    f.setFindingId(rs.getString("idfinding"));
                    f.setFindingText(rs.getString("findingtext"));
                    list.add(f);
                }
                dl.CloseConnection(conn);
                return list;
                
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public ArrayList<Finding> GetFindingByCategory(String p_category) {
         try {
            ArrayList<Finding> list = new ArrayList<Finding>();
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if(conn!=null) {
                PreparedStatement ps = conn.prepareStatement("select * from Findings where category = ?");
                ps.setString(1, p_category);
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    Finding f = new Finding();
                    f.setCloudAssessmentId(rs.getString("cloudassessmentid"));
                    f.setRegistrationid(rs.getString("registrationid"));
                    f.setSeverity(rs.getString("severity"));
                    f.setCategory(rs.getString("category"));
                    f.setFindingId(rs.getString("idfinding"));
                    f.setFindingText(rs.getString("findingtext"));
                    list.add(f);
                }
                dl.CloseConnection(conn);
                return list;
                
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public ArrayList<Finding> GetAllFindings() {
        try {
            ArrayList<Finding> list = new ArrayList<Finding>();
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if(conn!=null) {
                PreparedStatement ps = conn.prepareStatement("select * from Findings");
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    Finding f = new Finding();
                    f.setCloudAssessmentId(rs.getString("cloudassessmentid"));
                    f.setRegistrationid(rs.getString("registrationid"));
                    f.setSeverity(rs.getString("severity"));
                    f.setCategory(rs.getString("category"));
                    f.setFindingId(rs.getString("idfinding"));
                    f.setFindingText(rs.getString("findingtext"));
                    list.add(f);
                }
                dl.CloseConnection(conn);
                return list;
                
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public int GetTotalCriticalFindings() {
        try {
            int totalCritical=0;
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if(conn!=null) {
                PreparedStatement ps = conn.prepareStatement("select count(*) as total from findings where severity=?");
                ps.setString(1,"critical");
                System.out.println(ps.toString());
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    totalCritical = Integer.parseInt(rs.getString("total"));
                }
            }
            dl.CloseConnection(conn);
            return totalCritical;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }
    
     public int GetTotalHighFindings() {
        try {
            int totalHigh=0;
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if(conn!=null) {
                PreparedStatement ps = conn.prepareStatement("select count(*) as total from findings where severity=?");
                ps.setString(1,"high");
                System.out.println(ps.toString());
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    totalHigh = Integer.parseInt(rs.getString("total"));
                }
            }
            dl.CloseConnection(conn);
            return totalHigh;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }
     
      public int GetTotalMediumFindings() {
        try {
            int totalMedium=0;
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if(conn!=null) {
                PreparedStatement ps = conn.prepareStatement("select count(*) as total from findings where severity=?");
                ps.setString(1,"medium");
                System.out.println(ps.toString());
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    totalMedium = Integer.parseInt(rs.getString("total"));
                }
            }
            dl.CloseConnection(conn);
            return totalMedium;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }
      
      public int GetTotalLowindings() {
        try {
            int totalLow=0;
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if(conn!=null) {
                PreparedStatement ps = conn.prepareStatement("select count(*) as total from findings where severity=?");
                ps.setString(1,"low");
                System.out.println(ps.toString());
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    totalLow = Integer.parseInt(rs.getString("total"));
                }
            }
            dl.CloseConnection(conn);
            return totalLow;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }
}
