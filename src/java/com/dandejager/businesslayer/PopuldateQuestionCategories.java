/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;
import disc.tiinfosec.businessobjects.QuestionCategory;
import java.util.*;
import disc.tiinfosec.datalayer.GetQuestionCategories;
/**
 *
 * @author daniel112
 */
public class PopuldateQuestionCategories {
    
    public ArrayList<QuestionCategory> populateCategories() {
        ArrayList<QuestionCategory> list = new ArrayList<QuestionCategory>();
        GetQuestionCategories get = new GetQuestionCategories();
        list = get.retrieveAllCategories();
        return list;
    }
}
