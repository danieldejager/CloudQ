/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;
import disc.tiinfosec.beans.QuestionCount;
import disc.tiinfosec.datalayer.GetAllQuestions;
import disc.tiinfosec.businessobjects.Question;
import java.util.ArrayList;
/**
 *
 * @author daniel112
 */
public class CountQuestionsByEvidence {
    
    public int countAllQuestions() {
        GetAllQuestions questions = new GetAllQuestions();
        ArrayList<Question> list = questions.GetAllQuestions();
        return list.size();
    }
    
    public QuestionCount countAllQuestionsByRequiredEvidence() {
        int j = 0;
        GetAllQuestions questions = new GetAllQuestions();
        ArrayList<Question> list = questions.GetAllQuestions();
        for (Question q : list) {
            if (q.getEvidencerequired().equals("Yes")) j++;
        }
        QuestionCount q = new QuestionCount();
        q.setEvidenceType("Yes");
        q.setCount(j);
        return q;
    }
    
    public QuestionCount countAllQuestionsNoEvidence() {
        int j = 0;
        GetAllQuestions questions = new GetAllQuestions();
        ArrayList<Question> list = questions.GetAllQuestions();
        for(Question q : list) {
            if (q.getEvidencerequired().equals("No")) j++;
        }
        QuestionCount q = new QuestionCount();
        q.setEvidenceType("No");
        q.setCount(j);
        return q;
    }
    
    
}
