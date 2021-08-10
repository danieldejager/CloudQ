/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.beans;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
 
import disc.tiinfosec.businessobjects.Assessment;
import disc.tiinfosec.businesslayer.prepareInternalAssessment;
import disc.tiinfosec.businessobjects.Answer;
import disc.tiinfosec.businessobjects.CloudAssessment;
import disc.tiinfosec.businessobjects.DisplayAssessment;
import disc.tiinfosec.businessobjects.Finding;
import disc.tiinfosec.businessobjects.Question;
import disc.tiinfosec.businessobjects.QuestionCategory;
import disc.tiinfosec.businessobjects.Questionnaire;
import disc.tiinfosec.datalayer.GetHighLevelQuestions;
import disc.tiinfosec.datalayer.GetQuestionnaire;
import disc.tiinfosec.datalayer.InsertUpdateCloudAssessment;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author DANIEL112
 */
@ManagedBean
@SessionScoped
public class internalAssessmentBean implements Serializable {
    
    private ArrayList<Assessment> assessmentlist;
    private ArrayList<DisplayAssessment> data = new ArrayList<DisplayAssessment>();
    private DisplayAssessment quanta;
    private String param1;
    private disc.tiinfosec.businessobjects.Question q;
    private Answer z;
    
    //so thats all the display crap...now for finding variables
    private Finding finding = new Finding(); 
    
    //ok so I forget the high level questions and that part I need to add mofofo
    private Questionnaire questionnaire;
    
    private ArrayList<QuestionCategory> listCategories;
    private ArrayList<String> shortcats = new ArrayList<String>();
    
    private StreamedContent fileName;
    private StreamedContent FiletoDownload;
    private String file;
    
    
    
     
    
    
    @PostConstruct
    public void init() {
        //get the variable from the session
        finding = new Finding();
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        param1 = (String) session.getAttribute("internalassessmentid");
        GetHighLevelQuestions getters = new GetHighLevelQuestions();
        questionnaire = getters.GetVendorResponse(param1);
        System.out.println(param1);
        prepareInternalAssessment prep = new prepareInternalAssessment();
        assessmentlist = prep.populateTable(param1);
        for (Assessment a : assessmentlist) {
            quanta = new DisplayAssessment();
            q = a.getQuestion();
            z = a.getAnswer();
            quanta.setQuestion(q.getQuestion());
            quanta.setAnswer(z.getQuestionAnswer());
            quanta.setElaboration(z.getQuestionElaboration());
            quanta.setEvidencelink(z.getEvidenceString());
            //quanta.setUploadedFile(z.getFileStream());
            
            data.add(quanta);
        }
        
        listCategories = prep.GetAllCategories();
        for(QuestionCategory y : listCategories) {
            shortcats.add(y.getQuestionCategoryName());
        }
        prepDownload();
        
        
        
    }

    public StreamedContent getFiletoDownload() {
        return FiletoDownload;
    }

    public void setFiletoDownload(StreamedContent FiletoDownload) {
        this.FiletoDownload = FiletoDownload;
    }

    
    
    public StreamedContent getFileName() {
        return fileName;
    }
    
    
    

    public void setFileName(StreamedContent fileName) {
        this.fileName = fileName;
    }

    
    
    public ArrayList<String> getShortcats() {
        return shortcats;
    }

    public void setShortcats(ArrayList<String> shortcats) {
        this.shortcats = shortcats;
    }
    
    

    public ArrayList<QuestionCategory> getListCategories() {
        return listCategories;
    }

    public void setListCategories(ArrayList<QuestionCategory> listCategories) {
        this.listCategories = listCategories;
    }
    
    

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    
    
    public Finding getFinding() {
        return finding;
    }

    public void setFinding(Finding finding) {
        this.finding = finding;
    }

    
    public ArrayList<DisplayAssessment> getData() {
        return data;
    }

    public void setData(ArrayList<DisplayAssessment> data) {
        this.data = data;
    }

    public DisplayAssessment getQuanta() {
        return quanta;
    }

    public void setQuanta(DisplayAssessment quanta) {
        this.quanta = quanta;
    }
    
    
        public void before(ComponentSystemEvent event){
        if(!FacesContext.getCurrentInstance().isPostback()) {
            
        }
    }
    
    public ArrayList<Assessment> getAssessmentlist() {
        prepareInternalAssessment prep = new prepareInternalAssessment();
        assessmentlist = prep.populateTable(param1);
        return assessmentlist;
    }

    public void setAssessmentlist(ArrayList<Assessment> assessmentlist) {
        prepareInternalAssessment prep = new prepareInternalAssessment();
        this.assessmentlist = prep.populateTable(param1);
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public Question getQ() {
        return q;
    }

    public void setQ(Question q) {
        this.q = q;
    }

    public Answer getZ() {
        return z;
    }

    public void setZ(Answer z) {
        this.z = z;
    }

    
    public void AddFinding(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        prepareInternalAssessment prep = new prepareInternalAssessment();
        //get all the required shit together
        //cloudassessmentid
        //registrationid = param1
        finding.setRegistrationid(param1);
        CloudAssessment assessment = new CloudAssessment();
        if ( !param1.equals("")) {
            assessment= prep.GetCloudAssessmentByRegistrationId(param1);
            if (assessment!= null) {
                finding.setCloudAssessmentId(assessment.getCloudAssessmentId());
            }
        } else {
            System.out.println("Registration id is null...need to get this fixed its in the session");
        }
        if (finding.getRegistrationid().equals("")) {
            System.out.println("Serious issue");
        } else {
            System.out.println(finding.getCloudAssessmentId());
            System.out.println(finding.getRegistrationid());
            System.out.println(finding.getFindingText());
            prep.addNewFinding(finding);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Finding Added","Record inserted");
            FacesContext.getCurrentInstance().addMessage(null, message);
            context.addCallbackParam("loggedIn", true);
        }
    }
    
    
    public void closeOutCurrentAssessment(ActionEvent e){
        try {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            InsertUpdateCloudAssessment closer = new InsertUpdateCloudAssessment();
            System.out.println("OUTPUT FROM ACTION " + param1 + " AS WELL AS " + (String) session.getAttribute("username"));
            closer.closeOutCloudAssessmentByRegistrationId(param1, (String) session.getAttribute("username"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("completedQuestionnaires.xhtml");
            } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
    
    
    
    public void prepDownload() {
    try {    
        //the file
        //get the filename
        Questionnaire toGet = new Questionnaire();
        GetQuestionnaire getterla = new GetQuestionnaire();
        toGet = getterla.GetQuestionnaireByRegistrationId(param1);
        //ok I have the filename...now I need to stream it
        
        String filetoStream = toGet.getFilepath() + "\\" + toGet.getFilename();
        boolean exists = (new java.io.File(filetoStream)).exists();
        if (exists) {
            System.out.println("The file was found");
        } else {
            System.out.println("The file was not found");
        }
        System.out.println(filetoStream);
        file = filetoStream;
        File f = new File(file);
        FileInputStream stream = new FileInputStream(f);
        if (stream==null) {
            System.out.println("This fuckin thing is null");
            fileName=null;
             
        } else {
            System.out.println("Stream is fine");
            fileName = new DefaultStreamedContent(stream,"application/pdf","evidence.pdf");
             
        }
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
    }
         
    }
    
     
    
    public void handleFileClick(String p_filename) {
        try {
            if(p_filename.equals("")) {
                System.out.println("The file name provided in the parameter is null");
                FacesContext.getCurrentInstance().getExternalContext().redirect("performAssessment.xhtml");
            } else {
            System.out.println("The file I want to download is as follows : " + p_filename);
            File f = new File(p_filename);
            FileInputStream stream = new FileInputStream(f);
                    if (stream==null) {
                        System.out.println("This fuckin thing is null");
                        FiletoDownload=null;

                    } else { 
                        System.out.println("Stream is fine");
                        FiletoDownload = new DefaultStreamedContent(stream,"application/pdf","supportingDoc.pdf");

                    }     
            }
           
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    
    
    
    
    
    

    
    
    
    
    
}
