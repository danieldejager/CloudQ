/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.beans;
import javax.faces.context.*;
import javax.faces.bean.*;
import disc.tiinfosec.businessobjects.*;
import disc.tiinfosec.businesslayer.*;
import disc.tiinfosec.businesslayer.InsertNewUser;
import disc.tiinfosec.security.TokenGenerator;
import disc.tiinfosec.utilities.MailManager;
import javax.faces.application.FacesMessage;
 
/**
 *
 * @author daniel112
 */
@ManagedBean
@RequestScoped
public class main {

    private Registration reg;
    private String FName;
    private String LName;
    private String Email;
    private String CompanyName;
    private String mobile;
    private String UserName;
    private String Password;

    public void processLoginClick() {
    try {
            FacesContext c = FacesContext.getCurrentInstance();
            c.getApplication().getNavigationHandler().handleNavigation(c, null, "login.xhtml");
        } catch ( Exception ex ) {
            System.out.println(ex.getMessage());
    }
    }

    /**
     * Processes the registration action
     * Still need to perform validation of the action. Only by clicking the button must you be redirected
     */
    public void processRegistration() {
    try {
        System.out.println("Processing Registration");
        FacesContext c = FacesContext.getCurrentInstance();
        c.getApplication().getNavigationHandler().handleNavigation(c, null, "register.xhtml");
    } catch (Exception ex) {
            System.out.println(ex.getMessage());
    }
    }

    public String processActualRegistration() {
    try {
        //before you commit the registration, first check if the username is unique
        FacesContext c = FacesContext.getCurrentInstance();
        if(testUser()) {
               Registration reg = new Registration();
               
               reg.setFirstName(FName);
               reg.setLastName(LName);
               reg.setEmail(Email);
               reg.setCompanyName(CompanyName);
               reg.setMobile(mobile);
               ValidateRegistration validator = new ValidateRegistration();
               if ( validator.validateEmail(reg) && validator.validateMobile(reg) && !reg.getFirstName().equals("") && !reg.getLastName().equals("") && !reg.getCompanyName().equals("")) {
                       
                       //send an email to the admin here
                       MailManager manager = new MailManager();
                       manager.sendEmailToAdmin("A new user has registered " + reg.getEmail() + " " + reg.getFirstName());
                       //generate a unique code store this in the database and send an email to the user
                       TokenGenerator generator = new TokenGenerator();
                       String token = generator.GenerateToken();
                       System.out.println(token);
                       reg.setToken(token);
                       reg.setActivationStatus("Disabled");
                       //store the registration
                       ProcessNewRegistration proc = new ProcessNewRegistration();
                               proc.processNewRegistration(reg);
                               
                       CreateNewUser(reg);
                       c.getExternalContext().redirect("thankyou.xhtml");
                       return "thankyou";
               } else {
                   System.out.println("Nope, some issues");

                   c.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Validation failed on Email or Mobile Number","Please rectify email or mobile number"));
                   return "error";
               }
        } else {
             c.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"That username is not available","Please use a different user name"));
             return "error";
        }
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
        return "";
    }

    }
    
    /**
     * Ajax function to test if the user exists or not
     * @param username
     */
    public boolean testUser(){
        VallidateUserName validator = new VallidateUserName();
        return validator.isValidUser(UserName);
    }
    
    private void CreateNewUser(Registration p_registration) {
        Registration reg = new Registration();
        GetRegistration get = new GetRegistration();
        System.out.println("trying to  get the registration");
        reg = get.getRegistrationbyRegistrationCompanyNameAndEmail(p_registration);
        System.out.println("Ok got the registration");
        if ( !reg.getRegistrationId().equals("") || reg != null ) {
            User usr = new User();
            usr.setUsername(UserName);
            usr.setPassword(Password);
            usr.setRole("vendor");
            usr.setStatus("inactive");
            usr.setRegistrationId(reg.getRegistrationId());
            InsertNewUser insert = new InsertNewUser();
            insert.InsertNewUser(usr);
        }
    }
    
    private void AddMetaRegistrationInformation(Registration reg) {
        //add user to database and set activation to "deactivated" 
        //make sure the login process also checks thte activation status before allowing to log in. 
    }

    public void processReturnToIndex() {
        try {
            FacesContext c = FacesContext.getCurrentInstance();
            c.getApplication().getNavigationHandler().handleNavigation(c, null, "login.xhtml");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }



    /**
     * bean variables for the registration form
     */

    public void RegisterUser() {
        try {
            reg = new Registration();
            reg.setFirstName(FName);
            reg.setLastName(LName);
            reg.setCompanyName(CompanyName);
            reg.setEmail(Email);
            reg.setMobile(mobile);
            ValidateRegistration validator = new ValidateRegistration();
            boolean legitmail = validator.validateEmail(reg);
            if ( legitmail == false ) {
                System.out.println("Not a legitimate Email");
                FacesContext c = FacesContext.getCurrentInstance();
                FacesMessage m = new FacesMessage("Invalid Email", "The email provided is not correct");
                c.addMessage(null, m);
            } else {
                FacesContext c = FacesContext.getCurrentInstance();
                c.getApplication().getNavigationHandler().handleNavigation(c, null, "mainpage.xhtml");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}



