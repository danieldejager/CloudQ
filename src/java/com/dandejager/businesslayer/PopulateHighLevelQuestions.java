/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;
import disc.tiinfosec.datalayer.GetHighLevelQuestions;
import disc.tiinfosec.businessobjects.HighLevelQuestion;
import java.util.ArrayList;
/**
 *
 * @author DANIEL112
 */
public class PopulateHighLevelQuestions {
    
    public ArrayList<HighLevelQuestion> RetrieveHighLevelQuestions() {
        ArrayList<HighLevelQuestion> list = new ArrayList<HighLevelQuestion>();
        GetHighLevelQuestions get = new GetHighLevelQuestions();
        list = get.GetAllHighLevelQuestions();
        return list;
        
    }
}
