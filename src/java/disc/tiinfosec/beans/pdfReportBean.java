/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.beans;

import disc.tiinfosec.businesslayer.CompileReportforView;
import disc.tiinfosec.businesslayer.generateReports;
import disc.tiinfosec.businessobjects.AssessmentReport;
import disc.tiinfosec.businessobjects.CloudAssessment;
import disc.tiinfosec.businessobjects.Finding;
import disc.tiinfosec.businessobjects.MainReport;
import disc.tiinfosec.datalayer.GetAssessmentReport;
import disc.tiinfosec.datalayer.GetFindings;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import disc.tiinfosec.utilities.PDFManager;
import java.util.ArrayList;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author daniel112
 */
@ManagedBean
@RequestScoped
public class pdfReportBean implements Serializable{
    
    private CloudAssessment selectedCloudAssessment;
    private ArrayList<Finding> findinlist;
    private AssessmentReport report;
    private String message = "Cloud Assessment Object not retrieved from memory";
    
    
    @PostConstruct
    public void init() {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            selectedCloudAssessment = (CloudAssessment) session.getAttribute("cloudassessmentobject");
            message = "Cloud Assessment Object retrieved";
            MainReport main = new MainReport();
            CompileReportforView compiler = new CompileReportforView();
            main = compiler.compileScreenReport(selectedCloudAssessment);
            findinlist = main.getFindinglist();
            report = main.getReport();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
        
   
         
    

    public CloudAssessment getSelectedCloudAssessment() {
        return selectedCloudAssessment;
    }

    public void setSelectedCloudAssessment(CloudAssessment selectedCloudAssessment) {
        this.selectedCloudAssessment = selectedCloudAssessment;
    }

    public ArrayList<Finding> getFindinlist() {
        return findinlist;
    }

    public void setFindinlist(ArrayList<Finding> findinlist) {
        this.findinlist = findinlist;
    }

    public AssessmentReport getReport() {
        return report;
    }

    public void setReport(AssessmentReport report) {
        this.report = report;
    }
    
    
    
    
    
    
    
}
