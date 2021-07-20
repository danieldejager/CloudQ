/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;
import disc.tiinfosec.businessobjects.User;
import disc.tiinfosec.datalayer.AddNewVendorCredentials;

/**
 *
 * @author daniel112
 */
public class InsertNewUser {
    
    public void InsertNewUser(User p_user) {
        AddNewVendorCredentials creds = new AddNewVendorCredentials();
        creds.addUser(p_user);
    }
}
