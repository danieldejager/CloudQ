/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;
import disc.tiinfosec.businessobjects.CloudAssessment;
import disc.tiinfosec.datalayer.GetAllAssessmentStatus;
import java.util.ArrayList;
/**
 *
 * @author DANIEL112
 */
public class populateAssessmentStatus {
    
    public ArrayList<CloudAssessment> GetStatusTable() {
        GetAllAssessmentStatus getall = new GetAllAssessmentStatus();
        return getall.ReturnAllAssessmentStatusRecords();
    }
}
