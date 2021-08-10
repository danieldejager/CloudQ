/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;
import disc.tiinfosec.utilities.InitialiseDataLayer;
import disc.tiinfosec.businessobjects.QuestionCategory;
import java.sql.*;

/**
 *
 * @author daniel112
 */
public class InsertUpdateQuestionCategory {
   
    public void UpdateCategoryWeight(QuestionCategory p_cat) {
    try {
        InitialiseDataLayer dl = new InitialiseDataLayer();
        Connection conn = dl.getConnection();
            if (conn != null ) {
                PreparedStatement ps = conn.prepareStatement("update questioncategory set weight = ? where idquestioncategory = ?");
                ps.setString(1, String.valueOf(p_cat.getCategoryWeight()));
                ps.setString(2, p_cat.getQuestionCategoryId());
                int j = ps.executeUpdate();
            }
            dl.CloseConnection(conn);
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
    }
    }
}
