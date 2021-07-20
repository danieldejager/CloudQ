/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.beans;

import disc.tiinfosec.businesslayer.PopulateMaintainCategories;
import disc.tiinfosec.businesslayer.QuestionWeightManagement;
import disc.tiinfosec.businessobjects.QuestionCategory;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author daniel112
 */
@ManagedBean
@RequestScoped
public class QuestionWeights implements Serializable {
    
    private String Weight;
    private ArrayList<QuestionCategory> list;
    private String category;
    private String categoryid;
    
    @PostConstruct
    public void init() {
        try {
            PopulateMaintainCategories cat = new PopulateMaintainCategories();
            list = cat.RetrieveCategories();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    
    public void setCategory(String category) {
        this.category = category;
    }

    
    public ArrayList<QuestionCategory> getList() {
        return list;
    }

    public void setList(ArrayList<QuestionCategory> list) {
        this.list = list;
        
    }
    
    public String getWeight() {
        return Weight;
    }

    public void setWeight(String Weight) {
        this.Weight = Weight;
    }
    
     public void onRowEdit(RowEditEvent event) {
     try {
         if ((Integer.parseInt(Weight) < 100) && (Integer.parseInt(Weight) >= 0) ) {
                QuestionCategory cat = (QuestionCategory) event.getObject();
                cat.setCategoryWeight(Integer.parseInt(Weight));
                QuestionWeightManagement man = new QuestionWeightManagement();
                if (!man.ReviewQuestionWeights(cat)) {
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Total Wright cannot exceed 100%"));
                }
         } else {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Total Weight must be greater than 0 or less than 100"));
         } 
        PopulateMaintainCategories pop = new PopulateMaintainCategories();
        list = pop.RetrieveCategories();
     } catch (Exception ex) {
         Weight = "0";
        PopulateMaintainCategories pop = new PopulateMaintainCategories();
        list = pop.RetrieveCategories();
     }
    }
    
    public void onRowCancel(RowEditEvent event) {
        
    }
}
    
    
    

