/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.beans;

import java.util.Enumeration;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author daniel112
 */
@ManagedBean
@SessionScoped
public class sessionBean {
    
    private HttpSession session;
    private String sessionid;
    private String lastAccessedtime;
    private Enumeration<String> sesionobjects;
    
    @PostConstruct
    public void init() {
        session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        sessionid=session.getId();
        lastAccessedtime = String.valueOf(session.getLastAccessedTime());
        sesionobjects=session.getAttributeNames();
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    public String getLastAccessedtime() {
        return lastAccessedtime;
    }

    public void setLastAccessedtime(String lastAccessedtime) {
        this.lastAccessedtime = lastAccessedtime;
    }

    public Enumeration<String> getSesionobjects() {
        return sesionobjects;
    }

    public void setSesionobjects(Enumeration<String> sesionobjects) {
        this.sesionobjects = sesionobjects;
    }
    
    
    
    
    
    
    
    
}
