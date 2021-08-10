/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.beans;
import javax.faces.bean.*;
import java.util.*;
import disc.tiinfosec.businessobjects.*;
import disc.tiinfosec.businesslayer.*;
import javax.annotation.PostConstruct;
import disc.tiinfosec.security.SessionUtils;
import disc.tiinfosec.utilities.MailManager;
import javax.faces.context.*;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import org.primefaces.event.*;

/**
 *
 * @author daniel112
 */
@ManagedBean
@SessionScoped
public class registrationadminbean implements Serializable {
    private ArrayList<Registration> list;
    private Registration selectedRegistration;
    

    private String firstName;
    private String lastName;
    private String mobile;
    private String company;
    private String email;
    private String regstatus;
    private String assignregistration;
    
    @ManagedProperty("#{registrationservice}")
    private RetrieveAllRegistrations get;

    @PostConstruct
    public void init() {
    try {
        SessionUtils util = new SessionUtils();
        String role = util.getRole();
        if (!role.equals("disc_admin")) {
            System.out.println("SEVERE: Incorrect role found on administration pages");
            FacesContext c = FacesContext.getCurrentInstance();
            c.getExternalContext().redirect("error.xhtml");
        } else {
            System.out.println("INFO: disc_admin is performing administration on registration : " + util.getUserName());
            get = new RetrieveAllRegistrations();
            list = get.getAllRegistrations();
        }
    } catch (Exception ex ) {
        System.out.println(ex.getMessage());
    }

    }

    public ArrayList<Registration> getList() {
        RetrieveAllRegistrations get = new RetrieveAllRegistrations();
        return get.getAllRegistrations();
    }

    public String getAssignregistration() {
        return assignregistration;
    }

    public void setAssignregistration(String assignregistration) {
        this.assignregistration = assignregistration;
    }

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void setList(ArrayList<Registration> list) {
        this.list = list;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRegstatus() {
        return regstatus;
    }

    public void setRegstatus(String regstatus) {
        this.regstatus = regstatus;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public RetrieveAllRegistrations getGet() {
        return get;
    }

    public void setGet(RetrieveAllRegistrations get) {
        this.get = get;
    }

    public Registration getSelectedRegistration() {
        return selectedRegistration;
    }

    public void setSelectedRegistration(Registration selectedRegistration) {
        this.selectedRegistration = selectedRegistration;
    }
    
    public void OnCellEdit(CellEditEvent event) {
        Object oldValue=event.getOldValue();
        Object newValue=event.getNewValue();
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Cell Changed","Old: " + oldValue + ", New : " + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    //Carry on from here.
    public void onRowEdit(RowEditEvent event) {
        try {
        FacesMessage msg = new FacesMessage("Registration Edited");
        Registration reg = (Registration) event.getObject();
        reg.setRegistrationstatus(regstatus);
        reg.setAssignRegistration(assignregistration);
        ChangeRegistrationStatus change= new ChangeRegistrationStatus();
        boolean result = change.UpdateRegistrationStatus(reg);
        System.out.println("Going into the routine to send the email");
        if (regstatus.equals("Registered")) {
            //get the token
            Registration reg2 = new Registration();
            GetRegistration get = new GetRegistration();
            reg2 = get.getRegistrationbyRegistrationCompanyNameAndEmail(reg);
            System.out.println("Got the registration");
            //send a mail with the link and the code
            MailManager man = new MailManager();
            man.sendEmailToVendor("Hi " + reg.getFirstName() + ",you have successfully registered on our Quesionaire Site. Login to http://dfn03508:9999/InfoSec.WebApp.CloudQ/faces/registrationConfirmationValidate.xhtml and use the following confirmation code " + reg2.getToken(), reg.getEmail() + " in order to complete the registration process");
            System.out.println("Mail should have sent");
        }
        
        if ( result == true ) {
            get = new RetrieveAllRegistrations();
            list = get.getAllRegistrations();
            FacesContext.getCurrentInstance().addMessage(null, msg);
            FacesContext.getCurrentInstance().getExternalContext().redirect("administration-registrations.xhtml");
        } else {
            FacesMessage msg2 = new FacesMessage("Change Failure");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        } catch (Exception ex) {
                System.out.println(ex.getMessage());
        }
    }
    
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Registration) event.getObject()).toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
}
