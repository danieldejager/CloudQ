/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.datalayer;
import disc.tiinfosec.utilities.InitialiseDataLayer;
import disc.tiinfosec.businessobjects.Answer;
import disc.tiinfosec.businessobjects.Assessment;
import disc.tiinfosec.businessobjects.Question;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.*;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
/**
 *
 * @author DANIEL112
 */
public class GetQuestionsWithAnswersbyRegistrationId {
    private ArrayList<Assessment> toReturn;
    private Assessment assessment;
    private Question question;
    private Answer answer;
    private int totalQuestions=0;
    
    public ArrayList<Assessment> populateArrayListWithQandA(String p_registration_id) {
        try {
            //get question by question and load the answers by question
            //get the total number of questions
            toReturn = new ArrayList<Assessment>();
            InitialiseDataLayer dl = new InitialiseDataLayer();
            Connection conn = dl.getConnection();
            if ( conn != null) {
                PreparedStatement ps = conn.prepareStatement("SELECT count(*) as totalQuestions FROM ti_infosec.questions");
                System.out.println(ps.toString());
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    totalQuestions = Integer.parseInt(rs.getString("totalQuestions"));
                }
                //ok now we know how many times to loop we can use a counter
                for (int i = 1; i <= totalQuestions; i++) {
                    assessment = new Assessment();
                    answer = new Answer();
                    question = new Question();
                    ps = conn.prepareStatement("select * from questions where questionnumber = ?");
                    ps.setString(1, String.valueOf(i));
                    System.out.println(ps.toString());
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        question.setQuestionNumber(rs.getString("questionnumber"));
                        question.setQuestion(rs.getString("question"));
                        question.setCategory(rs.getString("category"));
                        question.setElaboration(rs.getString("elaboration"));
                    }
                    assessment.setQuestion(question);
                    //ok now get the answer for this question
                    ps = conn.prepareStatement("select * from vendoranswers where registrationid = ? and questionid = ?");
                    ps.setString(1,p_registration_id);
                    ps.setString(2, question.getQuestionNumber());
                    System.out.println(ps.toString());
                    rs = ps.executeQuery();
                    while(rs.next()) {
                        answer.setQuestionAnswer(rs.getString("answer"));
                        answer.setQuestionElaboration(rs.getString("elaboration"));
                        answer.setEvidenceString(rs.getString("uploadedfilelocation"));
//                        if (rs.getString("uploadedfilelocation") == null || rs.getString("uploadedfilelocation").equals("")) {
//                            System.out.println("No file was attached for this answer");
//                        } else {
//                            StreamedContent temp = DoFileStream(answer);
//                            answer.setFileStream(temp);
//                        }
                        
                    }
                    assessment.setAnswer(answer);
                    toReturn.add(assessment);
                }
            }
            return toReturn;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return toReturn;
    }
    
//    private StreamedContent DoFileStream(Answer p_answer) {
//        try {
//        DefaultStreamedContent toReturn;   
//        String file = p_answer.getEvidenceString();
//        File f = new File(file);
//        FileInputStream stream = new FileInputStream(f);
//        if (stream==null) {
//            System.out.println("This fuckin thing is null");
//            toReturn =null;
//        } else {
//            System.out.println("Stream is fine");
//            toReturn = new DefaultStreamedContent(stream,"application/pdf","evidence.pdf");
//        }
//        return toReturn;
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//        return null;
//    }
//    
    
}
