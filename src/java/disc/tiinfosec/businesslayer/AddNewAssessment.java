/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;
import disc.tiinfosec.businessobjects.CloudAssessment;
import disc.tiinfosec.datalayer.InsertUpdateCloudAssessment;
/**
 *
 * @author DANIEL112
 */
public class AddNewAssessment {
    
    public void InsertNewAssessment(CloudAssessment p_assessment) {
        InsertUpdateCloudAssessment insert = new InsertUpdateCloudAssessment();
        insert.InsertCloudAssessment(p_assessment);
    }
    
}
