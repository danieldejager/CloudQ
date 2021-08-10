/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;
import disc.tiinfosec.businessobjects.Finding;
import disc.tiinfosec.businessobjects.QuestionCategory;
import disc.tiinfosec.businessobjects.Severity;
import disc.tiinfosec.datalayer.GetFindings;
import disc.tiinfosec.datalayer.GetQuestionCategories;
import disc.tiinfosec.datalayer.GetSeverities;
import disc.tiinfosec.datalayer.Reports;
import java.util.*;
/**
 *
 * @author DANIEL112
 */
public class PostAssessment {
    
    public ArrayList<Finding> displayAllFindings() {
        GetFindings get = new GetFindings();
        return get.GetAllFindings();
    }
    
     public ArrayList<Finding> filterByRegistration(String p_registrationid) {
        GetFindings get = new GetFindings();
        return get.GetFindingByRegistrationId(p_registrationid);
    }
     
     public ArrayList<Finding> filterByCloudAssessment(String p_cloudassessmentid) {
          GetFindings get = new GetFindings();
        return get.GetFindingByCloudAssessmentId(p_cloudassessmentid);
     }
     
      public ArrayList<Finding> filterBySeverity(String p_severity) {
          GetFindings get = new GetFindings();
        return get.GetFindingBySeverity(p_severity);
     }
      
      public ArrayList<Finding> filterByRiskCategory(String p_category) {
           GetFindings get = new GetFindings();
           return get.GetFindingByCategory(p_category);
      }
      
      public ArrayList<Severity> getAllSeverityLevels() {
          GetSeverities get = new GetSeverities();
          return get.GetSeverities();
      }
      
      public ArrayList<QuestionCategory> getAllQuestionCategories() {
          GetQuestionCategories get = new GetQuestionCategories();
          return get.retrieveAllCategories();
      }
      
      public int getTotalCriticalFindings() {
          GetFindings get = new GetFindings();
          return get.GetTotalCriticalFindings();
      }
      
      public int getTotalHighFindings() {
          GetFindings get = new GetFindings();
          return get.GetTotalHighFindings();
      }
      
      public int getTotalMediumFindings() {
          GetFindings get = new GetFindings();
          return get.GetTotalMediumFindings();
      }
      
      public int getTotalLowFindings() {
          GetFindings get = new GetFindings();
          return get.GetTotalLowindings();
      }
      
      public int getTotalCloudAssessments() {
          Reports reports = new Reports();
          return reports.getTotalCloudAssessments();
      }
      
      public int getTotalCompletedCloudAssessments() {
          Reports reports = new Reports();
          return reports.getCompletedAssessmentCount();
      }
      
      public int getTotalCompletedWithReports() {
          Reports reports = new Reports();
          return reports.getCloudAssessmentsWithReportsCount();
      }
      
      public int getCountRiskCategory(String p_category) {
          Reports reports = new Reports();
          return reports.getFindingsByQuestionCategoryName(p_category);
      }
      
      public int getCountCategoryAndSeverity(String p_category, String p_severity) {
          Reports reports = new Reports();
          return reports.getFindingsByQuestionCategoryNameAndSeverity(p_category, p_severity);
      }
      
      
      
      
     
     
   
    
}
