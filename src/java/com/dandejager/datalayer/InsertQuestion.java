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
 */
public class InsertQuestion {
    
    public void InsertNewQuestion(Question p_question) {
        try {
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if (conn != null ) {
                PreparedStatement ps = conn.prepareStatement("insert into questions (question, category, evidence) values(?,?,?)");
                ps.setString(1, p_question.getQuestion());
                ps.setString(2, p_question.getCategory());
                ps.setString(3, p_question.getEvidencerequired());
                int i = ps.executeUpdate();
            } else {
                System.out.println("Error occcored connecting to the database");
            }
            dl.CloseConnection(conn);
        } catch (Exception ex ) {
            System.out.println(ex.getMessage());
        }
    }
}
