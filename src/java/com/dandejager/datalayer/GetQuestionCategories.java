/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;
import disc.tiinfosec.utilities.InitialiseDataLayer;
import java.sql.*;

import disc.tiinfosec.businessobjects.QuestionCategory;
import java.util.ArrayList;
/**
 *
 * @author daniel112
 */
public class GetQuestionCategories {
    
    public ArrayList<QuestionCategory> retrieveAllCategories() {
    try {    
        ArrayList<QuestionCategory> list = new ArrayList<QuestionCategory>();
        InitialiseDataLayer dl = new InitialiseDataLayer();
        Connection conn = dl.getConnection();
        if ( conn != null ) {
            PreparedStatement ps = conn.prepareStatement("select * from questioncategory");
            ResultSet rs = ps.executeQuery();
            while( rs.next()) {
                QuestionCategory cat = new QuestionCategory();
                cat.setQuestionCategoryId(rs.getString("idquestioncategory"));
                cat.setQuestionCategoryName(rs.getString("categoryquestion"));
                cat.setCategoryWeight(Integer.parseInt(rs.getString("weight")));
                list.add(cat);
            }
        }
        dl.CloseConnection(conn);
        return list;
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
        return null;
    }
    }
}
