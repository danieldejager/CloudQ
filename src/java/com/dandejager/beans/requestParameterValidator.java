/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.beans;

import disc.tiinfosec.businesslayer.ConfirmUserNameAndPassword;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import disc.tiinfosec.businesslayer.GetValidationCode;
import disc.tiinfosec.businessobjects.User;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import disc.tiinfosec.security.ValidateGoogleToken;
import javax.faces.application.FacesMessage;
import disc.tiinfosec.businesslayer.ValidateUserAccountForRegistration;
import disc.tiinfosec.businesslayer.activateNewUserPostValidaiton;
import disc.tiinfosec.utilities.MailManager;
 
/**
 *
 * @author DANIEL112
 */
@ManagedBean
@RequestScoped
public class requestParameterValidator {
    String validationCode;
    String validationResult;
    Map<String,String> requestHeader;
    String user;
    String password;
    
    @PostConstruct 
    public void init() {
    }

    public String getValidationResult() {
        return validationResult;
    }

    public void setValidationResult(String validationResult) {
        this.validationResult = validationResult;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

    public String getValidationCode() {
        return validationCode;
    }

    public void setValidationCode(String validationCode) {
        this.validationCode = validationCode;
    }

    public Map<String, String> getRequestHeader() {
        return requestHeader;
    }

    public void setRequestHeader(Map<String, String> requestHeader) {
        this.requestHeader = requestHeader;
    }
    
    private boolean isLegitCode(String p_validationCode) {
        boolean result=false;
        return result;
    }
    
    private boolean CheckToken(String p_token) {
        boolean result = false;
        System.out.println(p_token);
        GetValidationCode checker = new GetValidationCode();
        if (checker.ValidateRegistrationToken(p_token)) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
    
    
    public void handleVerification(ActionEvent e) {
        System.out.println(validationCode);
        System.out.println(user);
        System.out.println(password);
       try {
         //first determine if the validationcode is legit.
         if (validationCode.equals("") || validationCode == null) {
             System.out.println("Code is not known");
         } else { 
             System.out.println("Code is good");
         }
        if ( CheckToken(validationCode)) {
          
            //this means the code is fine, what about the captcha
            String g_capthaResponse = "";
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            g_capthaResponse = request.getParameter("g-recaptcha-response");
            if (verifyToken(g_capthaResponse)) {
                //lastly check if the account is active
                ValidateUserAccountForRegistration accountValidator = new ValidateUserAccountForRegistration();
                if(accountValidator.determineAccountStatus(validationCode)) { //this means the account is not active so all good
                  System.out.println("Ok, so here we have a legit user becuase the account is not active");
                    ConfirmUserNameAndPassword lastcheck = new ConfirmUserNameAndPassword();
                    if (!lastcheck.checkUserNameAndPassworD(user, password) ) {
                        //then you have a legit user and you can activate the account
                        //otherwise you have a fool and inform the system admin and redirect the fucker to another page.
                        System.out.println("Validated and Legit");
                        activateUserAccount(user, validationCode);
                        createCloudAssessment(user);
                        MailManager man = new MailManager();
                        man.sendEmailToAdmin("A vendor has sucessfully completed the registration : " + user + " validation code " + validationCode);
                        try {
                        FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                        
                        // remember to activate the account and redirect the user to the login page
                    } else {
                        System.out.println("This guy is trying he shouldn't or making a mistake");
                    }
                } else {
                    System.out.println("The account status is active so nothing to do");
                    FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
                }
            }
        }
    }catch (Exception ex) {
        System.out.println(ex.getMessage());
   }
    }
//}
    
    private boolean verifyToken(String p_captchaResponse) {
        ValidateGoogleToken validate = new ValidateGoogleToken();
        boolean result = false;
        result = validate.validateResponseToken(p_captchaResponse);
        return result; 
    }
    
    private void activateUserAccount(String p_usr, String p_registrationCode) {
          activateNewUserPostValidaiton activation = new activateNewUserPostValidaiton();
          activation.activateUser(p_usr, p_registrationCode);
    }

    private void createCloudAssessment(String p_user) {
          activateNewUserPostValidaiton go = new activateNewUserPostValidaiton();
          go.createCloudAssessmentRecord(p_user);
    }
    
    
    
    
    
}
