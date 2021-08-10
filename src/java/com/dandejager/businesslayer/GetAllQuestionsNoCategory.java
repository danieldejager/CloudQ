/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;
import java.util.*;
import disc.tiinfosec.businessobjects.Question;
import disc.tiinfosec.datalayer.GetAllQuestions;
/**
 *
 * @author daniel112
 */
public class GetAllQuestionsNoCategory {
    
    public ArrayList<Question> GetAllQuestions() {
        GetAllQuestions getQ = new GetAllQuestions();
        ArrayList<Question> qlist = getQ.GetAllQuestions();
        return qlist;
    }
    
}
