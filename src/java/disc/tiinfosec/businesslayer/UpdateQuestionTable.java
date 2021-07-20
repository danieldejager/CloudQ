/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;
import disc.tiinfosec.businessobjects.Question;
import disc.tiinfosec.datalayer.UpdateQuestion;
/**
 *
 * @author daniel112
 */
public class UpdateQuestionTable {
    
    public void UpdateQuestionTable(Question p_question) {
        UpdateQuestion update = new UpdateQuestion();
        update.InsertUpdateQuestion(p_question);
    }
    
    public void DeleteQuestion(Question p_question) {
        UpdateQuestion update = new UpdateQuestion();
        update.DeleteQuestion(p_question);
    }
    
}
