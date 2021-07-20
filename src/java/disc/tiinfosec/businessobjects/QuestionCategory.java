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
public class QuestionCategory {
    
    private String questionCategoryId;
    private String questionCategoryName;
    private int categoryWeight;

    public int getCategoryWeight() {
        return categoryWeight;
    }

    public void setCategoryWeight(int categoryWeight) {
        this.categoryWeight = categoryWeight;
    }
    

    public String getQuestionCategoryId() {
        return questionCategoryId;
    }

    public void setQuestionCategoryId(String questionCategoryId) {
        this.questionCategoryId = questionCategoryId;
    }

    public String getQuestionCategoryName() {
        return questionCategoryName;
    }

    public void setQuestionCategoryName(String questionCategoryName) {
        this.questionCategoryName = questionCategoryName;
    }
    
    
    
}
