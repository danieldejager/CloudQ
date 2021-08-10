/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;

import disc.tiinfosec.businessobjects.CloudType;
import disc.tiinfosec.datalayer.GetAllCloudType;
import java.util.ArrayList;

/**
 *
 * @author daniel112
 */
public class PopulateQuestionaire {
    
    public ArrayList<CloudType> RetrieveCloudTypes() {
        GetAllCloudType getTypes = new GetAllCloudType();
        return getTypes.RetrieveAllCloudTypes();
    }
    
}
