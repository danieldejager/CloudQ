/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.security;
import java.util.*;
import java.io.*;

/**
 *
 * @author daniel112
 */
public class Global {


    //Returns an encrypted secret
    public String getUser() {
    try {
        String parameter="";
        Properties p = new Properties();
        ClassLoader loader = getClass().getClassLoader();
        InputStream io = loader.getResourceAsStream("configuration.properties");
        if (io != null ) {
            p.load(io);
            parameter = p.getProperty("user");
        }
        return parameter;
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
        return "";
    }
    }

        //Returns an encrypted secret
    public String getPassword() {
     try {
        String parameter="";
        Properties p = new Properties();
        ClassLoader loader = getClass().getClassLoader();
        InputStream io = loader.getResourceAsStream("configuration.properties");
        if (io != null ) {
            p.load(io);
            parameter = p.getProperty("pass");
        }
        return parameter;
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
        return "";
    }
    }

    public String getConnectionParam() {
    try {
        String parameter="";
        Properties p = new Properties();
        ClassLoader loader = getClass().getClassLoader();
        InputStream io = loader.getResourceAsStream("configuration.properties");
        if (io != null ) {
            p.load(io);
            parameter = p.getProperty("connectionparam");
        }
        return parameter;
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
        return "";
    }

    }
}


