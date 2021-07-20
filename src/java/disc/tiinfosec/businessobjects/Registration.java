/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businessobjects;
import java.io.Serializable;
/**
 *
 * @author daniel112
 */
public class Registration implements Serializable {

    private String RegistrationID;
    private String FirstName;
    private String LastName;
    private String mobile;
    private String email;
    private String companyName;
    private String registrationstatus;
    private String token;
    private String activationStatus;
    private String registrationId;
    private String assignRegistration;

    public String getRegistrationID() {
        return RegistrationID;
    }

    public void setRegistrationID(String RegistrationID) {
        this.RegistrationID = RegistrationID;
    }

    
    public String getAssignRegistration() {
        return assignRegistration;
    }

    public void setAssignRegistration(String assignRegistration) {
        this.assignRegistration = assignRegistration;
    }

    
    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }
    
    

    public String getActivationStatus() {
        return activationStatus;
    }

    public void setActivationStatus(String activationStatus) {
        this.activationStatus = activationStatus;
    }

    
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRegistrationstatus() {
        return registrationstatus;
    }

    public void setRegistrationstatus(String registrationstatus) {
        this.registrationstatus = registrationstatus;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    






}
