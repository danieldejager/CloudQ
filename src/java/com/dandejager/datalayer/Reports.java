/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;
import disc.tiinfosec.utilities.InitialiseDataLayer;
import java.sql.*;
import java.util.*;
import disc.tiinfosec.businessobjects.*;
/**
 *
 * @author DANIEL112
 */
public class Reports {
    
    public int getTotalCloudAssessments() {
        try {
            int totalAssessments=0;
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if(conn!=null) {
                PreparedStatement ps = conn.prepareStatement("select count(*) as Total from cloudassessment");
                System.out.println(ps.toString());
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    totalAssessments = Integer.parseInt(rs.getString("Total"));
                }
                  dl.CloseConnection(conn);
                  return totalAssessments;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }
    
    public int getCompletedAssessmentCount() {
        try {
            int completedAssessments=0;
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if(conn!=null) {
                PreparedStatement ps = conn.prepareStatement("select count(*) as completed from cloudassessment where status = ?");
                ps.setString(1,"closed");
                System.out.println(ps.toString());
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    completedAssessments = Integer.parseInt(rs.getString("completed"));
                }
                dl.CloseConnection(conn);
                return completedAssessments;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }
    
    public int getCloudAssessmentsWithReportsCount() {
        try {
            int completedAssessments=0;
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if(conn!=null) {
                PreparedStatement ps = conn.prepareStatement("select count(*) as completed from cloudassessment where nextstep = ?");
                ps.setString(1,"none");
                System.out.println(ps.toString());
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    completedAssessments = Integer.parseInt(rs.getString("completed"));
                }
                dl.CloseConnection(conn);
                return completedAssessments;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }
    
    
    
    public int getFindingsByQuestionCategoryName(String p_questionCategoryName) {
        try {
            int TotalCalc=0;
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if(conn!=null) {
                PreparedStatement ps = conn.prepareStatement("select count(*) as Total from Findings where category = ?");
                ps.setString(1, p_questionCategoryName);
                System.out.println(ps.toString());
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    TotalCalc = Integer.parseInt(rs.getString("Total"));
                }
                dl.CloseConnection(conn);
                return TotalCalc;                        
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }
    
    public int getFindingsByQuestionCategoryNameAndSeverity(String p_questionCategoryName, String p_severity) {
        try {
            int TotalCalc=0;
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if(conn!=null) {
                PreparedStatement ps = conn.prepareStatement("select count(*) as Total from Findings where category = ? and severity = ?");
                ps.setString(1, p_questionCategoryName);
                ps.setString(2, p_severity);
                System.out.println(ps.toString());
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    TotalCalc = Integer.parseInt(rs.getString("Total"));
                }
                dl.CloseConnection(conn);
                return TotalCalc;                        
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }
    
}
