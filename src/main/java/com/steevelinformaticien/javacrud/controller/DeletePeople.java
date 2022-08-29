/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.steevelinformaticien.javacrud.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.steevelinformaticien.javacrud.dao.PeopleDao;
import com.steevelinformaticien.javacrud.jsonmodel.JsonReponse;
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
@WebServlet(name = "DeletePeople", urlPatterns = {"/deletepeople"})
public class DeletePeople extends HttpServlet {

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
        PrintWriter out=response.getWriter();
        //dao
        PeopleDao peopledao=new PeopleDao();
        //mapper
        ObjectMapper mapper=new ObjectMapper();
        //get id
        int id=Integer.parseInt(request.getParameter("id"));
        //reponse json
        peopledao.delete(id);
        JsonReponse reponse=new JsonReponse(true,"user delete");
        mapper.writeValue(out, reponse);
    }

  
}
