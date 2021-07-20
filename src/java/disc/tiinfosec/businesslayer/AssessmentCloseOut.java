/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;
import disc.tiinfosec.datalayer.GetCompletedCloudAssessment;
import disc.tiinfosec.businessobjects.CloudAssessment;
import java.util.ArrayList;
/**
 *
 * @author DANIEL112
 */
public class AssessmentCloseOut {
    
    public ArrayList<CloudAssessment> GetAllCompletedAssessments() {
        GetCompletedCloudAssessment get = new GetCompletedCloudAssessment();
        return get.GetAllCompletedAssessments();
    }
    
    public ArrayList<CloudAssessment> getAllReportedAssessments() {
         GetCompletedCloudAssessment get = new GetCompletedCloudAssessment();
        return get.GetAllCompletedAndReportedAssessments();
    }
}
