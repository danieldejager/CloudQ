/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businessobjects;

import java.io.Serializable;

/**
 *
 * @author daniel112
 */
public class Question  {
    
   private String questionid; 
   private String evidencerequired;
   private String question;
   private String category;
   private String elaboration;
   private String questionNumber;
   private String guidance;

    public String getGuidance() {
        return guidance;
    }

    public void setGuidance(String guidance) {
        this.guidance = guidance;
    }
   
   

    public String getElaboration() {
        return elaboration;
    }

    public String getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(String questionNumber) {
        this.questionNumber = questionNumber;
    }
    
    

    public void setElaboration(String elaboration) {
        this.elaboration = elaboration;
    }
   
   

    public String getEvidencerequired() {
        return evidencerequired;
    }

    public void setEvidencerequired(String evidencerequired) {
        this.evidencerequired = evidencerequired;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getQuestionid() {
        return questionid;
    }

    public void setQuestionid(String questionid) {
        this.questionid = questionid;
    }
    
    
   
   
    
}
