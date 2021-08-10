/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;
import disc.tiinfosec.datalayer.GetCloudAssessmentByUserName;
import disc.tiinfosec.businessobjects.CloudAssessment;
/**
 *
 * @author daniel112
 */
public class RetrieveCloudAssessment {
    
    public CloudAssessment RetrieveCloudAssessmentStatus(String p_username) {
        GetCloudAssessmentByUserName get = new GetCloudAssessmentByUserName();
        return get.GetAsessment(p_username);
    }
    
}
