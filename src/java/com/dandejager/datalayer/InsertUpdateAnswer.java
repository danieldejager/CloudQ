/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;
import disc.tiinfosec.utilities.InitialiseDataLayer;
import java.sql.*;
import java.util.Date;
import disc.tiinfosec.businessobjects.Answer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 *
 * @author DANIEL112
 */
public class InsertUpdateAnswer {
    
    public void insertNewAnswer(Answer p_answer) {
        try {
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if ( conn!= null) {
                PreparedStatement ps = conn.prepareStatement("insert into vendoranswers (questionid, answer, uploadedfilelocation, elaboration, registrationid, username, datetime) values (?,?,?,?,?,?,?)");
                ps.setString(1, p_answer.getQuestionid());
                ps.setString(2, p_answer.getQuestionAnswer());
                ps.setString(3, p_answer.getEvidenceString());
                ps.setString(4, p_answer.getQuestionElaboration());
                ps.setString(5, p_answer.getRegistrationid());
                ps.setString(6, p_answer.getUsername());
                Date date = new Date();
                DateFormat format = new SimpleDateFormat("yyyy/mm/dd HH:mm:ss");
                ps.setString(7, format.format(date));
                int j = ps.executeUpdate();
                dl.CloseConnection(conn);
            } else {
                System.out.println("Connection cannot be established. See server logs");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
