/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;
import disc.tiinfosec.utilities.InitialiseDataLayer;
import java.sql.*;
import disc.tiinfosec.businessobjects.Vendor;
import java.util.ArrayList;
/**
 *
 * @author daniel112
 */
public class GetVendors {
    
    public ArrayList<Vendor> GetAllVendors() {
    try {
        InitialiseDataLayer dl = new InitialiseDataLayer();
        ArrayList<Vendor> list = new ArrayList<Vendor>();
        Connection conn = dl.getConnection();
        if ( conn != null ) {
            PreparedStatement ps = conn.prepareStatement("select * from vendor");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vendor v = new Vendor();
                v.setIdVendor(rs.getString("idVendor"));
                v.setVendorName(rs.getString("VendorName"));
                v.setCloudType(rs.getString("CloudType"));
                v.setContactPersonName(rs.getString("ContactPersonName"));
                v.setContactPersonEmail(rs.getString("ContactPersonEmail"));
                v.setContactPersonTelephone(rs.getString("ContactPersonTelephone"));
                list.add(v);
                System.out.println(list.size());
            }
            
        }
            dl.CloseConnection(conn);
            return list;
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
        return null;
    }
}
    
    public Vendor GetVendorbyName(String p_vendor_name) {
         try {
        InitialiseDataLayer dl = new InitialiseDataLayer();
        Vendor v = new Vendor();
        Connection conn = dl.getConnection();
        if ( conn != null ) {
            PreparedStatement ps = conn.prepareStatement("select * from vendor where vendorname=?");
            ps.setString(1,p_vendor_name);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                 
                v.setIdVendor(rs.getString("idVendor"));
                v.setVendorName(rs.getString("VendorName"));
                v.setCloudType(rs.getString("CloudType"));
                v.setContactPersonName(rs.getString("ContactPersonName"));
                v.setContactPersonEmail(rs.getString("ContactPersonEmail"));
                v.setContactPersonTelephone(rs.getString("ContactPersonTelephone"));
            }
        }
            dl.CloseConnection(conn);
            return v;
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
        return null;
    }
    }
    
    public Vendor GetVendorbyEmail(String p_email) {
         try {
        InitialiseDataLayer dl = new InitialiseDataLayer();
        Vendor v = new Vendor();
        Connection conn = dl.getConnection();
        if ( conn != null ) {
            PreparedStatement ps = conn.prepareStatement("select * from vendor where contactpersonemail=?");
            ps.setString(1,p_email);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                 
                v.setIdVendor(rs.getString("idVendor"));
                v.setVendorName(rs.getString("VendorName"));
                v.setCloudType(rs.getString("CloudType"));
                v.setContactPersonName(rs.getString("ContactPersonName"));
                v.setContactPersonEmail(rs.getString("ContactPersonEmail"));
                v.setContactPersonTelephone(rs.getString("ContactPersonTelephone"));
            }
        }
            dl.CloseConnection(conn);
            return v;
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
        return null;
    }
    }
}
    
