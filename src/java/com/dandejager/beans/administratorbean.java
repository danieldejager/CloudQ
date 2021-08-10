/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.beans;
import javax.faces.bean.*;
import javax.faces.context.*;
import javax.annotation.PostConstruct;
import disc.tiinfosec.security.*;
import javax.faces.application.FacesMessage;
import disc.tiinfosec.businesslayer.*;
import javax.servlet.http.HttpSession;

/**
 *
 * @author daniel112
 */
@ManagedBean
@SessionScoped 
public class administratorbean implements java.io.Serializable {

    private String user;
    private String role;
    private String password;
    private String oldPassword;
    private String repeatPassword;
    



    @PostConstruct
    public void init() {
        FacesContext c = FacesContext.getCurrentInstance();
        user = c.getExternalContext().getSessionMap().get("username").toString();
        role = c.getExternalContext().getSessionMap().get("role").toString();
    }

    public void processRegistrationManagementClick() {
    try {
        SessionUtils utils = new SessionUtils();
        role = utils.getRole();
        if ( role.equals("disc_admin")) {
            FacesContext c = FacesContext.getCurrentInstance();
            c.getExternalContext().redirect("administration-registrations.xhtml");
        }
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
    }
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public void changePassword() {
        boolean result = false;
        UpdateUserPassword up = new UpdateUserPassword();
        result = up.updatePassword(user, oldPassword, password, repeatPassword);
        if( result == true ) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Password Changed","Password Changed"));
            SessionUtils s = new SessionUtils();
            HttpSession session =s.getSession();
            session.invalidate();
            s.redirect("login.xhtml");
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Ensure all details match and are correct","Cannot change password"));
        }
    }
    
    
    
    
    
    
    
    














}
