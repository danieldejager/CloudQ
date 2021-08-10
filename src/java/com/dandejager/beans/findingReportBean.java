/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.beans;

import disc.tiinfosec.businesslayer.AssessmentCloseOut;
import disc.tiinfosec.businessobjects.CloudAssessment;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author daniel112
 */
@ManagedBean
@SessionScoped
public class findingReportBean  implements Serializable {

private ArrayList<CloudAssessment> mainlist;    
private CloudAssessment selectedAssessment;

    @PostConstruct
    public void init() {
        AssessmentCloseOut out = new AssessmentCloseOut();
        mainlist = out.GetAllCompletedAssessments();
    }

    public CloudAssessment getSelectedAssessment() {
        return selectedAssessment;
    }

    public void setSelectedAssessment(CloudAssessment selectedAssessment) {
        this.selectedAssessment = selectedAssessment;
    }

    public ArrayList<CloudAssessment> getMainlist() {
        return mainlist;
    }

    public void setMainlist(ArrayList<CloudAssessment> mainlist) {
        this.mainlist = mainlist;
    }
    
    public void onRowSelect(SelectEvent event) {
      try {
          //get the selected CloudAssessment
          selectedAssessment = (CloudAssessment) event.getObject();
          //now that you have it, let's display all the stuff on another screen
          HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
          session.setAttribute("cloudassessmentobject", selectedAssessment);
          FacesContext.getCurrentInstance().getExternalContext().redirect("displayAll.xhtml");
         
      } catch (Exception ex) {
            System.out.println(ex.getMessage());
      }
        
    }
 
    public void onRowUnselect(UnselectEvent event) {
        
    }
    
    


    
}
