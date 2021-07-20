/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.beans;

import disc.tiinfosec.businesslayer.AnswerHighLevelQuestions;
import disc.tiinfosec.businesslayer.GetRegIdFromUsers;
import disc.tiinfosec.businesslayer.UpdateProgress;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FlowEvent;

import disc.tiinfosec.businessobjects.Questionnaire;

import disc.tiinfosec.datalayer.InsertUpdateCloudAssessment;
import javax.faces.context.ExternalContext;
import org.primefaces.model.UploadedFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.faces.bean.SessionScoped;
import java.util.*;
import disc.tiinfosec.security.SessionUtils;

import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DANIEL112
 */
@ManagedBean
@SessionScoped
public class highlevelquestionsbean implements Serializable {
    
    private boolean skip;
    private Questionnaire responses = new Questionnaire();
    private String filename;
    private static final int BUFFER_SIZE = 6124;
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    

    public Questionnaire getResponses() {
        return responses;
    }

    public void setResponses(Questionnaire responses) {
        this.responses = responses;
    }

    
      
    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String onFlowProcess(FlowEvent event) {
         
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
    
    
    public void handleFileUpload(FileUploadEvent event) {
     try {   
         UploadedFile file = (UploadedFile) event.getFile();
         filename = file.getFileName();
         responses.setFilename(filename);
         ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
         String user = (String) context.getSessionMap().get("username");
         File result = new File(context.getRealPath("//WEB-INF//assessments//" + user + "//"));
         createFolderStructure(result, user, file, context);
         responses.setFilepath(result.getAbsolutePath());
         FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
         FacesContext.getCurrentInstance().addMessage(null, message);
     } catch (Exception ex) {
         System.out.println(ex.getMessage());
         FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_ERROR,"The file(s) where not uploaded","");
         FacesContext.getCurrentInstance().addMessage(null, error);
     }
    }
    
    private boolean createFolderStructure(File p_result, String p_user, UploadedFile p_file, ExternalContext p_context) {
     try {   
        boolean bool = false;
        
         
         DateFormat df = new SimpleDateFormat("dd-mm-yyyy");
         Date dateobj = new Date();
         String folder = df.format(dateobj);
         
         
        
         if ( p_result == null ) {
             System.out.println("file object result is null");
         } else {
            System.out.println("File object result is not null");
         }
         
         if ( !p_result.exists()) {
             System.out.println("The path does not exists. Attempting to create the directory " + p_result.getPath());
             boolean trie =  p_result.mkdirs();
             if  (trie) {
                 if (p_file.getFileName().equals("")) {
                     System.out.println("Something wrong with the file name");
                      
                 } else {
                     p_result = new File(p_context.getRealPath("//WEB-INF//assessments" + "//" + p_user + "//" + p_file.getFileName()));
                     responses.setFilepath(p_result.getPath());
                     responses.setFilename(filename);
                     System.out.println(p_file.getFileName());
                 }
                 
             } else {
                 System.out.println("System cannot create directory for some reason.....must be the path");
             }
         } else {
             System.out.println("The file structure already exists");
         }
         
         System.out.println(p_result.getAbsolutePath());
         FileOutputStream fileoutputStream = new FileOutputStream(p_result);
         byte[] buffer = new byte[BUFFER_SIZE];
         int bulk;
         InputStream inputStream = p_file.getInputstream();
         while(true) {
             bulk = inputStream.read(buffer);
             if (bulk < 1) {
                 break;
             }
             fileoutputStream.write(buffer, 0, bulk);
             fileoutputStream.flush();
         }
         fileoutputStream.close();
         inputStream.close();
        return bool;
        
    } catch (Exception ex) {
    System.out.println(ex.getMessage());
}
    
   return true; 

}
    
    public void ProcessHighLevelDescriptionData(ActionEvent e) {
    try {   
        System.out.println(responses.getFilepath());
        System.out.println(responses.getJustification());
        System.out.println(responses.getNDA());
        
        
        if(filename==null || "".equals(filename)) {
            FacesMessage msg = new FacesMessage("All Assessments must have an architecture diagram. Without it, this assessment will be invalid. Go back to the Technical Diagram and Upload an Architecture Document");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            
            SessionUtils session = new SessionUtils();
            String registrationid="";
            
            HttpSession session2 = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            String username = (String) session2.getAttribute("username");
            System.out.println(username);
            
            if ( username.equals("")) {
                System.out.println("Could not retrieve the username");
            } else {
                System.out.println("Username is not null");
                GetRegIdFromUsers get = new GetRegIdFromUsers();
                registrationid = get.ReturnRegistrationIdbyUserName(username);
                
                //redirect the user to the detail questions page
                try {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("AssessmentAnswers.xhtml");
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            System.out.println(registrationid);
            
            if( !registrationid.equals("")) {
                AnswerHighLevelQuestions answer = new AnswerHighLevelQuestions();
                answer.AnswerHighLevel(responses, registrationid);
                // update the status to detail questions
                UpdateProgress stat = new UpdateProgress();
                stat.updateProgressToDetailQuestions("detailquestions", registrationid, username);
                
            } else {
                System.out.println("Could not retrieve registration id");
            }
            
            //hopefully everything works and hte database update
            //now update next step and processstep
            InsertUpdateCloudAssessment updater = new InsertUpdateCloudAssessment();
            updater.updateCloudAssessmentNextStep("detailquestions",registrationid);
            
        }
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
        try {
        FacesContext.getCurrentInstance().getExternalContext().redirect("error.xhtml");
        } catch (Exception ex2) {
            System.out.println(ex.getMessage());
        }
    }

    }
}
