/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.steevelinformaticien.javacrud.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.steevelinformaticien.javacrud.dao.UserDao;
import com.steevelinformaticien.javacrud.jsonmodel.JsonReponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PEPECELL
 */
@WebServlet(name = "Changepswd", urlPatterns = {"/changepswd"})
public class Changepswd extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
        HttpSession session = request.getSession();
        ObjectMapper mapper = new ObjectMapper();

        String newpass = request.getParameter("newpass");
        String confpass = request.getParameter("confpass");
        String email = session.getAttribute("email").toString();

        UserDao daouser = new UserDao();

        if (newpass.equals(confpass)) {
            boolean value = daouser.changePassword(newpass, email);
            if (value) {
                JsonReponse reponse = new JsonReponse(true, "Password Modifier avec success");
                mapper.writeValue(out, reponse);
            }
            System.out.println(email);

        } else {
            JsonReponse reponse = new JsonReponse(false, "Password non identique");
            mapper.writeValue(out, reponse);
        }
    }

}
