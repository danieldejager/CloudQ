/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;
import disc.tiinfosec.businessobjects.Answer;
import disc.tiinfosec.datalayer.*;

/**
 *
 * @author DANIEL112
 */
public class UpdateQuestionnaireAnswer {
    
    public void UpdateQuestionAnswer(Answer p_answer) {
        InsertUpdateAnswer answer = new InsertUpdateAnswer();
        answer.insertNewAnswer(p_answer);
    }
    
}
