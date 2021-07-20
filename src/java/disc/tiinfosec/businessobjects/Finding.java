/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businessobjects;

/**
 *
 * @author DANIEL112
 */
public class Finding {
private String findingId;
private String CloudAssessmentId;
private String Severity;
private String Category;
private String findingText;
private String registrationid;

    public String getRegistrationid() {
        return registrationid;
    }

    public void setRegistrationid(String registrationid) {
        this.registrationid = registrationid;
    }



    public String getFindingId() {
        return findingId;
    }

    public void setFindingId(String findingId) {
        this.findingId = findingId;
    }

    public String getCloudAssessmentId() {
        return CloudAssessmentId;
    }

    public void setCloudAssessmentId(String CloudAssessmentId) {
        this.CloudAssessmentId = CloudAssessmentId;
    }

    public String getSeverity() {
        return Severity;
    }

    public void setSeverity(String Severity) {
        this.Severity = Severity;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getFindingText() {
        return findingText;
    }

    public void setFindingText(String findingText) {
        this.findingText = findingText;
    }


}
