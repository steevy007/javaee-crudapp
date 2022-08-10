/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steevelinformaticien.javacrud.jsonmodel;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import java.util.ArrayList;






/**
 *
 * @author PEPECELL
 */
public class JsonReponse {
  
    private boolean status;
    
    private String message;
    
    private ArrayList data;

    public ArrayList getData() {
        return data;
    }

    public void setData(ArrayList data) {
        this.data = data;
    }

    public JsonReponse(boolean status, String message) {
        this.status = status;
        this.message = message;
    }
    
    

    /**
     * Get the value of message
     *
     * @return the value of message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set the value of message
     *
     * @param message new value of message
     */
    public void setMessage(String message) {
        this.message = message;
    }


    /**
     * Get the value of status
     *
     * @return the value of status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Set the value of status
     *
     * @param status new value of status
     */
    public void setStatus(boolean status) {
        this.status = status;
    }


}
