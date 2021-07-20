/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;
import java.util.*;
import disc.tiinfosec.businessobjects.Assessment;
import disc.tiinfosec.businessobjects.CloudAssessment;
import disc.tiinfosec.businessobjects.Finding;
import disc.tiinfosec.businessobjects.QuestionCategory;
import disc.tiinfosec.datalayer.GetCloudAssessmentByRegistrationId;
import disc.tiinfosec.datalayer.GetQuestionCategories;
import disc.tiinfosec.datalayer.GetQuestionsWithAnswersbyRegistrationId;
import disc.tiinfosec.datalayer.InsertUpdateFinding;
/**
 *
 * @author DANIEL112
 */
public class prepareInternalAssessment {
    
    public ArrayList<Assessment> populateTable(String p_registration_id) {
        ArrayList<Assessment> assessment = new ArrayList<Assessment>();
        GetQuestionsWithAnswersbyRegistrationId obj = new GetQuestionsWithAnswersbyRegistrationId();
        assessment = obj.populateArrayListWithQandA(p_registration_id);
        return assessment;
    }
    
    public void addNewFinding(Finding p_finding) {
        InsertUpdateFinding obj = new InsertUpdateFinding();
        obj.insertNewFinding(p_finding);
    }
    
    public CloudAssessment GetCloudAssessmentByRegistrationId(String p_registrationid) {
        CloudAssessment assessment = new CloudAssessment();
        GetCloudAssessmentByRegistrationId get = new GetCloudAssessmentByRegistrationId();
        assessment = get.GetAsessment(p_registrationid);
        return assessment;
    }
    
    public ArrayList<QuestionCategory> GetAllCategories() {
        GetQuestionCategories get = new GetQuestionCategories();
        return get.retrieveAllCategories();
    }
    
  
    
 }
