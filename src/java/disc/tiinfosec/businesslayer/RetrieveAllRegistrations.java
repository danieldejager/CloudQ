/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;
import disc.tiinfosec.businessobjects.Registration;
import disc.tiinfosec.datalayer.GetAllRegistrations;
import java.util.*;
/**
 *
 * @author daniel112
 */
public class RetrieveAllRegistrations {

    public RetrieveAllRegistrations(){};

    public  ArrayList<Registration> getAllRegistrations() {
        GetAllRegistrations get = new GetAllRegistrations();
        ArrayList e = (ArrayList) get.GetAllRegistrations();
        return e;
    }

}
