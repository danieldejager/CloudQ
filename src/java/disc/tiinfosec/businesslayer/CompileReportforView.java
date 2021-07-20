/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businesslayer;

import disc.tiinfosec.businessobjects.AssessmentReport;
import disc.tiinfosec.businessobjects.CloudAssessment;
import disc.tiinfosec.businessobjects.MainReport;
import disc.tiinfosec.datalayer.GetAssessementReport;
import disc.tiinfosec.datalayer.GetFindings;

/**
 *
 * @author DANIEL112
 */
public class CompileReportforView {
    
    public MainReport compileScreenReport(CloudAssessment p_cloudassessment) {
        MainReport report = new MainReport();
        report.setCloudassessment(p_cloudassessment);
        System.out.println(p_cloudassessment.getVendorName());
        GetFindings findings = new GetFindings();
        report.setFindinglist(findings.GetFindingByCloudAssessmentId(p_cloudassessment.getCloudAssessmentId()));
        AssessmentReport p = new AssessmentReport();
        GetAssessementReport getter  = new GetAssessementReport();
        p = getter.GetAssessmentReportbyCloudAssessmentId(p_cloudassessment.getCloudAssessmentId());
        report.setReport(p);
        return report;
        
    }
    
}
