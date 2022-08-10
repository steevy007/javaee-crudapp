/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.steevelinformaticien.javacrud.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.steevelinformaticien.javacrud.dao.UserDao;
import com.steevelinformaticien.javacrud.jsonmodel.JsonReponse;
import com.steevelinformaticien.javacrud.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PEPECELL
 */
@WebServlet(name = "Signup", urlPatterns = {"/signup"})
public class Signup extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        PrintWriter out = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        UserDao daouser = new UserDao();
        //create user
        User user = new User(request.getParameter("username"), request.getParameter("email"), request.getParameter("phone"), request.getParameter("password"));

        //verification
        if (daouser.verifyIfEmailExist(user.getEmail())) {
            JsonReponse json = new JsonReponse(false, "Email Already exist");
            mapper.writeValue(out, json);
        } else if (daouser.verifyIfUsernameExist(user.getUsername())) {
            JsonReponse json = new JsonReponse(false, "Username already exist");
            mapper.writeValue(out, json);
        } else {

            // add to database
            daouser.save(user);
            JsonReponse json = new JsonReponse(true, "user add");
            //return all user
            //String message="{\"status\":true,\"data\":"+daouser.getAll()+"}";

            mapper.writeValue(out, json);

        }

    }

}
