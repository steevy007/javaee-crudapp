/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.steevelinformaticien.javacrud.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
@WebServlet(name = "Validatepswd", urlPatterns = {"/validatepswd"})
public class Validatepswd extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

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
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        String email = session.getAttribute("email").toString();
        int validate = Integer.parseInt(request.getParameter("validate"));
        int otp = Integer.parseInt(session.getAttribute("otp").toString());

        ObjectMapper mapper = new ObjectMapper();
        if (otp == validate) {
            JsonReponse reponse = new JsonReponse(true, "you can change password");
            session.setAttribute("email",email);
            mapper.writeValue(out, reponse);
        } else {
            JsonReponse reponse = new JsonReponse(false, "Invalide OTP");
            mapper.writeValue(out, reponse);
        }

    }

}
