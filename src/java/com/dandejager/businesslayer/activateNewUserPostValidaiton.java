/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;
import disc.tiinfosec.businessobjects.CloudAssessment;
import disc.tiinfosec.businessobjects.Registration;
import disc.tiinfosec.businessobjects.Vendor;
import disc.tiinfosec.datalayer.GetVendors;
import disc.tiinfosec.datalayer.InsertUpdateCloudAssessment;
import disc.tiinfosec.datalayer.InsertUpdateUser;
import disc.tiinfosec.datalayer.UpdateRegistrationStatus;
/**
 *
 * @author daniel112
 */
public class activateNewUserPostValidaiton {
    
    public void activateUser(String p_usr, String p_registrationCode) {
        if (!p_usr.equals("") || !p_registrationCode.equals("")) {
            InsertUpdateUser updateUser = new InsertUpdateUser();
            updateUser.activateUserAccount(p_usr);
            UpdateRegistrationStatus updateRegistration = new UpdateRegistrationStatus();
            updateRegistration.activateRegistration(p_registrationCode);
        }
    }
    
    public void createCloudAssessmentRecord(String p_user) {
        Registration reg = new Registration();
        GetRegIdFromUsers get  = new GetRegIdFromUsers();
        System.out.println("**************");
        System.out.println(get.ReturnRegistrationIdbyUserName(p_user));
        System.out.println("***************");
        reg.setRegistrationID(get.ReturnRegistrationIdbyUserName(p_user));
        GetRegistration getReg = new GetRegistration();
        reg = getReg.getRegistrationByUserId(p_user);
        Vendor vendor = new Vendor();
        disc.tiinfosec.datalayer.GetVendors v = new GetVendors();
        vendor = v.GetVendorbyEmail(reg.getEmail());
        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println(vendor.getVendorName());
        System.out.println("++++++++++++++++++++++++++++++++++");
        CloudAssessment ca = new CloudAssessment();
        ca.setRegistrationId(get.ReturnRegistrationIdbyUserName(p_user));
        ca.setCloudType("Standard Cloud");
        ca.setUserName(p_user);
        ca.setVendorName(vendor.getVendorName());
        ca.setProcessStep("start");
        ca.setNextStep("HighLevelDescription");
        ca.setStatus("start");
        InsertUpdateCloudAssessment update = new InsertUpdateCloudAssessment();
        update.InsertCloudAssessment(ca);
    }
}
