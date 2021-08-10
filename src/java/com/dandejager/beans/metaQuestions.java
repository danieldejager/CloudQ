/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import disc.tiinfosec.businesslayer.*;
import java.util.*;
import disc.tiinfosec.businessobjects.Question;
        
/**
 *
 * @author daniel112
 */
@ManagedBean
@RequestScoped
public class metaQuestions {
    
    protected Map<String, List<QuestionCount>> mappedList;

    public Map<String, List<QuestionCount>> getMappedList() {
        return mappedList;
    }

    public void setMappedList(Map<String, List<QuestionCount>> mappedList) {
        this.mappedList = mappedList;
    }

    public metaQuestions() {
        reLoad();
    }
    
    private void reLoad() {
        ArrayList<QuestionCount> yes = new ArrayList<QuestionCount>();
        ArrayList<QuestionCount> no = new ArrayList<QuestionCount>();
        CountQuestionsByEvidence counter = new CountQuestionsByEvidence();
        yes.add(counter.countAllQuestionsByRequiredEvidence());
        no.add(counter.countAllQuestionsNoEvidence());
        mappedList.put("Evidence Required", yes);
        mappedList.put("No Evidence Required", no);
    }
    

   
    
    
    
}
