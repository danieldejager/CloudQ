/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;
import disc.tiinfosec.datalayer.GetReportedCloudAssessments;
import disc.tiinfosec.businessobjects.CloudAssessment;
import java.util.*;
/**
 *
 * @author daniel112
 */
public class generateReports {
    
    public ArrayList<CloudAssessment> getReportList() {
        GetReportedCloudAssessments getter = new GetReportedCloudAssessments();
        return getter.GetReportedCloudAssessments();
    }
    
}
