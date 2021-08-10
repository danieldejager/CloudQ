/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businessobjects;

import org.primefaces.model.StreamedContent;

/**
 *
 * @author DANIEL112
 */
public class DisplayAssessment {
private String question;
private String answer;
private String elaboration;
private String evidencelink;
private StreamedContent uploadedFile;

    public StreamedContent getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(StreamedContent uploadedFile) {
        this.uploadedFile = uploadedFile;
    }


    
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getElaboration() {
        return elaboration;
    }

    public void setElaboration(String elaboration) {
        this.elaboration = elaboration;
    }

    public String getEvidencelink() {
        return evidencelink;
    }

    public void setEvidencelink(String evidencelink) {
        this.evidencelink = evidencelink;
    }
    
    


}
