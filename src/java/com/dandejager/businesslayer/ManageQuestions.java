/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;
import disc.tiinfosec.datalayer.GetTotalQuestions;
/**
 *
 * @author DANIEL112
 */
public class ManageQuestions {
    
    public String getCount() {
        GetTotalQuestions q = new GetTotalQuestions();
        return q.getTotalQuestions();
    }
    
}
