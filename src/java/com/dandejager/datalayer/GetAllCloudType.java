/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;

import disc.tiinfosec.utilities.InitialiseDataLayer;
import disc.tiinfosec.businessobjects.CloudType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author daniel112
 */
public class GetAllCloudType {
    
    private ArrayList<CloudType> cloudtype;
    private CloudType type;
            
    
     public ArrayList<CloudType> RetrieveAllCloudTypes() {
         InitialiseDataLayer dl = new InitialiseDataLayer();
         cloudtype = new ArrayList<CloudType>();
         try {
             Connection conn = dl.getConnection();
             PreparedStatement ps = conn.prepareStatement("select * from cloudtype");
             System.out.println(ps);
             ResultSet rs = ps.executeQuery();
           
             while ( rs.next()) {
                 type = new CloudType();
                 type.setCloudtype(rs.getString("type"));
                 System.out.println(type.getCloudtype());
                 cloudtype.add(type);
             }
             dl.CloseConnection(conn);
             System.out.println("Size of array = " + cloudtype.size());
             return cloudtype;
             
         } catch (Exception ex) {
                System.out.println(ex.getMessage());
                return null;
         }
     }
}
