/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;

import disc.tiinfosec.utilities.InitialiseDataLayer;
import java.sql.*;

/**
 *
 * @author DANIEL112
 */
public class GetTotalQuestions {
    public String getTotalQuestions() {
        try {
            String count="";
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if ( conn != null ) {
                PreparedStatement ps = conn.prepareStatement("select count(*) as totalQuestions from questions");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    count = rs.getString("totalQuestions");
                }
                dl.CloseConnection(conn);
                return count;
            } else {
                System.out.println("Database Connection cannot be establised");
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
