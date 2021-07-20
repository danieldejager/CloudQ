/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;
import disc.tiinfosec.utilities.InitialiseDataLayer;
import disc.tiinfosec.businessobjects.Question;
import java.sql.*;
/**
 *
 * @author daniel112
 * DataLayer method to update questions for the manage Questionnaire screen
 */
public class UpdateQuestion {
    public void InsertUpdateQuestion(Question p_newQuestion) {
        try {
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if ( conn!= null) {
                PreparedStatement ps = conn.prepareStatement("update questions set category = ? , question = ?, evidence = ?, elaboration = ? where idquestions = ?");
                ps.setString(1, p_newQuestion.getCategory());
                ps.setString(2, p_newQuestion.getQuestion());
                ps.setString(3, p_newQuestion.getEvidencerequired());
                ps.setString(4, p_newQuestion.getElaboration());
                ps.setString(5, p_newQuestion.getQuestionid());
                System.out.println(ps.toString());
                int j = ps.executeUpdate();
            }
            dl.CloseConnection(conn);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void DeleteQuestion(Question p_question) {
        try {
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if ( conn != null ) {
                PreparedStatement ps = conn.prepareStatement("delete from questions where idquestions = ?");
                ps.setString(1,p_question.getQuestionid());
                System.out.println(ps.toString());
                int j = ps.executeUpdate();
            }
            dl.CloseConnection(conn);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
