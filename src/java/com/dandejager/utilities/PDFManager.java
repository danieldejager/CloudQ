/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.utilities;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.apache.pdfbox.pdfparser.PDFStreamParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1CFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.PDType3Font;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author daniel112
 */
public class PDFManager {
 
    public void test() {
     try {
         File f = new File("D:/templateData/reportTemplate.pdf");
         PDDocument doc = PDDocument.load(f);
         doc.close();
         
         //System.out.println("ok its loaded");
        // System.out.println("Number of pages are : " + doc.getNumberOfPages());
         } catch (Exception ex) {
                    System.out.println(ex.getMessage());
         }
    }
    
    public void addPageWithExecutiveSummary(String text) {
        try {
         System.out.println(text);
         File f = new File("D:/templateData/reportTemplate.pdf");
         PDDocument doc = PDDocument.load(f);
         PDPage page = new PDPage();
         
            PDFont pdfFont = PDType1Font.TIMES_ROMAN;
            doc.addPage(page);
            PDPageContentStream contentStream = new PDPageContentStream(doc,page);
            
           
            float fontSize = 12;
            float leading = 1.5f * fontSize;

            PDRectangle mediabox = page.getMediaBox();
            float margin = 72;
            float width = mediabox.getWidth() - 2*margin;
            float startX = mediabox.getLowerLeftX() + margin;
            float startY = mediabox.getUpperRightY() - margin;
            
             
            contentStream.beginText();
            contentStream.setFont(pdfFont, fontSize);
            contentStream.newLineAtOffset(50, 50);
            contentStream.showText("Executive Summary");
            contentStream.endText();
            
            contentStream.beginText();
            contentStream.setFont(pdfFont, fontSize);
            contentStream.newLineAtOffset(50, 50);
            contentStream.showText("                  ");
            contentStream.endText();
            
             List<String> lines = new ArrayList<String>();
             int lastSpace = -1;
            while (text.length() > 0)
           {
                int spaceIndex = text.indexOf(' ', lastSpace + 1);
                if (spaceIndex < 0)
                    spaceIndex = text.length();
                String subString = text.substring(0, spaceIndex);
                float size = fontSize * pdfFont.getStringWidth(subString) / 1000;
                System.out.printf("'%s' - %f of %f\n", subString, size, width);
                if (size > width)
                {
                    if (lastSpace < 0)
                        lastSpace = spaceIndex;
                    subString = text.substring(0, lastSpace);
                    lines.add(subString);
                    text = text.substring(lastSpace).trim();
                    System.out.printf("'%s' is line\n", subString);
                    lastSpace = -1;
                }
                else if (spaceIndex == text.length())
                {
                    lines.add(text);
                    System.out.printf("'%s' is line\n", text);
                    text = "";
                }
                else
                {
                    lastSpace = spaceIndex;
                }
            }

            contentStream.beginText();
            contentStream.setFont(pdfFont, fontSize);
            contentStream.newLineAtOffset(startX, startY);
            for (String line: lines)
            {
                contentStream.showText(line);
                contentStream.newLineAtOffset(0, -leading);
            }
            contentStream.endText(); 
            contentStream.close();

            doc.save("D:/templateData/reportTemplate2.pdf");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
         
            
            
            
            
            
            
            
            
            
            
            
         
    
    
    private String getTemplatePath() {
     try {
        String parameters="";
        Properties p = new Properties();
        ClassLoader loader = getClass().getClassLoader();
        InputStream io = loader.getResourceAsStream("configuration.properties");
        if (loader == null) {
            System.out.println("loader is null");
        } else if (io!= null) {
            p.load(io);
            parameters  = p.getProperty("reportTemplate_path");
        } else {
            System.out.println("Parameters is null");
        }
            return parameters;
     } catch (Exception ex) {
         System.out.println(ex.getMessage());
         return "";
     }
    }
    
   public void drarwATable(String p_cloudAssessmentId) { 
       try {
       File f = new File("D:/templateData/reportTemplate2.pdf");
       PDDocument doc = PDDocument.load(f);
       PDPage page = new PDPage();
       doc.addPage( page );

       PDPageContentStream contentStream = new PDPageContentStream(doc, page);
       
       //ok get all the findings for this cloud assessment

       String[][] content = {{"Severity","Finding", "Remediated"}, 
                             {"c","d", "N"}, 
                             {"e","f", "N"}, 
                             {"g","h", "N"}, 
                             {"i","j", "N"}} ;
        drawTable t = new drawTable();
        t.drawTable(page, contentStream, 700, 100, content);
        contentStream.close();
        doc.save("D:/templateData/test.pdf" );
   } catch (Exception ex) {
        System.out.println(ex.getMessage());
   }
   }
   
   public StreamedContent downloadReport() {
       try {
           File f = new File("d:/templateData/test.pdf");
           FileInputStream stream = new FileInputStream(f);
                    if (stream==null) {
                        System.out.println("This fuckin thing is null");
                        return null;

                    } else { 
                        System.out.println("Stream is fine");
                        return new DefaultStreamedContent(stream,"application/pdf","mainreport.pdf");

                    }     
       } catch (Exception ex) {
           System.out.println(ex.getMessage());
           return null;
       }
       
   }
   
   
}
   
     
    
    
    
    
    

