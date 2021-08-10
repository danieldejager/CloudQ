/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;
import disc.tiinfosec.datalayer.InsertUpdateCloudAssessment;
/**
 *
 * @author DANIEL112
 */
public class UpdateAssessment {
    public void updateAssessmentVendorCompleted(String p_registrationid, String p_username) {
        InsertUpdateCloudAssessment update=new InsertUpdateCloudAssessment();
        update.UpdateCloudAssessmentToCompleted(p_registrationid, p_username);
    }
}
