/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.security;

import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author daniel112
 */
public class GetGoogleProperties {
    
    public String getURL() {
        
     try {
        String parameters="";
         Properties p = new Properties();
        ClassLoader loader = getClass().getClassLoader();
         InputStream io = loader.getResourceAsStream("configuration.properties");
        if (loader == null) {
            System.out.println("loader is null");
        } else if (io!=null) {
            p.load(io);
            parameters  = p.getProperty("google_url");
        } else {
            System.out.println("Parameters is null");
        }
            return parameters;
     } catch (Exception ex) {
         System.out.println(ex.getMessage());
         return "";
     }
    }
    
    public String getSiteKey() {
         try {
        String parameters="";
         Properties p = new Properties();
        ClassLoader loader = getClass().getClassLoader();
         InputStream io = loader.getResourceAsStream("configuration.properties");
        if (loader == null) {
            System.out.println("loader is null");
        } else if (io!=null) {
            p.load(io);
            parameters  = p.getProperty("site_key");
        } else {
            System.out.println("Parameters is null");
        }
            return parameters;
     } catch (Exception ex) {
         System.out.println(ex.getMessage());
         return "";
     }
    }
    
    public String getUserAgent() {
         try {
        String parameters="";
         Properties p = new Properties();
        ClassLoader loader = getClass().getClassLoader();
         InputStream io = loader.getResourceAsStream("configuration.properties");
        if (loader == null) {
            System.out.println("loader is null");
        } else if (io!=null) {
            p.load(io);
            parameters  = p.getProperty("user_agent");
        } else {
            System.out.println("Parameters is null");
        }
            return parameters;
     } catch (Exception ex) {
         System.out.println(ex.getMessage());
         return "";
     }
    }
    
}
