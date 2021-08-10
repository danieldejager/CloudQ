/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;

import disc.tiinfosec.businessobjects.QuestionCategory;
import disc.tiinfosec.datalayer.GetQuestionCategories;
import disc.tiinfosec.datalayer.InsertUpdateQuestionCategory;
import java.util.ArrayList;

/**
 *
 * @author daniel112
 */
public class QuestionWeightManagement {
    
    public boolean ReviewQuestionWeights(QuestionCategory p_cat) {
       
        if ( isValidWeight(p_cat.getCategoryWeight())) {
            InsertUpdateQuestionCategory updater = new InsertUpdateQuestionCategory();
            updater.UpdateCategoryWeight(p_cat);
            return true;
        } else {
            return false;
        }
        
            
        
    }
    
    private boolean isValidWeight(int p_weight) {
        boolean result = false;
        System.out.println(p_weight);
        ArrayList<QuestionCategory> list = new ArrayList<QuestionCategory>();
        GetQuestionCategories categories = new GetQuestionCategories();
        list = categories.retrieveAllCategories();
        int counter = 0;
        for(QuestionCategory cat : list) {
             counter = counter + cat.getCategoryWeight();
             if (counter > 100) break;
        }
        counter = counter + p_weight;
        System.out.println("Total weighting for all categories is : " + counter);
        if (counter > 100 ) {
            System.out.println(result);
            result = false;
        } else {
            System.out.println(result);
            result = true;
        }
        return result; 
    }
    
}
