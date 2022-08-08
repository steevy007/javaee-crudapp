/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steevelinformaticien.javacrud.dao;

import java.sql.Connection;

/**
 *
 * @author PEPECELL
 */
public class SingletonDatabase {
    private static Connection conn=null;
    
    public  static Connection getConnection(){
        if(conn==null){
            conn=(Connection)DatabaseConnection.createConnection();
        }
        return conn;
    }
}
