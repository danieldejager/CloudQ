/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.beans;

import disc.tiinfosec.businesslayer.GetRegIdFromUsers;
import javax.faces.bean.ManagedBean;
 
import disc.tiinfosec.businessobjects.Question;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import disc.tiinfosec.businesslayer.populateQuestions;
import disc.tiinfosec.businesslayer.ManageQuestions;
import disc.tiinfosec.businesslayer.UpdateAssessment;
import disc.tiinfosec.businessobjects.Answer;
import java.io.Serializable;
 
import javax.faces.application.FacesMessage;
 
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
 
import org.primefaces.model.UploadedFile;
import disc.tiinfosec.businesslayer.UpdateQuestionnaireAnswer;
import disc.tiinfosec.businessobjects.Questionnaire;
import disc.tiinfosec.datalayer.GetAnswersByRegiIdAndUserId;
import disc.tiinfosec.datalayer.GetQuestionnaire;
import disc.tiinfosec.datalayer.GetQuestionnnaireByUserAndRegiId;
import disc.tiinfosec.datalayer.GetRegistrationByUserId;
import disc.tiinfosec.datalayer.InsertUpdateUser;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import javax.faces.context.ExternalContext;
import javax.servlet.http.HttpSession;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author DANIEL112
 */
@ManagedBean
@SessionScoped
public class detailassessment implements Serializable {
    int questionNumber = 1;
    int totalNumberOfQuestions = 0;
    private Question question;
    private UploadedFile file;
    private populateQuestions pop;
    private Answer ans;
    String completepath;
    private static final int BUFFER_SIZE = 6124;
    String regid;
     
    
    @PostConstruct
    public void init() {
        //get the first question
        //but also get the total number of questions
        ManageQuestions totalQs = new ManageQuestions();
        totalNumberOfQuestions = Integer.parseInt(totalQs.getCount());
        ans = new Answer();
        
        pop = new populateQuestions();
        
        // but first we need to determine if this guy has answered some questions before so lets do this:
        //query the database and ask if there are any existing questions answered by this user
        //we need to the username
        FacesContext context = FacesContext.getCurrentInstance();    
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        String user = (String) session.getAttribute("username");
        //we need the registrationid
        GetRegIdFromUsers get = new GetRegIdFromUsers();
        regid = get.ReturnRegistrationIdbyUserName(user);
        GetAnswersByRegiIdAndUserId seeker = new GetAnswersByRegiIdAndUserId();
        String totalAnswered = seeker.CountTotalAnswers(regid, user);
        int total = Integer.parseInt(totalAnswered);
        if (total > 0) {
            //then he already answered some questions...so we need tofind out where did this guy stop, which is the totalamount of records
            //and this is contained int he variable total
            questionNumber = total + 1;
            question = pop.getQuestionNumber(Integer.toString(questionNumber));
        } else {
            // ok nothing was answered yet so we can just get question number 1 and get hte ball rolling
             question = pop.getQuestionNumber(Integer.toString(questionNumber));
             if (question==null) {
                   System.out.println("Question object is null trying to populate");
             }
        }
    }

    public populateQuestions getPop() {
        return pop;
    }

    public void setPop(populateQuestions pop) {
        this.pop = pop;
    }

    public String getCompletepath() {
        return completepath;
    }

    public void setCompletepath(String completepath) {
        this.completepath = completepath;
    }

    public String getRegid() {
        return regid;
    }

    public void setRegid(String regid) {
        this.regid = regid;
    }
    
    

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public Answer getAns() {
        return ans;
    }

    public void setAns(Answer ans) {
        this.ans = ans;
    }
    
    

    public int getTotalNumberOfQuestions() {
        return totalNumberOfQuestions;
    }

    public void setTotalNumberOfQuestions(int totalNumberOfQuestions) {
        this.totalNumberOfQuestions = totalNumberOfQuestions;
    }
    
    

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    
    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public Answer getAnswer() {
        return ans;
    }

    public void setAnswer(Answer answer) {
        this.ans = answer;
    }

     
    
    
    
    public void getNextQuestion(ActionEvent e) {
        //remember to reset the answer
        try {
        if (totalNumberOfQuestions > questionNumber) {
            System.out.println("Total questions are " + totalNumberOfQuestions);
                    if (question==null) {
                         System.out.println("Question object is null trying to populate");
                    }
             //ok maar onthou om die antwoorde te capture
             //remember to add compulsory fields
             FacesContext context = FacesContext.getCurrentInstance();
             HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
             ans.setUsername((String) session.getAttribute("username"));
             // you need to fetch the registrationid
             GetRegIdFromUsers get = new GetRegIdFromUsers();
             ans.setRegistrationid(get.ReturnRegistrationIdbyUserName(ans.getUsername()));
             ans.setQuestionid( (String.valueOf(questionNumber)));
             
             
             
             
             System.out.println("+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_");
             System.out.println(ans.getEvidenceString());
             System.out.println("+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_");
             //debug code
             System.out.println(ans.getQuestionAnswer());
             System.out.println(ans.getQuestionElaboration());
             //commit answers
             UpdateQuestionnaireAnswer update = new UpdateQuestionnaireAnswer();
             update.UpdateQuestionAnswer(ans);
             questionNumber = questionNumber + 1;
             question = pop.getQuestionNumber(Integer.toString(questionNumber));
             System.out.println(questionNumber);
             System.out.println(question.getQuestion());       
             ans = new Answer();
            
             completepath = "";
             FacesContext.getCurrentInstance().getExternalContext().redirect("AssessmentAnswers.xhtml");
        } else {
            //update the status of this questionnaire and set the correct values for the cloudassessment table
            UpdateAssessment updater = new UpdateAssessment();
            //get username from session and in then get the registeration
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            String username = (String) session.getAttribute("username");
            GetRegistrationByUserId getReg = new GetRegistrationByUserId();
            disc.tiinfosec.businessobjects.Registration registration =  getReg.GetRegbyUserId(username);
            System.out.println("For updating this table the registration id is " + registration.getRegistrationID() + " and thte username is " + username);
            updater.updateAssessmentVendorCompleted(registration.getRegistrationID(), username);
            
            
            //disable the user dude...you also understand the login is stupidly coded
            InsertUpdateUser u = new InsertUpdateUser();
            u.disableUser(regid);
            session.invalidate();
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
            
        }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }    
    
    public void handleExit() {
    try {
        FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
    }  catch (Exception ex) {
            System.out.println(ex.getMessage());
    } 
       
    }
    
    public void handleFileUpload(FileUploadEvent event) {
        try {
            file = event.getFile();
            System.out.println(file.getFileName());
            if (file!=null) {
             
             System.out.println("This is where I am testing from");
             GetQuestionnnaireByUserAndRegiId gettervalue = new GetQuestionnnaireByUserAndRegiId();
             System.out.println("The registration id I need to use here is : " + regid);
             Questionnaire q = gettervalue.returnQbyUserandRegid(regid);
             System.out.println("The path that I'm using is + " + q.getFilepath());
             System.out.println(file.getFileName());
             completepath =  q.getFilepath() + "\\" + file.getFileName();
             ans.setEvidenceString(completepath);
             System.out.println("The complete path variable contains " + completepath);
             System.out.println("Let's test to see if the Answer object stores the complete path + " + ans.getEvidenceString());
             // but do the actual upload from here
             writeFiletoDisk(q.getFilepath(), file.getFileName(), file);
             }
            FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            
        } catch (Exception ex) {
            System.out  .println(ex.getMessage());
        }
    }
    
    private void writeFiletoDisk(String p_path, String p_file, UploadedFile p_uploadedFile) {
    try {
         File f = new File(p_path, p_file);
         FileOutputStream fileoutputStream = new FileOutputStream(f);
         byte[] buffer = new byte[BUFFER_SIZE];
         int bulk;
         InputStream inputStream = p_uploadedFile.getInputstream();
         while(true) {
             bulk = inputStream.read(buffer);
             if (bulk < 1) {
                 break;
             }
             fileoutputStream.write(buffer, 0, bulk);
             fileoutputStream.flush();
         }
         System.out.println("Ok file has been written without a glitch");
         fileoutputStream.close();
         inputStream.close();
    } catch(Exception ex) {
        System.out.println(ex.getMessage());
    }
    } 
}
