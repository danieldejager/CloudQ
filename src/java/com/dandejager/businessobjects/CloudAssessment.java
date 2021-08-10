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
public class CloudAssessment {
    private String CloudAssessmentId;
    private String VendorName;
    private String status;
    private String StartDate;
    private String EndDate;
    private String TIAssessor;
    private String RegistrationId;
    private String processStep;
    private String cloudType;
    private String nextStep;
    private String userName;

    public String getCloudAssessmentId() {
        return CloudAssessmentId;
    }

    public void setCloudAssessmentId(String CloudAssessmentId) {
        this.CloudAssessmentId = CloudAssessmentId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    

    public String getNextStep() {
        return nextStep;
    }

    public void setNextStep(String nextStep) {
        this.nextStep = nextStep;
    }
    
    

    public String getVendorName() {
        return VendorName;
    }

    public void setVendorName(String VendorName) {
        this.VendorName = VendorName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String StartDate) {
        this.StartDate = StartDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String EndDate) {
        this.EndDate = EndDate;
    }

    public String getTIAssessor() {
        return TIAssessor;
    }

    public void setTIAssessor(String TIAssessor) {
        this.TIAssessor = TIAssessor;
    }

    public String getRegistrationId() {
        return RegistrationId;
    }

    public void setRegistrationId(String RegistrationId) {
        this.RegistrationId = RegistrationId;
    }

    public String getProcessStep() {
        return processStep;
    }

    public void setProcessStep(String processStep) {
        this.processStep = processStep;
    }

    public String getCloudType() {
        return cloudType;
    }

    public void setCloudType(String cloudType) {
        this.cloudType = cloudType;
    }
    
    
    
}
