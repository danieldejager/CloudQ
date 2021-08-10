/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;
import disc.tiinfosec.businessobjects.Registration;
import java.util.regex.*;
/**
 *
 * @author daniel112
 */
public class ValidateRegistration {

    public ValidateRegistration(){};

    public  boolean validateEmail(Registration p_registration) {
        //first validate the email.
        boolean result = false;
        String mail_regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(mail_regex);
        Matcher matcher = pattern.matcher(p_registration.getEmail());
        result  = matcher.matches();
        return result;
    }

    public  boolean validateMobile(Registration p_registration) {
        boolean result = false;
        String mobile_regex = "^\\d{10}|^(\\(\\d{3}\\)\\s?)?\\d{3}-\\d{4}$|^\\d{3}([.-])\\d{3}\\2\\d{4}$";
        Pattern pattern = Pattern.compile(mobile_regex);
        Matcher matcher = pattern.matcher(p_registration.getMobile());
        result = matcher.matches();
        return result;
    }
}
