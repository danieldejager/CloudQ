/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;
import disc.tiinfosec.utilities.InitialiseDataLayer;
import disc.tiinfosec.businessobjects.Vendor;
import java.sql.*;
/**
 *
 * @author DANIEL112
 */
public class InsertUpdateVendor {
    
    public boolean InsertUpdateVendor(Vendor p_vendor) {
        boolean result = false;
        try {
            InitialiseDataLayer dl = new InitialiseDataLayer();
                    Connection conn = dl.getConnection();
                    if (conn!=null) {
                        PreparedStatement ps = conn.prepareStatement("select * from vendor where vendorname= ?");
                        ps.setString(1,p_vendor.getVendorName());
                        ResultSet rs = ps.executeQuery();
                        if (rs.next()) {
                            dl.CloseConnection(conn);
                        } else {
                            dl.CloseConnection(conn);
                            Connection conn2 = dl.getConnection();
                            PreparedStatement ps2 = conn2.prepareStatement("insert into vendor (vendorname,contactpersonname, contactpersonemail,contactpersontelephone) values (?,?,?,?)");
                            
                            ps2.setString(1, p_vendor.getVendorName());
                            ps2.setString(2,p_vendor.getContactPersonName());
                            ps2.setString(3,p_vendor.getContactPersonEmail());
                            ps2.setString(4,p_vendor.getContactPersonTelephone());
                            System.out.println(ps2.toString());
                            int j = ps2.executeUpdate();
                            result = true;
                           
                } //else just ignore becuase this is hte same person doing another assessment
                 //else just ignore becuase this is hte same person doing another assessment
                    }
                    dl.CloseConnection(conn);
                    return result;
        } catch (Exception ex ) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
