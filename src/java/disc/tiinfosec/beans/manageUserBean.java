/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.beans;

import disc.tiinfosec.businesslayer.UserAdministration;
import disc.tiinfosec.businessobjects.User;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author daniel112
 */
@ManagedBean
@RequestScoped
public class manageUserBean implements Serializable {
    private ArrayList<User> mainlist;
    private User selectedUser;
    
    private String analyst_username;
    //the system will generate a unique password
    
    @PostConstruct
    public void init() {
        UserAdministration admin = new UserAdministration();
        mainlist = admin.getArrayListUsers();
    }

    public ArrayList<User> getMainlist() {
        return mainlist;
    }

    public void setMainlist(ArrayList<User> mainlist) {
        this.mainlist = mainlist;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }
    
    
    
    
    
}
