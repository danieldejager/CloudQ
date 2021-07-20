/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.security;
import disc.tiinfosec.businesslayer.*;
import disc.tiinfosec.datalayer.UpdatePassword;
import javax.faces.context.FacesContext;
import java.security.*;
import disc.tiinfosec.businessobjects.UserCredential;

/**
 *
 * @author DANIEL112
 */
public class Authentication {
    
    public Authentication() {
        
    }
    
    public String updatePassword(String p_oldPassword, String p_newpassword, String p_confirmPassword) {
    try {
        boolean isValid=false;
        boolean isMatch = false;
        String outcome="";
        System.out.println(p_oldPassword);
        System.out.println(p_newpassword);
        System.out.println(p_confirmPassword);
        ProcessUserCredentials p = new ProcessUserCredentials();
        SessionUtils session = new SessionUtils();
        String user = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username").toString();
        System.out.println("User Name is : " + user);
        if (!user.equals("") || user == null) {
            if (p.isValidHashedCredentials(user, p_oldPassword)) {
                outcome="Valid User";
                if (p_newpassword.equals(p_confirmPassword)) {
                    isMatch=true;
                    Crypto c = new Crypto();
                    byte[] salt = c.getSalt();
                    UserCredential uc = c.generateStrongPasswordHash(p_newpassword, salt);
                    uc.setUsername(user);
                    UpdatePassword dl = new UpdatePassword();
                    dl.updatePassword(uc);
                } else {
                    System.out.println("Passwords do not match");
                    return "Passwords do not match";
                }
            } else {
                outcome = "Invalid User";
            }
        }
        return outcome;
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
        return "Big Problem";
    }
    }
}
    
    
    
    

