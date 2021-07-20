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
public class Answer {
    
    private String questionAnswer;
    private String questionElaboration;
    private String evidenceString;
    private String detailSupportingResponse;
    private String username;
    private String questionid;
    private String registrationid;
    private StreamedContent fileStream;

    public StreamedContent getFileStream() {
        return fileStream;
    }

    public void setFileStream(StreamedContent fileStream) {
        this.fileStream = fileStream;
    }
    
    

    public String getRegistrationid() {
        return registrationid;
    }

    public void setRegistrationid(String registrationid) {
        this.registrationid = registrationid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getQuestionid() {
        return questionid;
    }

    public void setQuestionid(String questionid) {
        this.questionid = questionid;
    }
    
    

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public String getQuestionElaboration() {
        return questionElaboration;
    }

    public void setQuestionElaboration(String questionElaboration) {
        this.questionElaboration = questionElaboration;
    }

    public String getEvidenceString() {
        return evidenceString;
    }

    public void setEvidenceString(String evidenceString) {
        this.evidenceString = evidenceString;
    }

    public String getDetailSupportingResponse() {
        return detailSupportingResponse;
    }

    public void setDetailSupportingResponse(String detailSupportingResponse) {
        this.detailSupportingResponse = detailSupportingResponse;
    }
    
    
}
