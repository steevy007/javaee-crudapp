/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.steevelinformaticien.javacrud.controller;

import com.steevelinformaticien.javacrud.util.SendMail;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Math.random;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
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
@WebServlet(name = "ForgetPswd", urlPatterns = {"/forget"})
public class ForgetPswd extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        Random random =new Random();
        int otp = random.nextInt(100000); 
        try {
            SendMail.sendAsHtml(email, "OTP", "<h1>OUR OTP REST PASSWORD IS "+otp+"</h1>");
            response.sendRedirect("validate.jsp");
            session.setAttribute("otp", otp);
            session.setAttribute("email",email);
        } catch (MessagingException ex) {
            Logger.getLogger(ForgetPswd.class.getName()).log(Level.SEVERE, null, ex);
              out.println(ex);
        }
    }

}
