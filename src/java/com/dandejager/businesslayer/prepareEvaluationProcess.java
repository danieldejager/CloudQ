/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;
import disc.tiinfosec.businessobjects.AssessmentReport;
import disc.tiinfosec.datalayer.GetFindings;
import disc.tiinfosec.businessobjects.Finding;
import disc.tiinfosec.datalayer.InsertAssessmentReport;
import disc.tiinfosec.datalayer.InsertUpdateCloudAssessment;
import java.util.*;
/**
 *
 * @author daniel112
 */
public class prepareEvaluationProcess {
    
    public ArrayList<Finding> returnFindingsByCloudAssessmentId(String p_cloudAssessmentId) {
        GetFindings getter = new GetFindings();
        return getter.GetFindingByCloudAssessmentId(p_cloudAssessmentId);
    }
    
    public void CompileNewReport(AssessmentReport p_report) {
        InsertAssessmentReport report = new InsertAssessmentReport();
        report.InsertNewAssessmentReport(p_report);
    }
    
    public void closeOutReport(String p_registrationId) {
        InsertUpdateCloudAssessment closeout = new InsertUpdateCloudAssessment();
        closeout.updateCloudAssessmentCompleteCloseOut(p_registrationId);
    }
    
    
    
}
