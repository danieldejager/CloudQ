/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;
import java.sql.*;
import disc.tiinfosec.businessobjects.Questionnaire;
import disc.tiinfosec.utilities.InitialiseDataLayer;
/**
 *
 * @author daniel112
 */
public class GetQuestionnaire {
    
    public Questionnaire GetQuestionnaireByRegistrationId(String p_registrationId) {
        try {
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            Questionnaire q = new Questionnaire();
            if(conn!=null) {
                PreparedStatement ps = conn.prepareStatement("select * from questionnaire where registrationid = ?");
                ps.setString(1, p_registrationId);
                System.out.println(ps);
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    q.setFilename(rs.getString("filename"));
                    q.setFilepath(rs.getString("filepath"));
                    q.setJustification(rs.getString("justification"));
                    q.setVendorinformation(rs.getString("vendorinformation"));
                    q.setNDA(rs.getString("nonDisclosure"));
                    q.setRecordid(rs.getString("idquestionnaire"));
                    q.setRegistrationid(rs.getString("registrationid"));
                }
                dl.CloseConnection(conn);;
                return q;
            }
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
