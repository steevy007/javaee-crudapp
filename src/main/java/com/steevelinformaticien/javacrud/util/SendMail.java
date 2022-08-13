/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steevelinformaticien.javacrud.util;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author PEPECELL
 */
public class SendMail {
    private  final String EMAIL="steeve.sanon@atalou.info";
    private  final String USERPASS="Steeve2021!";
    private  final String HOSTMAIL="smtp.ionos.com";
    private  final int PORT=465;
    private  final boolean SSLCONNECT=true;
    
    private String from;
    
    private String subject;
    
    private String message;

    public SendMail(String from, String subject, String message) {
        this.from = from;
        this.subject = subject;
        this.message = message;
    }
    
    
    
     
    
    public boolean sendEmail(){
         boolean reponse=false;
        try {
            Email email = new SimpleEmail();
            email.setHostName(HOSTMAIL);
            email.setSmtpPort(PORT);
            email.setAuthenticator(new DefaultAuthenticator(EMAIL, USERPASS));
            email.setSSLOnConnect(true);
            email.setFrom(this.from);
            email.setSubject(this.subject);
            email.setMsg(this.message);
            email.addTo("foo@bar.com"); 
            email.send();
            reponse=true;
        } catch (EmailException ex) {
            ex.printStackTrace();
        }
        return reponse;
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
     * Get the value of subject
     *
     * @return the value of subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Set the value of subject
     *
     * @param subject new value of subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Get the value of from
     *
     * @return the value of from
     */
    public String getFrom() {
        return from;
    }

    /**
     * Set the value of from
     *
     * @param from new value of from
     */
    public void setFrom(String from) {
        this.from = from;
    }

    
   
}
