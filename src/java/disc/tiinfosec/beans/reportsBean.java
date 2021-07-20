/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.beans;

import disc.tiinfosec.businesslayer.PostAssessment;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author DANIEL112
 */
@ManagedBean
@RequestScoped
public class reportsBean implements Serializable {
    
    private int totalCloudAssessmentsPerformed;
    private int totalCompletedCloudAssessments; 
    private int totalNotCompletedCloudAssessments;
    private int totalReportedCloudAssessments;
    
    private int ressilience;
    private int juristiction;
    private int disasterrecovery;
    private int confidentiality;
    private int policy;
    private int auditing;
    private int authentication;
    private int availability;
    private int frameworks;
    private int securedesign;
    
    @PostConstruct
    public void init() {
    try {    
        PostAssessment p = new PostAssessment();
        totalCloudAssessmentsPerformed = p.getTotalCloudAssessments();
        totalCompletedCloudAssessments = p.getTotalCompletedCloudAssessments();
        totalReportedCloudAssessments = p.getTotalCompletedWithReports();
        totalNotCompletedCloudAssessments = totalCloudAssessmentsPerformed - totalCompletedCloudAssessments;
        
        ressilience = p.getCountRiskCategory("Resillience");
        System.out.println(ressilience);
        juristiction = p.getCountRiskCategory("Juristiction");
        System.out.println(juristiction);
        disasterrecovery = p.getCountRiskCategory("Disaster Recovery");
        System.out.println(disasterrecovery);
        confidentiality = p.getCountRiskCategory("Confidentiality");
        System.out.println(confidentiality);
        
        policy = p.getCountRiskCategory("Policy");
        System.out.println(policy);
        auditing = p.getCountRiskCategory("Auditing");
        System.out.println(auditing);
        authentication = p.getCountRiskCategory("Authentication");
        System.out.println(authentication);
        
        availability = p.getCountRiskCategory("Availability");
        System.out.println(availability);
        frameworks = p.getCountRiskCategory("Frameworks");
        System.out.println(frameworks);
        securedesign = p.getCountRiskCategory("Secure Design");
        System.out.println(securedesign);
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
    }          
    }

    public int getRessilience() {
        return ressilience;
    }

    public void setRessilience(int ressilience) {
        this.ressilience = ressilience;
    }

    public int getJuristiction() {
        return juristiction;
    }

    public void setJuristiction(int juristiction) {
        this.juristiction = juristiction;
    }

    public int getDisasterrecovery() {
        return disasterrecovery;
    }

    public void setDisasterrecovery(int disasterrecovery) {
        this.disasterrecovery = disasterrecovery;
    }

    public int getConfidentiality() {
        return confidentiality;
    }

    public void setConfidentiality(int confidentiality) {
        this.confidentiality = confidentiality;
    }

    public int getPolicy() {
        return policy;
    }

    public void setPolicy(int policy) {
        this.policy = policy;
    }

    public int getAuditing() {
        return auditing;
    }

    public void setAuditing(int auditing) {
        this.auditing = auditing;
    }

    public int getAuthentication() {
        return authentication;
    }

    public void setAuthentication(int authentication) {
        this.authentication = authentication;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public int getFrameworks() {
        return frameworks;
    }

    public void setFrameworks(int frameworks) {
        this.frameworks = frameworks;
    }

    public int getSecuredesign() {
        return securedesign;
    }

    public void setSecuredesign(int securedesign) {
        this.securedesign = securedesign;
    }
    
    

    public int getTotalNotCompletedCloudAssessments() {
        return totalNotCompletedCloudAssessments;
    }

    public void setTotalNotCompletedCloudAssessments(int totalNotCompletedCloudAssessments) {
        this.totalNotCompletedCloudAssessments = totalNotCompletedCloudAssessments;
    }
    
    

    public int getTotalCompletedCloudAssessments() {
        return totalCompletedCloudAssessments;
    }

    public void setTotalCompletedCloudAssessments(int totalCompletedCloudAssessments) {
        this.totalCompletedCloudAssessments = totalCompletedCloudAssessments;
    }
    
    

    public int getTotalCloudAssessmentsPerformed() {
        return totalCloudAssessmentsPerformed;
    }

    public void setTotalCloudAssessmentsPerformed(int totalCloudAssessmentsPerformed) {
        this.totalCloudAssessmentsPerformed = totalCloudAssessmentsPerformed;
    }

    public int getTotalReportedCloudAssessments() {
        return totalReportedCloudAssessments;
    }

    public void setTotalReportedCloudAssessments(int totalReportedCloudAssessments) {
        this.totalReportedCloudAssessments = totalReportedCloudAssessments;
    }
    
    
    
    
    
    
    
    
}
