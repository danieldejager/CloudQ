/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.beans;

import disc.tiinfosec.businesslayer.prepareEvaluationProcess;
import disc.tiinfosec.businessobjects.AssessmentReport;
import disc.tiinfosec.businessobjects.CloudAssessment;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import disc.tiinfosec.businessobjects.Finding;

/**
 *
 * @author daniel112
 */
@ManagedBean
@SessionScoped
public class prepEvaluationBean implements Serializable{
    private CloudAssessment selectedCloudAssessment;
    private ArrayList<Finding> findingslist;
    private AssessmentReport finalReport;
    private prepareEvaluationProcess process;
    
    
    @PostConstruct
    public void init() {
        //get the CloudAssessment Object from the ssion
        finalReport = new AssessmentReport();
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        selectedCloudAssessment = (CloudAssessment) session.getAttribute("cloudassessmentobject");
        process = new prepareEvaluationProcess();
        if (selectedCloudAssessment != null) {
            System.out.println("We are assessing cloud assessment " + selectedCloudAssessment.getCloudAssessmentId());
            findingslist = process.returnFindingsByCloudAssessmentId(selectedCloudAssessment.getCloudAssessmentId());
            if(findingslist.size() < 1) {
                System.out.println("There are no findings for this CloudAssessment");
            } else {
                System.out.println("We have so many findings " + findingslist.size());
            }
        } else {
            System.out.println("Cloud Assessment from session is null");
        }
    }

    public ArrayList<Finding> getFindingslist() {
        return findingslist;
    }

    public void setFindingslist(ArrayList<Finding> findingslist) {
        this.findingslist = findingslist;
    }
    
    

    public CloudAssessment getSelectedCloudAssessment() {
        return selectedCloudAssessment;
    }

    public void setSelectedCloudAssessment(CloudAssessment selectedCloudAssessment) {
        this.selectedCloudAssessment = selectedCloudAssessment;
    }

    public AssessmentReport getFinalReport() {
        return finalReport;
    }

    public void setFinalReport(AssessmentReport finalReport) {
        this.finalReport = finalReport;
    }
    

    public void handleReportSubmission() {
        try {
            finalReport.setCloudAssessmentId(selectedCloudAssessment.getCloudAssessmentId());
            process.CompileNewReport(finalReport);
            process.closeOutReport(selectedCloudAssessment.getRegistrationId());
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("cloudassessmentobject", null);
            FacesContext.getCurrentInstance().getExternalContext().redirect("mainpage-admin.xhtml");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    
    
    
    
    
}
