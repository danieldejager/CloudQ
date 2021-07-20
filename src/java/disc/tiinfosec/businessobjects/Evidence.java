/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businessobjects;

/**
 *
 * @author daniel112
 */
public class Evidence {
    
    private String idEvidence;
    private String evidenceString;
    private String idCloudAssessment;
    private String idVendor;
    private String idRegistration;

    public String getIdEvidence() {
        return idEvidence;
    }

    public void setIdEvidence(String idEvidence) {
        this.idEvidence = idEvidence;
    }

    public String getEvidenceString() {
        return evidenceString;
    }

    public void setEvidenceString(String evidenceString) {
        this.evidenceString = evidenceString;
    }

    public String getIdCloudAssessment() {
        return idCloudAssessment;
    }

    public void setIdCloudAssessment(String idCloudAssessment) {
        this.idCloudAssessment = idCloudAssessment;
    }

    public String getIdVendor() {
        return idVendor;
    }

    public void setIdVendor(String idVendor) {
        this.idVendor = idVendor;
    }

    public String getIdRegistration() {
        return idRegistration;
    }

    public void setIdRegistration(String idRegistration) {
        this.idRegistration = idRegistration;
    }
    
    
    
}
