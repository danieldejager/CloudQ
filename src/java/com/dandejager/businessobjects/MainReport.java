/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businessobjects;
import disc.tiinfosec.businessobjects.Finding;
import disc.tiinfosec.businessobjects.AssessmentReport;
import disc.tiinfosec.businessobjects.CloudAssessment;
import java.util.*;
/**
 *
 * @author DANIEL112
 */
public class MainReport {
    
    private ArrayList<Finding> findinglist;
    private AssessmentReport report;
    private CloudAssessment cloudassessment;

    public ArrayList<Finding> getFindinglist() {
        return findinglist;
    }

    public void setFindinglist(ArrayList<Finding> findinglist) {
        this.findinglist = findinglist;
    }

    public AssessmentReport getReport() {
        return report;
    }

    public void setReport(AssessmentReport report) {
        this.report = report;
    }

    public CloudAssessment getCloudassessment() {
        return cloudassessment;
    }

    public void setCloudassessment(CloudAssessment cloudassessment) {
        this.cloudassessment = cloudassessment;
    }
    
    
    
    
}
