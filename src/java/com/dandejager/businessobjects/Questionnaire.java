/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.businessobjects;

/**
 *
 * @author DANIEL112
 */
public class Questionnaire {
    
    private String recordid;
    private String justification;
    private String vendorinformation;
    private String NDA;
    private String filepath;
    private String filename;
    private String registrationid;

    public String getRegistrationid() {
        return registrationid;
    }

    public void setRegistrationid(String registrationid) {
        this.registrationid = registrationid;
    }
    
    

    public String getRecordid() {
        return recordid;
    }

    public void setRecordid(String recordid) {
        this.recordid = recordid;
    }

    
    
    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public String getVendorinformation() {
        return vendorinformation;
    }

    public void setVendorinformation(String vendorinformation) {
        this.vendorinformation = vendorinformation;
    }

    public String getNDA() {
        return NDA;
    }

    public void setNDA(String NDA) {
        this.NDA = NDA;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    
    
    
            
    
}
