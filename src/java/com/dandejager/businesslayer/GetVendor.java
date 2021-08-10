/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;

import disc.tiinfosec.businessobjects.Vendor;
import disc.tiinfosec.datalayer.GetVendors;

/**
 *
 * @author DANIEL112
 */
public class GetVendor {
    
    public Vendor GetVendorbyVendorName(String p_vendor_name) {
        GetVendors getvendors = new GetVendors();
        Vendor v = getvendors.GetVendorbyName(p_vendor_name);
        return v;
    }
    
    public Vendor GetVendorByEmail(String p_email) {
        GetVendors get = new GetVendors();
        Vendor v = get.GetVendorbyEmail(p_email);
        return v;
    }
    
}
