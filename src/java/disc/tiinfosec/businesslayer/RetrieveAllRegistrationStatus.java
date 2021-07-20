/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;
import java.util.*;
import disc.tiinfosec.businessobjects.RegistrationStatus;
import disc.tiinfosec.datalayer.GetRegistrationStatus;
/**
 *
 * @author daniel112
 */
public class RetrieveAllRegistrationStatus {
    private  ArrayList<RegistrationStatus> list;

    public RetrieveAllRegistrationStatus(){};

    public  ArrayList<RegistrationStatus> getAllRegistrationStatus() {
        GetRegistrationStatus get = new GetRegistrationStatus();
        list = (ArrayList) get.getAllRegistrationStatus();
        return list;
    }
}
