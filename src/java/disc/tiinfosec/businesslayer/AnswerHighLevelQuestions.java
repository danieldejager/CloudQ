/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;
import disc.tiinfosec.businessobjects.Questionnaire;
import disc.tiinfosec.datalayer.InsertNewHighLevelQuestion;
/**
 *
 * @author daniel112
 */
public class AnswerHighLevelQuestions {
    
    public void AnswerHighLevel(Questionnaire p_answers, String p_registrationid) {
        try {
            InsertNewHighLevelQuestion high = new InsertNewHighLevelQuestion();
            high.InsertHighLevel(p_answers, p_registrationid);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
