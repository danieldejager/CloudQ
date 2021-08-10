/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;

import disc.tiinfosec.businessobjects.User;
import disc.tiinfosec.datalayer.GetAllUsers;
import java.util.ArrayList;

/**
 *
 * @author daniel112
 */
public class UserAdministration {
    
    public ArrayList<User> getArrayListUsers() {
        GetAllUsers getter = new GetAllUsers();
        return getter.GetAllUsers();
    }
    
}
