/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.beans;
import disc.tiinfosec.businesslayer.AddNewAssessment;
import disc.tiinfosec.businesslayer.GetRegistration;
import disc.tiinfosec.businesslayer.GetVendor;
import disc.tiinfosec.businesslayer.RetrieveCloudAssessment;
import disc.tiinfosec.businessobjects.CloudAssessment;
import disc.tiinfosec.businessobjects.Vendor;
import disc.tiinfosec.businessobjects.Registration;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import disc.tiinfosec.security.SessionUtils;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
/**
 *
 * @author DANIEL112
 */
@ManagedBean
@RequestScoped
public class startAssessmentBean implements Serializable {
    
    private String username;
    private Registration registration;
    private Vendor vendor;
    private Date date;
    private static String processStep = "Start";
    private static String status = "In Progress";
    
    private String startDate;
    private String VendorName;
    private String CloudType;
    private String ProcessStep1;
    private String NextStep;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static String getProcessStep() {
        return processStep;
    }

    public static void setProcessStep(String processStep) {
        startAssessmentBean.processStep = processStep;
    }

    public static String getStatus() {
        return status;
    }

    public static void setStatus(String status) {
        startAssessmentBean.status = status;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getVendorName() {
        return VendorName;
    }

    public void setVendorName(String VendorName) {
        this.VendorName = VendorName;
    }

    public String getCloudType() {
        return CloudType;
    }

    public void setCloudType(String CloudType) {
        this.CloudType = CloudType;
    }

    public String getProcessStep1() {
        return ProcessStep1;
    }

    public void setProcessStep1(String ProcessStep1) {
        this.ProcessStep1 = ProcessStep1;
    }

    public String getNextStep() {
        return NextStep;
    }

    public void setNextStep(String NextStep) {
        this.NextStep = NextStep;
    }
    
    
    
    
    @PostConstruct
    public void init() {
         HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session != null) {
        username = (String) session.getAttribute("username");
         if (!username.equals("")) {
            CloudAssessment retrieveAssessment = new CloudAssessment();
             RetrieveCloudAssessment getter = new RetrieveCloudAssessment();
             retrieveAssessment = getter.RetrieveCloudAssessmentStatus(username);
              startDate = retrieveAssessment.getStartDate();
              VendorName = retrieveAssessment.getVendorName();
              CloudType = retrieveAssessment.getCloudType();
              ProcessStep1 = retrieveAssessment.getProcessStep();
              NextStep = retrieveAssessment.getNextStep();
         }
        }
    }
    
    public void processStartAssessment() {
     try {   
//        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//        if (session != null) {
//        username = (String) session.getAttribute("username");
//        }
//        
//        System.out.println("From the session, the user is : " + username);
//        GetRegistration get = new GetRegistration();
//        registration = get.getRegistrationByUserId(username);
//        if ( registration!= null ) {
//            GetVendor vendorObject = new GetVendor();
//            System.out.println(registration.getCompanyName());
//            Vendor v = vendorObject.GetVendorbyVendorName(registration.getCompanyName());
//            if ( v!= null) {
//                CloudAssessment assessment = new CloudAssessment();
//                    assessment.setCloudType(registration.getAssignRegistration());
//                    assessment.setProcessStep("start");
//                    assessment.setRegistrationId(registration.getRegistrationID());
//                    assessment.setStatus("in progress");
//                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//                        LocalDate localDate = LocalDate.now();
//                        assessment.setStartDate(localDate.toString());
//                    assessment.setVendorName(v.getVendorName());
//                    assessment.setNextStep("HighLevelDescription");
//                    assessment.setUserName(username);
//                    AddNewAssessment addnew = new AddNewAssessment();
//                    addnew.InsertNewAssessment(assessment);
                    FacesContext.getCurrentInstance().getExternalContext().redirect("HighLevelDescription.xhtml");
                    
           // }
      //  }
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
    }
    }
}
        
    
    
    
    
