/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.beans;
import disc.tiinfosec.businesslayer.PostAssessment;
import disc.tiinfosec.businessobjects.Category;
import disc.tiinfosec.businessobjects.Finding;
import disc.tiinfosec.businessobjects.QuestionCategory;
import disc.tiinfosec.businessobjects.Severity;
import java.io.Serializable;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author DANIEL112
 */
@ManagedBean
@ViewScoped
public class findingsBean implements Serializable{
    
    private ArrayList<Finding> mainlist;
    private ArrayList<Finding> filteredList;
    private ArrayList<Severity> sevlist;
    private ArrayList<QuestionCategory> catlist;
    
    private int totalCritical;
    private int totalHigh;
    private int totalMedium;
    private int totalLow;
    
    
    private String selectionMade;
    
    
    private int jur_C;
    private int jur_H;
    private int jur_M;
    private int jur_L;
    
    private int pol_C;
    private int pol_H;
    private int pol_M;
    private int pol_L;
    
    private int conf_C;
    private int conf_H;
    private int conf_M;
    private int conf_L;
    
    private int avail_C;
    private int avail_H;
    private int avail_M;
    private int avail_L;
    
    private int res_C;
    private int res_H;
    private int res_M;
    private int res_L;
    
    private int auth_C;
    private int auth_H;
    private int auth_M;
    private int auth_L;
    
    private int secd_C;
    private int secd_H;
    private int secd_M;
    private int secd_L;
    
    private int fram_C;
    private int fram_H;
    private int fram_M;
    private int fram_L;
    
    private int aud_C;
    private int aud_H;
    private int aud_M;
    private int aud_L;
    
    private int disas_C;
    private int disas_H;
    private int disas_M;
    private int disas_L;
    
    
    
    
    
    @PostConstruct
    public void init() {
        PostAssessment obj = new PostAssessment();
        mainlist = obj.displayAllFindings();
        totalCritical = obj.getTotalCriticalFindings();
        totalMedium = obj.getTotalMediumFindings();
        totalHigh = obj.getTotalHighFindings();
        totalLow = obj.getTotalLowFindings();
        
        jur_C = obj.getCountCategoryAndSeverity("Juristiction", "Critical");
        jur_H = obj.getCountCategoryAndSeverity("Juristiction", "High");
        jur_H = obj.getCountCategoryAndSeverity("Juristiction", "Medium");
        jur_H = obj.getCountCategoryAndSeverity("Juristiction", "Low");
        
        pol_C = obj.getCountCategoryAndSeverity("Policy", "Critical");
        pol_H = obj.getCountCategoryAndSeverity("Policy", "High");
        pol_M = obj.getCountCategoryAndSeverity("Policy", "Medium");
        pol_L = obj.getCountCategoryAndSeverity("Policy", "Low"); 
        
        conf_C = obj.getCountCategoryAndSeverity("Confidentiality","Critical");
        conf_H = obj.getCountCategoryAndSeverity("Confidentiality","High");
        conf_M = obj.getCountCategoryAndSeverity("Confidentiality","Medium");
        conf_L = obj.getCountCategoryAndSeverity("Confidentiality","Low");
        
        avail_C = obj.getCountCategoryAndSeverity("Availability", "Critical");
        avail_H = obj.getCountCategoryAndSeverity("Availability", "High");
        avail_M = obj.getCountCategoryAndSeverity("Availability", "Medium");
        avail_L = obj.getCountCategoryAndSeverity("Availability", "Low");
        
        res_C = obj.getCountCategoryAndSeverity("Resilience", "Critical");
        res_H = obj.getCountCategoryAndSeverity("Resilience", "High");
        res_M = obj.getCountCategoryAndSeverity("Resilience", "Medium");
        res_L = obj.getCountCategoryAndSeverity("Resilience", "Low");
        
        auth_C = obj.getCountCategoryAndSeverity("Authentication", "Critical");
        auth_H = obj.getCountCategoryAndSeverity("Authentication", "High");
        auth_M = obj.getCountCategoryAndSeverity("Authentication", "Medium");
        auth_L = obj.getCountCategoryAndSeverity("Authentication", "Low");
        
        secd_C = obj.getCountCategoryAndSeverity("Secure Design", "Critical");
        secd_H = obj.getCountCategoryAndSeverity("Secure Design", "High");
        secd_M = obj.getCountCategoryAndSeverity("Secure Design", "Medium");
        secd_L = obj.getCountCategoryAndSeverity("Secure Design", "Low");
        
        fram_C = obj.getCountCategoryAndSeverity("Frameworks", "Critical");
        fram_H = obj.getCountCategoryAndSeverity("Frameworks", "High");
        fram_M = obj.getCountCategoryAndSeverity("Frameworks", "Medium");
        fram_L = obj.getCountCategoryAndSeverity("Frameworks", "Low");
        
        aud_C = obj.getCountCategoryAndSeverity("Auditing", "Critical");
        aud_H = obj.getCountCategoryAndSeverity("Auditing", "High");
        aud_M = obj.getCountCategoryAndSeverity("Auditing", "Medium");
        aud_L = obj.getCountCategoryAndSeverity("Auditing", "Low");
        
        disas_C = obj.getCountCategoryAndSeverity("Disaster Recovery", "Critical");
        disas_H = obj.getCountCategoryAndSeverity("Disaster Recovery", "High");
        disas_M = obj.getCountCategoryAndSeverity("Disaster Recovery", "Medium");
        disas_L = obj.getCountCategoryAndSeverity("Disaster Recovery", "Low");
    }
    
    
    public void filterRequest(ActionEvent e) {
        
    }

    public int getTotalCritical() {
        return totalCritical;
    }

    public void setTotalCritical(int totalCritical) {
        this.totalCritical = totalCritical;
    }

    public int getTotalHigh() {
        return totalHigh;
    }

    public void setTotalHigh(int totalHigh) {
        this.totalHigh = totalHigh;
    }

    public int getTotalMedium() {
        return totalMedium;
    }

    public void setTotalMedium(int totalMedium) {
        this.totalMedium = totalMedium;
    }

    public int getTotalLow() {
        return totalLow;
    }

    public void setTotalLow(int totalLow) {
        this.totalLow = totalLow;
    }
    
    

    public ArrayList<Finding> getFilteredList() {
        return filteredList;
    }

    public void setFilteredList(ArrayList<Finding> filteredList) {
        this.filteredList = filteredList;
    }
    
    

    public ArrayList<Finding> getMainlist() {
       PostAssessment obj = new PostAssessment();
       mainlist = obj.displayAllFindings();
       return mainlist;
    }

    public void setMainlist(ArrayList<Finding> mainlist) {
        this.mainlist = mainlist;
    }

    public ArrayList<Severity> getSevlist() {
        return sevlist;
    }

    public void setSevlist(ArrayList<Severity> sevlist) {
        this.sevlist = sevlist;
    }

    public ArrayList<QuestionCategory> getCatlist() {
        return catlist;
    }

    public void setCatlist(ArrayList<QuestionCategory> catlist) {
        this.catlist = catlist;
    }

    public String getSelectionMade() {
        return selectionMade;
    }

    public void setSelectionMade(String selectionMade) {
        this.selectionMade = selectionMade;
    }

    public int getJur_C() {
        return jur_C;
    }

    public void setJur_C(int jur_C) {
        this.jur_C = jur_C;
    }

    public int getJur_H() {
        return jur_H;
    }

    public void setJur_H(int jur_H) {
        this.jur_H = jur_H;
    }

    public int getJur_M() {
        return jur_M;
    }

    public void setJur_M(int jur_M) {
        this.jur_M = jur_M;
    }

    public int getJur_L() {
        return jur_L;
    }

    public void setJur_L(int jur_L) {
        this.jur_L = jur_L;
    }

    public int getAvail_C() {
        return avail_C;
    }

    public void setAvail_C(int avail_C) {
        this.avail_C = avail_C;
    }

    public int getAvail_H() {
        return avail_H;
    }

    public void setAvail_H(int avail_H) {
        this.avail_H = avail_H;
    }

    public int getAvail_M() {
        return avail_M;
    }

    public void setAvail_M(int avail_M) {
        this.avail_M = avail_M;
    }

    public int getAvail_L() {
        return avail_L;
    }

    public void setAvail_L(int avail_L) {
        this.avail_L = avail_L;
    }

    public int getPol_C() {
        return pol_C;
    }

    public void setPol_C(int pol_C) {
        this.pol_C = pol_C;
    }

    public int getPol_H() {
        return pol_H;
    }

    public void setPol_H(int pol_H) {
        this.pol_H = pol_H;
    }

    public int getPol_M() {
        return pol_M;
    }

    public void setPol_M(int pol_M) {
        this.pol_M = pol_M;
    }

    public int getPol_L() {
        return pol_L;
    }

    public void setPol_L(int pol_L) {
        this.pol_L = pol_L;
    }

    public int getConf_C() {
        return conf_C;
    }

    public void setConf_C(int conf_C) {
        this.conf_C = conf_C;
    }

    public int getConf_H() {
        return conf_H;
    }

    public void setConf_H(int conf_H) {
        this.conf_H = conf_H;
    }

    public int getConf_M() {
        return conf_M;
    }

    public void setConf_M(int conf_M) {
        this.conf_M = conf_M;
    }

    public int getConf_L() {
        return conf_L;
    }

    public void setConf_L(int conf_L) {
        this.conf_L = conf_L;
    }

    public int getRes_C() {
        return res_C;
    }

    public void setRes_C(int res_C) {
        this.res_C = res_C;
    }

    public int getRes_H() {
        return res_H;
    }

    public void setRes_H(int res_H) {
        this.res_H = res_H;
    }

    public int getRes_M() {
        return res_M;
    }

    public void setRes_M(int res_M) {
        this.res_M = res_M;
    }

    public int getRes_L() {
        return res_L;
    }

    public void setRes_L(int res_L) {
        this.res_L = res_L;
    }

    public int getAuth_C() {
        return auth_C;
    }

    public void setAuth_C(int auth_C) {
        this.auth_C = auth_C;
    }

    public int getAuth_H() {
        return auth_H;
    }

    public void setAuth_H(int auth_H) {
        this.auth_H = auth_H;
    }

    public int getAuth_M() {
        return auth_M;
    }

    public void setAuth_M(int auth_M) {
        this.auth_M = auth_M;
    }

    public int getAuth_L() {
        return auth_L;
    }

    public void setAuth_L(int auth_L) {
        this.auth_L = auth_L;
    }

    public int getSecd_C() {
        return secd_C;
    }

    public void setSecd_C(int secd_C) {
        this.secd_C = secd_C;
    }

    public int getSecd_H() {
        return secd_H;
    }

    public void setSecd_H(int secd_H) {
        this.secd_H = secd_H;
    }

    public int getSecd_M() {
        return secd_M;
    }

    public void setSecd_M(int secd_M) {
        this.secd_M = secd_M;
    }

    public int getSecd_L() {
        return secd_L;
    }

    public void setSecd_L(int secd_L) {
        this.secd_L = secd_L;
    }

    public int getFram_C() {
        return fram_C;
    }

    public void setFram_C(int fram_C) {
        this.fram_C = fram_C;
    }

    public int getFram_H() {
        return fram_H;
    }

    public void setFram_H(int fram_H) {
        this.fram_H = fram_H;
    }

    public int getFram_M() {
        return fram_M;
    }

    public void setFram_M(int fram_M) {
        this.fram_M = fram_M;
    }

    public int getFram_L() {
        return fram_L;
    }

    public void setFram_L(int fram_L) {
        this.fram_L = fram_L;
    }

    public int getAud_C() {
        return aud_C;
    }

    public void setAud_C(int aud_C) {
        this.aud_C = aud_C;
    }

    public int getAud_H() {
        return aud_H;
    }

    public void setAud_H(int aud_H) {
        this.aud_H = aud_H;
    }

    public int getAud_M() {
        return aud_M;
    }

    public void setAud_M(int aud_M) {
        this.aud_M = aud_M;
    }

    public int getAud_L() {
        return aud_L;
    }

    public void setAud_L(int aud_L) {
        this.aud_L = aud_L;
    }

    public int getDisas_C() {
        return disas_C;
    }

    public void setDisas_C(int disas_C) {
        this.disas_C = disas_C;
    }

    public int getDisas_H() {
        return disas_H;
    }

    public void setDisas_H(int disas_H) {
        this.disas_H = disas_H;
    }

    public int getDisas_M() {
        return disas_M;
    }

    public void setDisas_M(int disas_M) {
        this.disas_M = disas_M;
    }

    public int getDisas_L() {
        return disas_L;
    }

    public void setDisas_L(int disas_L) {
        this.disas_L = disas_L;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
    
}
