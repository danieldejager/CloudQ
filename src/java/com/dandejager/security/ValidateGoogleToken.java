/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.security;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author daniel112
 */
public class ValidateGoogleToken {
    
    public boolean validateResponseToken(String p_captcha) {
        boolean mainResult = false;
        try {
            if (p_captcha.equals("") || p_captcha.equals(null)) {
                return false;
            }
            GetGoogleProperties google = new GetGoogleProperties();
            System.out.println(google.getURL());
            URL obj = new URL(google.getURL());
            HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
            if ( conn != null ) {
            conn.setRequestMethod("POST");
            conn.setRequestProperty("User-Agent",google.getUserAgent());
            conn.setRequestProperty("Accept-Language", "en-US,en,q=0,5");
            String postParams = "secret=" + google.getSiteKey() + "&response=" + p_captcha;
            //send post request
            conn.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            
            //read response
            int responseCode = conn.getResponseCode();
            System.out.println("Sending POST to " + google.getURL());
            System.out.println("Post Parameters " + postParams);
            System.out.println("Response Code is " + responseCode);
            
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
             
             while ((inputLine = in.readLine()) != null) {
                 response.append(inputLine);
             }
            
             in.close();
            
            JSONParser parser  = new JSONParser();
            Object temp = parser.parse(response.toString());
            JSONObject jsonobj = (JSONObject) temp;
            boolean success = (Boolean) jsonobj.get("success");
            if ( success ) {
                mainResult = true;
            } else {
                mainResult = false;
            }
            
            } else {
                System.out.println("Could not establish a connection to google");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return mainResult;
    }
    
}
