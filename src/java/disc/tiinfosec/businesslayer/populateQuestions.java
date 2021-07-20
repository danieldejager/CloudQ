/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;
import disc.tiinfosec.datalayer.GetQuestions;
import disc.tiinfosec.businessobjects.Question;
/**
 *
 * @author DANIEL112
 */
public class populateQuestions {
    
    public Question getQuestionNumber(String p_number) {
        GetQuestions get = new GetQuestions();
        Question q = get.getQuestionbyNumber(p_number);
        return q;
    }
    
}
