/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;
import disc.tiinfosec.utilities.InitialiseDataLayer;
import java.util.*;
import java.sql.*;
import disc.tiinfosec.businessobjects.Answer;
/**
 *
 * @author DANIEL112
 */
public class GetAnswersByRegiIdAndUserId {
    private ArrayList<Answer> answers = new ArrayList<Answer>();
    private Answer answer = new Answer();
    private String totalAnswers="";
    
    
    public String CountTotalAnswers(String p_registrationid, String p_username) {
        try {
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if (conn!= null) {
                PreparedStatement ps = conn.prepareStatement("select count(*) as totalAnswered from vendoranswers where registrationid = ? and username= ?");
                ps.setString(1, p_registrationid);
                ps.setString(2, p_username);
                System.out.println(ps.toString());
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    totalAnswers =rs.getString("totalAnswered");
                }
                dl.CloseConnection(conn);
                return totalAnswers;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return totalAnswers; 
    }
}
