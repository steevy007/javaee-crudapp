/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steevelinformaticien.javacrud.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author PEPECELL
 */
public class DatabaseConnection {
    private final static String DATABASE="crudappjava";
    private final static String URL="jdbc:mysql://localhost:3306/" + DATABASE;
    private final static String USER="root";
    private final static String PSSWD="";

    public DatabaseConnection() {
    }
    
    public static Connection createConnection(){
        Connection conn=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(URL,USER,PSSWD);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return conn;
    }
    
}
