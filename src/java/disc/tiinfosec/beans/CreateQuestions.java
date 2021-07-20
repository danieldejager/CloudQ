/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.beans;


import disc.tiinfosec.businesslayer.PopulateQuestionaire;
import disc.tiinfosec.businessobjects.QuestionCategory;
import disc.tiinfosec.businessobjects.CloudType;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.*;
import disc.tiinfosec.businesslayer.AddNewQuestions;
import disc.tiinfosec.businesslayer.PopuldateQuestionCategories;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author daniel112
 */
@ManagedBean
@RequestScoped
public class CreateQuestions {
    
    private String Question;
    private String isEvidenceRequired;
    private String category;
    

    
    //static data for controls
    ArrayList<CloudType> listCloudTypes = new ArrayList<CloudType>();
    ArrayList<String> QuestionCategories = new ArrayList<String>();

    
    
    @PostConstruct
    public void init() {
        PopuldateQuestionCategories pop = new PopuldateQuestionCategories();
        ArrayList<QuestionCategory> list = pop.populateCategories();
        if (list != null ) {
        if ( list.size() < 1) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"No cloud types have been defined","Please context the system administrator");
            FacesContext context;
            context = FacesContext.getCurrentInstance();
            context.addMessage(null, msg);
        } else {
            
            for(QuestionCategory t : list) {
                QuestionCategories.add(t.getQuestionCategoryName());
            }
            Question="";
            category="";
            isEvidenceRequired="";
        }
        } else {
            System.out.println("Object is null");
        }
    }

    public ArrayList<String> getQuestionCategories() {
        return QuestionCategories;
    }

    public void setQuestionCategories(ArrayList<String> QuestionCategories) {
        this.QuestionCategories = QuestionCategories;
    }

    
    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String Question) {
        this.Question = Question;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    
    public ArrayList<CloudType> getListCloudTypes() {
        PopulateQuestionaire pop = new PopulateQuestionaire();
        listCloudTypes = pop.RetrieveCloudTypes();
        return listCloudTypes;
    }

    public void setListCloudTypes(ArrayList<CloudType> listCloudTypes) {
        this.listCloudTypes = listCloudTypes;
    }

        public String getIsEvidenceRequired() {
        return isEvidenceRequired;
    }

    public void setIsEvidenceRequired(String isEvidenceRequired) {
        this.isEvidenceRequired = isEvidenceRequired;
    }
    
    public void AddNewQuestion(ActionEvent e) {
        try {
        if (Question.isEmpty() || category.isEmpty() || isEvidenceRequired.isEmpty()) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"A Question must be added","Insert a question");
            FacesContext context;
            context = FacesContext.getCurrentInstance();
            context.addMessage(null, msg);
        } else  {
            AddNewQuestions add = new AddNewQuestions();
            add.InsertNewQuestion(Question, isEvidenceRequired, category);
            FacesContext.getCurrentInstance().getExternalContext().redirect("createquestions.xhtml");
        }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void finishQuestions(ActionEvent e) {
        try {
            FacesContext c = FacesContext.getCurrentInstance();
            c.getApplication().getNavigationHandler().handleNavigation(c, null, "mainpage-admin");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
    
    

    
    
    
    
    
    
    
    
    

