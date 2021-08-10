/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businessobjects;

/**
 *
 * @author daniel112
 */
public class Vendor {
    private String IdVendor;
    private String VendorName;
    private String CloudType;
    private String ContactPersonName;
    private String ContactPersonEmail;
    private String ContactPersonTelephone;

    /**
     *
     */
    public Vendor() {}

    /**
     * 
     * @param p_idVendor
     * @param p_vendorName
     * @param p_CloudType
     * @param p_ContactPersonName
     * @param p_contactPersonMail
     * @param p_ContactPersonTelephone
     */
    public Vendor(String p_idVendor,String p_vendorName, String p_CloudType, String p_ContactPersonName, String p_contactPersonMail, String p_ContactPersonTelephone )
    {
        this.IdVendor = p_idVendor;
        this.VendorName = p_vendorName;
        this.CloudType = p_CloudType;
        this.ContactPersonName = p_ContactPersonName;
        this.ContactPersonEmail = p_contactPersonMail;
        this.ContactPersonTelephone = p_ContactPersonTelephone;
    }


    /**
     *
     * @return
     */
    public String getCloudType() {
        return CloudType;
    }
    /**
     *
     * @param CloudType
     */
    public void setCloudType(String CloudType) {
        this.CloudType = CloudType;
    }
    /**
     *
     * @return
     */
    public String getContactPersonEmail() {
        return ContactPersonEmail;
    }
    /**
     *
     * @param ContactPersonEmail
     */
    public void setContactPersonEmail(String ContactPersonEmail) {
        this.ContactPersonEmail = ContactPersonEmail;
    }
    /**
     *
     * @return
     */
    public String getContactPersonName() {
        return ContactPersonName;
    }
    /**
     *
     * @param ContactPersonName
     */
    public void setContactPersonName(String ContactPersonName) {
        this.ContactPersonName = ContactPersonName;
    }
    /**
     *
     * @return
     */
    public String getContactPersonTelephone() {
        return ContactPersonTelephone;
    }
    /**
     *
     * @param ContactPersonTelephone
     */
    public void setContactPersonTelephone(String ContactPersonTelephone) {
        this.ContactPersonTelephone = ContactPersonTelephone;
    }
    /**
     *
     * @return
     */
    public String getIdVendor() {
        return IdVendor;
    }
    /**
     *
     * @param IdVendor
     */
    public void setIdVendor(String IdVendor) {
        this.IdVendor = IdVendor;
    }
    /**
     *
     * @return
     */
    public String getVendorName() {
        return VendorName;
    }
    /**
     *
     * @param VendorName
     */
    public void setVendorName(String VendorName) {
        this.VendorName = VendorName;
    }
}
