/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;

import disc.tiinfosec.businessobjects.QuestionCategory;
import disc.tiinfosec.datalayer.GetQuestionCategories;
import java.util.ArrayList;

/**
 *
 * @author daniel112
 */
public class PopulateMaintainCategories {
    public ArrayList<QuestionCategory> RetrieveCategories() {
        GetQuestionCategories get = new GetQuestionCategories();
        ArrayList<QuestionCategory> list = get.retrieveAllCategories();
        return list;
    }
    
}
