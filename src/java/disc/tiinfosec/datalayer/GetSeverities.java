/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;
import disc.tiinfosec.utilities.InitialiseDataLayer;
import java.sql.*;
import disc.tiinfosec.businessobjects.Severity;
import java.util.*;
/**
 *
 * @author DANIEL112
 */
public class GetSeverities {
    
    
    public ArrayList<Severity> GetSeverities() {
        try {
            ArrayList<Severity> list = new ArrayList<Severity>();
            Severity sev = new Severity();
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if(conn!=null) {
                PreparedStatement ps = conn.prepareStatement("select * from severity");
                System.out.println(ps.toString());
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    sev.setSeverityid(rs.getString("idseverity"));
                    sev.setSeverityName(rs.getString("severityName"));
                    list.add(sev);
                }
                return list;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
