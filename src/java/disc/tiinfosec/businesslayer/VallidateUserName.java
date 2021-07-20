/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;
import disc.tiinfosec.datalayer.GetUserByUserName;
import disc.tiinfosec.businessobjects.User;

/**
 *
 * @author DANIEL112
 */
public class VallidateUserName {
    
    public boolean isValidUser(String p_username) {
        System.out.println("Entering this method");
        GetUserByUserName getter = new GetUserByUserName();
        boolean result = false;
        User storedUser = new User();
        System.out.println("Assigning value to storedUserObject");
        storedUser = getter.getUser(p_username);
        System.out.println("Entering if statements");
        System.out.println(storedUser.getUsername());
        System.out.println(p_username);
            if(storedUser.getUsername() == null ? p_username == null : storedUser.getUsername().equals(p_username)) {
                System.out.println("The user already exists");
                result = false;
            } else {
                System.out.println("The user does not exist");
                result = true;
            }
         
        return result;
    }
}
