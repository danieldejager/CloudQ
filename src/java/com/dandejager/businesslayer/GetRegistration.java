/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;
import disc.tiinfosec.datalayer.GetRegistrationByRegistrationCompanyNameAndEmail;
import disc.tiinfosec.businessobjects.Registration;
import disc.tiinfosec.datalayer.GetRegistrationByUserId;
/**
 *
 * @author daniel112
 */
public class GetRegistration {
    
    public Registration getRegistrationbyRegistrationCompanyNameAndEmail(Registration p_registration) {
        Registration toReturn;
        GetRegistrationByRegistrationCompanyNameAndEmail dl = new GetRegistrationByRegistrationCompanyNameAndEmail();
        toReturn = dl.getRegistration(p_registration);
        return toReturn;
    }
    
    public Registration getRegistrationByUserId(String p_userid) {
        Registration toReturn;
        //dis ' nendless loop idiot
        GetRegistrationByUserId get = new GetRegistrationByUserId();
        toReturn  = get.GetRegbyUserId(p_userid);
        return toReturn;
    }
}
