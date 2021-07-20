/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;
import disc.tiinfosec.utilities.InitialiseDataLayer;
import java.sql.*;
import disc.tiinfosec.businessobjects.*;
import java.util.ArrayList;
/**
 *
 * @author daniel112
 */
public class GetAllQuestions {
    public ArrayList<Question> GetAllQuestions() {
        try {
             InitialiseDataLayer dl = new InitialiseDataLayer();
             Connection con = dl.getConnection();
             PreparedStatement ps = con.prepareStatement("select * from questions");
             System.out.println(ps.toString());
             ResultSet rs = ps.executeQuery();
             ArrayList<Question> list = new ArrayList<Question>();
             while (rs.next()) {
                Question q = new Question();
                q.setQuestionid(rs.getString("idquestions"));
                q.setCategory(rs.getString("category"));
                q.setEvidencerequired(rs.getString("evidence"));
                q.setQuestion(rs.getString("question"));
                q.setElaboration(rs.getString("elaboration"));
                q.setGuidance((rs.getString("guidance")));
                list.add(q);
             }
             dl.CloseConnection(con);
             return list;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}

