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
public class AssessmentReport {
    
    private String executiveSummary;
    private String cloudAssessmentId;
    private String requiresCIOReview;

    public String getExecutiveSummary() {
        return executiveSummary;
    }

    public void setExecutiveSummary(String executiveSummary) {
        this.executiveSummary = executiveSummary;
    }

    public String getCloudAssessmentId() {
        return cloudAssessmentId;
    }

    public void setCloudAssessmentId(String cloudAssessmentId) {
        this.cloudAssessmentId = cloudAssessmentId;
    }

    public String getRequiresCIOReview() {
        return requiresCIOReview;
    }

    public void setRequiresCIOReview(String requiresCIOReview) {
        this.requiresCIOReview = requiresCIOReview;
    }
    
    
    
    
    
}
