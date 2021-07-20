/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;

import disc.tiinfosec.datalayer.*;
import disc.tiinfosec.businessobjects.User;
import disc.tiinfosec.businessobjects.UserCredential;
import disc.tiinfosec.security.Crypto;
/**
 *
 * @author daniel112
 */
public class ConfirmUserNameAndPassword {
    
    public boolean checkUserNameAndPassworD(String p_usr, String p_password) {
    try {
        boolean result = false;
        //first get the User object based on p_usr
        //once that is done, take the random field and convert to bytes
        //use the bytes and create UserCredential object
        //Using the cred object see if the passwords is match
        //if they do not match, then its a authentication failure
        //otherwise you have a legit user
        //UserCredential cred = Crypto.generateStrongPasswordHash(p_password, p_salt)
        GetUser g = new GetUser();
        User u = g.getUser(p_usr);
        if (u!= null || !u.getUsername().equals("")) {
            byte[] salt = u.getRandom().getBytes();
            UserCredential uc = Crypto.generateStrongPasswordHash(p_password, salt);
            if (u.getPassword().equals(uc.getLonghash())) {
                result = true;
            } else {
                result = false;
            }
        } else {
            result = false;
        }
        return result;
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
        return false;
    }
        
    }
}
