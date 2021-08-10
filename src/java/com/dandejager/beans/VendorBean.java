/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.beans;

import disc.tiinfosec.businesslayer.PopulateVendorList;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import disc.tiinfosec.businessobjects.Vendor;
import java.io.Serializable;
/**
 *
 * @author daniel112
 */
@ManagedBean
@RequestScoped
public class VendorBean implements Serializable{
    
    private ArrayList<Vendor> list;
    private String idVendor;
    private String VendorName;
    private String CloudType;
    private String ContactPersonName;
    private String ContactPersonEmail;
    private String ContactPersonTelephone;
    
    @PostConstruct
    public void init() {
        try {
            PopulateVendorList getListObject = new PopulateVendorList();
            list = getListObject.RetrieveAllVendorData();
            System.out.println(list.size() + " in bean");
        } catch (Exception ex ) {
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<Vendor> getList() {
        return list;
    }

    public void setList(ArrayList<Vendor> list) {
        this.list = list;
    }

    public String getIdVendor() {
        return idVendor;
    }

    public void setIdVendor(String idVendor) {
        this.idVendor = idVendor;
    }

    public String getVendorName() {
        return VendorName;
    }

    public void setVendorName(String VendorName) {
        this.VendorName = VendorName;
    }

    public String getCloudType() {
        return CloudType;
    }

    public void setCloudType(String CloudType) {
        this.CloudType = CloudType;
    }

    public String getContactPersonName() {
        return ContactPersonName;
    }

    public void setContactPersonName(String ContactPersonName) {
        this.ContactPersonName = ContactPersonName;
    }

    public String getContactPersonEmail() {
        return ContactPersonEmail;
    }

    public void setContactPersonEmail(String ContactPersonEmail) {
        this.ContactPersonEmail = ContactPersonEmail;
    }

    public String getContactPersonTelephone() {
        return ContactPersonTelephone;
    }

    public void setContactPersonTelephone(String ContactPersonTelephone) {
        this.ContactPersonTelephone = ContactPersonTelephone;
    }
    
    
    
    
}
