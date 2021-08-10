/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;
import disc.tiinfosec.utilities.InitialiseDataLayer;
import java.sql.*;
import java.util.*;
import disc.tiinfosec.businessobjects.RegistrationStatus;
/**
 *
 * @author daniel112
 */
public class GetRegistrationStatus {

 private  Connection conn;
 private  List<RegistrationStatus> list;
 private  RegistrationStatus status;

 public GetRegistrationStatus() {};

    public List<RegistrationStatus> getAllRegistrationStatus() {
        try {
                InitialiseDataLayer dl = new InitialiseDataLayer();
                conn = dl.getConnection();
                if ( conn != null ) {
                    PreparedStatement ps = conn.prepareStatement("select * from registrationstatus");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        status = new RegistrationStatus();
                        status.setRegistrationStatus(rs.getString("status"));
                        System.out.println(rs.getString("status"));
                        list.add(status);
                    }
                    dl.CloseConnection(conn);
                }
                return list;
            } catch (Exception ex ) {
                System.out.println(ex.getMessage());
                return null;
            }

    }

}
