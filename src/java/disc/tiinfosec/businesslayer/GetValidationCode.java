/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;
import disc.tiinfosec.datalayer.GetRegistrationToken;
/**
 *
 * @author DANIEL112
 */
public class GetValidationCode {
    //comment
    public boolean ValidateRegistrationToken(String p_token) {
        boolean result = false;
        GetRegistrationToken checker = new GetRegistrationToken();
        if (checker.ReturnRegistrationToken(p_token).equals("invalid")) {
            result=false;
        } else { 
            result = true;
        }
        return result;
    }
}
