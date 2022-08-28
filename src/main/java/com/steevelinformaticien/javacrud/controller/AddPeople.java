/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.steevelinformaticien.javacrud.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.steevelinformaticien.javacrud.dao.PeopleDao;
import com.steevelinformaticien.javacrud.jsonmodel.JsonReponse;
import com.steevelinformaticien.javacrud.model.People;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PEPECELL
 */
@WebServlet(name = "AddPeople", urlPatterns = {"/addpeople"})
public class AddPeople extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String pays = request.getParameter("pays");

        //create new people
        PeopleDao daopeople = new PeopleDao();
        People people = new People(nom.toUpperCase(), prenom, email, pays);
        if (daopeople.verifyIfEmailExist(people.getEmail())) {
            JsonReponse reponse = new JsonReponse(false, "Email Existant");
            mapper.writeValue(out, reponse);
        }else{
            daopeople.save(people);
            JsonReponse reponse = new JsonReponse(true, "People Add");
            mapper.writeValue(out, reponse);
        }

    }
}
