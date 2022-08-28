/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steevelinformaticien.javacrud.model;

/**
 *
 * @author PEPECELL
 */
public class People {
    
    private int id;
    
    private String nom;
    
    private String prenom;
    
    private String email;
    
    private String pays;

    public People(String nom, String prenom, String email, String pays) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.pays = pays;
    }

    public People(int id, String nom, String prenom, String email, String pays) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.pays = pays;
    }
    
    

    /**
     * Get the value of pays
     *
     * @return the value of pays
     */
    public String getPays() {
        return pays;
    }

    /**
     * Set the value of pays
     *
     * @param pays new value of pays
     */
    public void setPays(String pays) {
        this.pays = pays;
    }


    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Get the value of prenom
     *
     * @return the value of prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Set the value of prenom
     *
     * @param prenom new value of prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    /**
     * Get the value of nom
     *
     * @return the value of nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Set the value of nom
     *
     * @param nom new value of nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }


    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "People{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", pays=" + pays + '}';
    }
    
    
    

}
