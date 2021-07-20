/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;
import disc.tiinfosec.businessobjects.Registration;
import disc.tiinfosec.businessobjects.Vendor;
import disc.tiinfosec.datalayer.InsertUpdateVendor;
import disc.tiinfosec.datalayer.UpdateRegistrationStatus;
import disc.tiinfosec.utilities.MailManager;

/**
 *
 * @author daniel112
 */
public class ChangeRegistrationStatus {
    
    public ChangeRegistrationStatus(){}
    
    public boolean UpdateRegistrationStatus(Registration p_registration) {
        //validate al important fields
        boolean result = false;
        ValidateRegistration validator = new ValidateRegistration();
        if ( validator.validateEmail(p_registration) && validator.validateMobile(p_registration) && !p_registration.getFirstName().equals("") && !p_registration.getLastName().equals("") && !p_registration.getCompanyName().equals("")) {
            UpdateRegistrationStatus update = new UpdateRegistrationStatus();
            //at this point we want to email the change/create a log entry and generate a unique id for the next time the person logs in
            //also we should be updating the vendor table at this point now that the registration has been approved
            update.UpdateRegStatus(p_registration);
            System.out.println("The update registration status now is " + p_registration.getRegistrationstatus());
            if ( p_registration.getRegistrationstatus().equals("Registered")) {
                Vendor v = new Vendor();
                v.setContactPersonEmail(p_registration.getEmail());
                v.setVendorName(p_registration.getCompanyName());
                v.setContactPersonTelephone(p_registration.getMobile());
                v.setContactPersonName(p_registration.getFirstName() + " " + p_registration.getLastName());
                if ( updateVendor(v) ) {
                    result = true;
                } else {
                    System.out.println("The vendor was not updated for some reason....check the logs");
                }
            }
        } else {
            result = false;
        }
        return result;
    }
    
    private boolean updateVendor(Vendor p_vendor) {
        boolean result = false;
        if (p_vendor!=null) {
            //so hy kom so ver
            InsertUpdateVendor upv = new InsertUpdateVendor();
            upv.InsertUpdateVendor(p_vendor);
            result = true;
            MailManager manager = new MailManager();
            manager.sendEmailToAdmin("Vendor Really Changed  - " + p_vendor.getVendorName());
        }
        return result;
    }
}
