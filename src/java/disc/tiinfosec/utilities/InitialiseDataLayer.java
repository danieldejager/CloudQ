/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.utilities;
import java.sql.*;
import java.io.*;
import java.util.*;
import disc.tiinfosec.security.Global;

/**
 *
 * @author daniel112
 */
public class InitialiseDataLayer {
    private Connection con;
    private  String connectionParam;

    public InitialiseDataLayer() {};

    /**
     * This is the constructor method. It does not accept any parameters
     */
    public  Connection getConnection() {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Global g = new Global();
            con = DriverManager.getConnection(g.getConnectionParam(), g.getUser(),g.getPassword());
            g = null;
            return con;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    /**
     *
     * @param p_connection
     */
    public void CloseConnection(Connection p_connection) {
        try {
               p_connection.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     *
     * @return
     */
    private String getConnectionParameters() {
     try {
        String parameters="";
        Properties p = new Properties();
        ClassLoader loader = getClass().getClassLoader();
        InputStream io = loader.getResourceAsStream("configuration.properties");
        if (loader == null) {
            System.out.println("loader is null");
        } 
        if ( io != null ) {
            p.load(io);
            parameters  = "jdbc:mysql://" + p.getProperty("database_dns") + ":" + p.getProperty("database_port") +"/" +p.getProperty("database_db") + "?autoReconnect=" + p.getProperty("autoReconnect") +"&useSSL=" + p.getProperty("useSSL");
            System.out.println(parameters);
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
