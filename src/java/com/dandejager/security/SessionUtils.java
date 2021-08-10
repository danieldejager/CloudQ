/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.security;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 *
 * @author daniel112
 */
public class SessionUtils {

    public  HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    }

    public  HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }

    public  String getUserName() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session != null) {
            return (String) session.getAttribute("user");
        } else {
            return null;
        }
    }

    public  String getRole() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if ( session != null ) {
            return (String) session.getAttribute("role");
        } else {
            return null;
        }
    }
    
    public void redirect(String p_uri) {
    try {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().redirect(p_uri);
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
    }
    }
    
    public boolean hasValidSession() {
        try {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            if(session!=null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

}
