/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;
import disc.tiinfosec.utilities.InitialiseDataLayer;
import disc.tiinfosec.businessobjects.Questionnaire;
import java.sql.*;
/**
 *
 * @author daniel112
 */
public class InsertNewHighLevelQuestion {
    
    public void InsertHighLevel(Questionnaire p_highlevel, String p_registrationid) {
    try {    
        InitialiseDataLayer dl = new InitialiseDataLayer();
        if (dl!=null) {
            Connection conn = dl.getConnection();
            if ( conn!= null ) {
                PreparedStatement ps = conn.prepareStatement("insert into questionnaire (vendorinformation, justification, nonDisclosure,filepath, registrationid,filename) values (?,?,?,?,?,?)");
                ps.setString(1, p_highlevel.getVendorinformation());
                ps.setString(2, p_highlevel.getJustification());
                ps.setString(3,p_highlevel.getNDA());
                ps.setString(4, p_highlevel.getFilepath());
                ps.setString(5,p_registrationid);
                ps.setString(6,p_highlevel.getFilename());
                System.out.println(ps.toString());
                int j = ps.executeUpdate();
            }
            dl.CloseConnection(conn);
        }
    } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
        
    }
    

