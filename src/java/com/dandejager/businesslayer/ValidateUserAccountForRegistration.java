/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;
import disc.tiinfosec.businessobjects.User;
import disc.tiinfosec.datalayer.GetUserBytOken;
/**
 *
 * @author daniel112
 */
public class ValidateUserAccountForRegistration {
    
    public boolean determineAccountStatus(String p_token) {
        boolean result = true;
                GetUserBytOken get = new GetUserBytOken();
                User temp = get.getUserStatusByToken(p_token);
                if ( temp.getStatus().equals("active")) {
                    result = false;
                } else {
                    result = true;
                }
                    return result;
    }
}
