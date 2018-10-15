/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ike
 */
public class MySQLConnector implements DBConnector{

    Connection connection = null;
    Statement statement = null;

    static String host = "jdbc:mysql://localhost:3306/zombie";
    static String user = "root";
    static String password = "root";

    public MySQLConnector() {
        // Initialize the connection at start-up.
        this.connect();
    }

    @Override
    public Boolean updateObject(Map<String,String> _keyValuePairs, String _uuid, String _table) {
        String query =  "UPDATE " + _table + " SET ";
        //iterate over map
        String updates = "";
        for (Map.Entry<String, String> entry : _keyValuePairs.entrySet()){
            updates+= " `" + entry.getKey() + "` = \"" + entry.getValue() + "\","; 
        }
        //shed off the last comma
        updates = updates.substring(0, updates.length()-1);
        query = query + updates + " WHERE `uuid` = " + _uuid;
        
        this.executeUpdate(query);
        return true;
    }

     
    private void executeUpdate(String query){
        try {
            statement.executeUpdate(query, Statement.NO_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println("Query Error: " + ex.getMessage());
            Logger.getLogger(DataStore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    public int createObject(Map<String, String> _keyValuePairs, String _table) {
        String query =  "INSERT INTO " + _table;
        String names = "(";
        String values = "VALUES (";
        for (Map.Entry<String, String> entry : _keyValuePairs.entrySet()){
            names+=  " `" + entry.getKey() + "`, ";
            values+= " '" + entry.getValue() + "', "; 
        }
        // Trim off the last comma.
        names = names.substring(0, names.length() - 2);
        values = values.substring(0, values.length() - 2);
        names+= ") ";
        values+= ")";
        query+= names + values;
        int newKey = 0;
        // Execute the query.
        newKey = this.executeInsert(query);
        if (newKey == -1) {
            System.out.println("Database Error: Could not create new record");
        }
        return newKey;
    }
    
    
    private int executeInsert(String query){
        int key = -1;
        try {
            this.statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet result = statement.getGeneratedKeys();
            if (result.next()){
                key = result.getInt(1);            
            }
        } catch (SQLException ex) {
            System.out.println("Query Error: " + ex.getMessage());
            Logger.getLogger(DataStore.class.getName()).log(Level.SEVERE, null, ex);
        }
        return key;
    }

    @Override
    public Map<String,String> readObject(Map<String,String> _keyValuePairs) {
        return null;
    }

    private ResultSet executeRead(String query) {
        ResultSet results = this.runQuery(query);
        try {
            // check to see if there are any results
            if (results.next()){
                // do nothing, we just now know that we have data
            }
            return results;
        }catch(SQLException ex) {
            System.out.println("Database Error: No Result Found." + ex.getMessage());
        }
        return null;
    }

    @Override
    public Boolean deleteObject(String uuid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
    
    public ResultSet runQuery(String query){
        ResultSet result = null;
        try {
            result = statement.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println("Query Error: " + ex.getMessage());
        }
        return result;
    }

    private void connect() {
        try {
            this.connection = DriverManager.getConnection(host, user, password);
            this.statement = connection.createStatement();
        } catch (SQLException ex) {
            System.out.println("No Connection to DB: " + ex.getMessage());
        } 
    }
    
    public void closeConnection(){
       if (statement != null) {
            try {
              statement.close();
            } catch (SQLException ex) {
                System.out.println("Statement Close Error: " + ex.getMessage());                
                Logger.getLogger(DataStore.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       if (this.connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println("Connection Close Error: " + ex.getMessage());
                Logger.getLogger(DataStore.class.getName()).log(Level.SEVERE, null, ex);
            }
        }          
    }

}
