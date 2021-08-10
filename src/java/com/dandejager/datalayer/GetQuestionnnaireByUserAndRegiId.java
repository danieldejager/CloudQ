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
 * @author DANIEL112
 */
public class GetQuestionnnaireByUserAndRegiId {
        
    public Questionnaire returnQbyUserandRegid(String p_regid) {
        Questionnaire q = new Questionnaire();
        try {
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if(conn!=null) {
                PreparedStatement ps = conn.prepareStatement("select * from questionnaire where registrationid= ?");
                ps.setString(1, p_regid);
                System.out.println(ps.toString());
                ResultSet rs = ps.executeQuery();
                while( rs.next()) {
                    q.setFilepath(rs.getString("filepath"));;
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
