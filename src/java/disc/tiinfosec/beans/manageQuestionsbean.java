/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.beans;

import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import disc.tiinfosec.businessobjects.Question;
import disc.tiinfosec.businesslayer.GetAllQuestionsNoCategory;
import disc.tiinfosec.businesslayer.PopulateQuestionaire;
import disc.tiinfosec.businesslayer.UpdateQuestionTable;
import disc.tiinfosec.businessobjects.QuestionCategory;
import disc.tiinfosec.businesslayer.PopuldateQuestionCategories;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author daniel112
 */
@ManagedBean(name="dtEditView")
@RequestScoped
public class manageQuestionsbean implements Serializable {
    
    private Question question;
    private String category;
    
    private ArrayList<Question> list = new ArrayList<Question>();
    private ArrayList<QuestionCategory> list2 = new ArrayList<QuestionCategory>();
    private ArrayList<String> questioncategories = new ArrayList<String>();
    
    @PostConstruct
    public void init()
    {
        try {
            GetAllQuestionsNoCategory gq = new GetAllQuestionsNoCategory();
            disc.tiinfosec.businesslayer.PopuldateQuestionCategories gg = new disc.tiinfosec.businesslayer.PopuldateQuestionCategories();
            list2 = gg.populateCategories();
            for (QuestionCategory cat : list2) {
                questioncategories.add(cat.getQuestionCategoryName());
            }
            list = gq.GetAllQuestions();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<QuestionCategory> getList2() {
        return list2;
    }

    public ArrayList<String> getQuestioncategories() {
        return questioncategories;
    }

    public void setQuestioncategories(ArrayList<String> questioncategories) {
        this.questioncategories = questioncategories;
    }
    
    

    public void setList2(ArrayList<QuestionCategory> list2) {
        this.list2 = list2;
    }

    
    
    public void setQuestion(Question question) {
        this.question = question;
    }

    public Question getQuestion() {
        return question;
    }

    public ArrayList<Question> getList() {
        return list;
    }

    public void setList(ArrayList<Question> list) {
        this.list = list;
    }
    
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        if( newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Updated","Old : " + oldValue + ", New: " + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    
    
    public void onRowEdit(RowEditEvent event) {
        Question newQuestion = (Question) event.getObject();
        UpdateQuestionTable updateTable = new UpdateQuestionTable();
        updateTable.UpdateQuestionTable(newQuestion);
        FacesMessage msg = new FacesMessage("Question Id " + newQuestion.getQuestionid() + " Edited", newQuestion.getQuestion());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onRowCancel(RowEditEvent event) {
        Question newquestion = (Question) event.getObject();
        UpdateQuestionTable updateTable = new UpdateQuestionTable();
        updateTable.DeleteQuestion(newquestion);
        GetAllQuestionsNoCategory gq = new GetAllQuestionsNoCategory();
        list = gq.GetAllQuestions();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("maintainQuestionsSelectCategory.xhtml");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
