/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;

import disc.tiinfosec.security.Authentication;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import disc.tiinfosec.datalayer.UpdatePassword;
import disc.tiinfosec.security.Crypto;

/**
 *
 * @author daniel112
 */
public class UpdateUserPassword {
    
    public boolean updatePassword(String p_user, String p_oldpassword, String p_newPassword, String p_repeatPassword) {
        try {
            boolean result = false;
            Authentication a = new Authentication();
            String outcome ="";
            outcome = a.updatePassword(p_oldpassword, p_newPassword, p_repeatPassword);
            if (outcome.equals("Passwords do not match")) {
                 result = false;
            } else if (outcome.equals("Valid User")) {
                 result = true;
            }
            System.out.println(outcome);
            return result;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
