/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.beans;

import disc.tiinfosec.businessobjects.CloudAssessment;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import disc.tiinfosec.businesslayer.populateAssessmentStatus;
import java.io.Serializable;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
 
/**
 *
 * @author DANIEL112
 */
@ManagedBean
@SessionScoped
public class AssessmentStatusBean implements Serializable {
    
    private ArrayList<CloudAssessment> list;
    private CloudAssessment selectedAssessment;
    
    @PostConstruct
    public void init(){
        populateAssessmentStatus status = new populateAssessmentStatus();
        list = status.GetStatusTable();
    }

    public ArrayList<CloudAssessment> getList() {
        populateAssessmentStatus status = new populateAssessmentStatus();
        list = status.GetStatusTable();
        return list;
    }

    public void setList(ArrayList<CloudAssessment> list) {
        this.list = list;
    }

    public CloudAssessment getSelectedAssessment() {
        return selectedAssessment;
    }

    public void setSelectedAssessment(CloudAssessment selectedAssessment) {
        this.selectedAssessment = selectedAssessment;
        System.out.println("The assessment has been set to registration id " + this.selectedAssessment.getRegistrationId());
    }
    
    public void onRowSelect(SelectEvent event) {
      try {
        //ok get the cloudassessment object
        System.out.println("Row Event has triggered");
        CloudAssessment newSelected = (CloudAssessment) event.getObject();
        System.out.println(newSelected.getRegistrationId());
        FacesContext context = FacesContext.getCurrentInstance();
        //add this fucker to the session
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.setAttribute("internalassessmentid", newSelected.getRegistrationId());
        System.out.println(session.getAttribute("internalassessmentid"));
        context.getExternalContext().redirect("performAssessment.xhtml");
      } catch (Exception ex) {
            System.out.println(ex.getMessage());
      }
        
    }
 
    public void onRowUnselect(UnselectEvent event) {
        
    }
    
    
    
}
