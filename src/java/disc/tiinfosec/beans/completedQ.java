/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.beans;

import disc.tiinfosec.businessobjects.CloudAssessment;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import disc.tiinfosec.businesslayer.*;
import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
/**
 *
 * @author DANIEL112
 */
@ManagedBean
@RequestScoped
public class completedQ {
    
    private ArrayList<CloudAssessment> mainlist;
    private CloudAssessment cloud;
    
    private CloudAssessment selectedCloudAssessment;
    
    @PostConstruct
    public void init() {
        AssessmentCloseOut out = new AssessmentCloseOut();
        mainlist = out.GetAllCompletedAssessments();
    }

    public ArrayList<CloudAssessment> getMainlist() {
        return mainlist;
    }

    public void setMainlist(ArrayList<CloudAssessment> mainlist) {
        this.mainlist = mainlist;
    }

    public CloudAssessment getCloud() {
        return cloud;
    }

    public void setCloud(CloudAssessment cloud) {
        this.cloud = cloud;
    }
    
    public void onRowSelect(SelectEvent event ) {
     try {
        selectedCloudAssessment = (CloudAssessment) event.getObject();
         HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
         session.setAttribute("cloudassessmentobject", selectedCloudAssessment);
         FacesContext.getCurrentInstance().getExternalContext().redirect("prepareEvaluation.xhtml");
     } catch (Exception ex) {
         System.out.println(ex.getMessage());
     }
        
    }
    
    public void onRowUnselect(UnselectEvent event) {
        selectedCloudAssessment = null;
    }

    public CloudAssessment getSelectedCloudAssessment() {
        return selectedCloudAssessment;
    }

    public void setSelectedCloudAssessment(CloudAssessment selectedCloudAssessment) {
        this.selectedCloudAssessment = selectedCloudAssessment;
    }
    
    
    
    
  
    
    
}
