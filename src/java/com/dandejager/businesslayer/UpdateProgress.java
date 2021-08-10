/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;
import disc.tiinfosec.datalayer.UpdateQuestionnaireStatus;
/**
 *
 * @author DANIEL112
 */
public class UpdateProgress {
    public void updateProgressToDetailQuestions(String p_newStatus, String p_registrationid, String p_username) {
        UpdateQuestionnaireStatus stat = new UpdateQuestionnaireStatus();
        stat.updateQStatus(p_newStatus, p_registrationid, p_username);
    }
    
}
