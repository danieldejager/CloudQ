/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.beans;
import javax.faces.bean.*;
import disc.tiinfosec.businesslayer.*;
import disc.tiinfosec.businessobjects.CloudAssessment;
import disc.tiinfosec.datalayer.InsertUpdateCloudAssessment;
import disc.tiinfosec.security.SessionUtils;
import javax.faces.context.*;
import disc.tiinfosec.security.SessionUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

/**
 *
 * @author daniel112
 */
@ManagedBean
@SessionScoped
public class loginbean {

    private String username;
    private String password;
    private String message;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    public String processLoginClick() {
    String choice;
    try {
             ProcessUserCredentials p = new ProcessUserCredentials();
             if (p.isValidHashedCredentials(username, password)) {
                 SessionUtils util = new SessionUtils();
                 HttpSession session = util.getSession();
                 session.setAttribute("username",  username);
                 System.out.println("username as in the session object is " + session.getAttribute("username"));
                 if(p.getRole(username).equals("disc_admin")) {
                     session.setAttribute("role", "disc_admin");
                     return "administration";
                 } else if (p.getRole(username).equals("vendor")) {
                     session.setAttribute("role", "vendor");
                     CloudAssessment retrieveAssessment = new CloudAssessment();
                     RetrieveCloudAssessment getter = new RetrieveCloudAssessment();
                     retrieveAssessment = getter.RetrieveCloudAssessmentStatus(username);
                     System.out.println(retrieveAssessment.getRegistrationId() + "+++++++++"); 
                     if (retrieveAssessment == null ) {
                         System.out.println("Assessment Object is null");
                         FacesContext.getCurrentInstance().getExternalContext().redirect("vendormainpage.xhtml");
                     } else  {
                         choice = retrieveAssessment.getNextStep();
                         System.out.println(choice);
                         if (choice.equals("HighLevelDescription")) {
                              
                                 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                                 Date date = new Date();
                                 System.out.println(dateFormat.format(date));
                                 retrieveAssessment.setStartDate(dateFormat.format(date));
                                 InsertUpdateCloudAssessment update = new InsertUpdateCloudAssessment();
                                 System.out.println("attempting to change the start date");
                                 update.UpdateCloudAssessmentStartDate(retrieveAssessment);
                                 FacesContext.getCurrentInstance().getExternalContext().redirect("answerdetailquestions.xhtml");
                            
                                 
                             
                         } else if (choice.equals("detailquestions")) {
                             FacesContext.getCurrentInstance().getExternalContext().redirect("AssessmentAnswers.xhtml");
                         }
                         
                         
                     }
                     
                      
                      return "";
                 } else {
                      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"No role exists","Contact the administrator"));
                      return "login";
                 }
             } else {
                 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Incorrect Username or Password","Please enter correct credentials"));
                 return "login";
             }
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
        return "login";
    }
    }
    
    public void processChangePassword(){
      FacesContext context = FacesContext.getCurrentInstance();
      SessionUtils util = new SessionUtils();
      HttpSession session = util.getSession();
      System.out.println(session.getAttribute("username"));
      System.out.println("Changing Password");
      System.out.println(session.getAttribute("role"));
      System.out.println("Redirecting user to page");
      util.redirect("administration-passwords.xhtml");
    }

    public String logout() {
        SessionUtils util = new SessionUtils(); 
        HttpSession session = util.getSession();
        System.out.println(session.getAttributeNames());
        System.out.println(session.getCreationTime());
        System.out.println(session.getId());
        session.invalidate();
        return "login";
    }
}
