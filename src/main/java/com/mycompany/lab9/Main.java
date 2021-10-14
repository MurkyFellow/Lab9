/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab9;

import edu.tarleton.database.Connection;
import edu.tarleton.database.Statement;
import java.io.InputStream;
import java.util.Properties;


/**
 *
 * @author 000728303
 */
public class Main {
    public static void main(String[] args) throws Exception {
        
        Properties prop = new Properties();
        try (InputStream in = Main.class.getClassLoader().getResourceAsStream("db.properties")) {
            prop.load(in);
            
        } 
        
        try (Connection con = new Connection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password"))){
            try (Statement st = con.createStatement()){
                st.executeQuery("Select * from Car");
            }
        }
        
    }
}
