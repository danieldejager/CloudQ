/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;
import disc.tiinfosec.businessobjects.*;
import disc.tiinfosec.datalayer.InsertQuestion;
/**
 *
 * @author daniel112
 */
public class AddNewQuestions {
    
    public void InsertNewQuestion(String p_question, String p_evidence, String p_category) {
        Question q = new Question();
        q.setCategory(p_category);
        q.setEvidencerequired(p_evidence);
        q.setQuestion(p_question);
        InsertQuestion iq = new InsertQuestion();
        iq.InsertNewQuestion(q);
    }
    
}
