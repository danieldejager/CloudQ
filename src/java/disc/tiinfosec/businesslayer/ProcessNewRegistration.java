/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;
import disc.tiinfosec.datalayer.*;
import disc.tiinfosec.businessobjects.*;
/**
 *
 * @author daniel112
 */
public class ProcessNewRegistration {

    public ProcessNewRegistration(){};

    public  void processNewRegistration(Registration p_registration) {
        InsertNewRegistration ins = new InsertNewRegistration();
        ins.addNewRegistration(p_registration);
    }

}
