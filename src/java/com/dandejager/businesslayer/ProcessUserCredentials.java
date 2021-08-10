/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;
import disc.tiinfosec.datalayer.*;
import disc.tiinfosec.businessobjects.*;
import disc.tiinfosec.security.Crypto;

/**
 *
 * @author daniel112
 */
public class ProcessUserCredentials {

    public ProcessUserCredentials() {};

//    public boolean isValidCredentials(String p_user, String p_pwd) {
//       boolean result = false;
//       GetUser get = new GetUser();
//        User user = get.getUser(p_user, p_pwd);
//            if (user != null && !user.getRole().equals("")) {
//                result = true;
//            } else {
//                result = false;
//            }
//            return result;
//    }
    
    public boolean isValidHashedCredentials(String p_user, String p_pwd){
     try {   
        boolean result = false;
        GetUserCredentials get = new GetUserCredentials();
        UserCredential uc = get.GetSingleUserCredential(p_user);
        if (get.isEnabledAccount(p_user)) {
        Crypto c = new Crypto();
        if ( c.validatePassword(p_pwd, uc.getLonghash(), uc.getSalt()) && uc.getActivationStatus().equals("active")) {
            System.out.println("Passwords Match..the user can proceed");
            result = true;
        } else {
            System.out.println("Passwords do not match and cannot proceed..add a FacesMessage");
            result = false;
        }
        
        return result;
        } else {
            return false;
        }
                
     } catch (Exception ex) {
         System.out.println(ex.getMessage());
         return false;
     }
    }
    
    

    public String getRole(String p_usr) {
        String role = "none";
        GetUser get = new GetUser();
        User user = get.getUser(p_usr);
        role = user.getRole();
        return role;
    }
}
