/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;
import disc.tiinfosec.utilities.InitialiseDataLayer;
import java.sql.*;
import disc.tiinfosec.businessobjects.Question;
/**
 *
 * @author DANIEL112
 */
public class GetQuestions {
    public Question getQuestionbyNumber(String p_number) {
        Question q = new Question();
        try {
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if(conn!=null){
                PreparedStatement ps = conn.prepareStatement("select * from questions where questionnumber = ?");
                ps.setString(1, p_number);
                System.out.println(ps.toString());
                ResultSet rs = ps.executeQuery();
                while (rs.next() ) {
                    q.setQuestion(rs.getString("question"));
                    q.setQuestionid(rs.getString("idquestions"));
                    q.setCategory(rs.getString("category"));
                    q.setEvidencerequired(rs.getString("evidence"));
                    q.setElaboration(rs.getString("elaboration"));
                    q.setQuestionNumber(rs.getString("questionnumber"));
                    q.setGuidance(rs.getString("guidance"));
                }
            }
            dl.CloseConnection(conn);
            return q;
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
       
    }
}
