/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;
import disc.tiinfosec.utilities.InitialiseDataLayer;
import java.sql.*;
import java.util.ArrayList;
import disc.tiinfosec.businessobjects.HighLevelQuestion;
import disc.tiinfosec.businessobjects.Questionnaire;
/**
 *
 * @author DANIEL112
 */
public class GetHighLevelQuestions {
    
    public ArrayList<HighLevelQuestion> GetAllHighLevelQuestions() {
        try {
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            HighLevelQuestion q = new HighLevelQuestion();
            ArrayList<HighLevelQuestion> list = new ArrayList<HighLevelQuestion>();
            if( conn != null ) {
                PreparedStatement ps = conn.prepareStatement("select * from highlevelquestions");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    q.setIdHighLevelQuestion(rs.getString("idhighlevelquestion"));
                    q.setQuestion(rs.getString("question"));
                    list.add(q);
                }
            }
            dl.CloseConnection(conn);
            return list;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public Questionnaire GetVendorResponse(String p_registrationid) {
        try {
            Questionnaire q = new Questionnaire();
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if ( conn!=null) {
                PreparedStatement ps = conn.prepareStatement("select * from questionnaire where registrationid = ?");
                ps.setString(1, p_registrationid);
                System.out.println(ps.toString());
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    q.setVendorinformation(rs.getString("vendorinformation"));
                    q.setRecordid(rs.getString("idquestionnaire"));
                    q.setFilename(rs.getString("filename"));
                    q.setFilepath(rs.getString("filepath"));
                    q.setNDA(rs.getString("nonDisclosure"));
                    q.setJustification(rs.getString("justification"));
                    q.setRegistrationid(p_registrationid);
                }
                dl.CloseConnection(conn);
                return q;
                
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }  
    
}
