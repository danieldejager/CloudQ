/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;
import java.util.*;
import disc.tiinfosec.datalayer.GetVendors;
import disc.tiinfosec.businessobjects.Vendor;

/**
 *
 * @author daniel112
 */
public class PopulateVendorList {
    
    public ArrayList<Vendor> RetrieveAllVendorData() {
        ArrayList<Vendor> v= new ArrayList<Vendor>();
        GetVendors  get = new GetVendors();
        v = get.GetAllVendors();
        System.out.println("Total " + v.size());
        return v;
        
    }
    
}
