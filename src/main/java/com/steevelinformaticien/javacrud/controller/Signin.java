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
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "Signin", urlPatterns = {"/signin"})
public class Signin extends HttpServlet {

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
        response.setContentType("text/json");
        HttpSession session=request.getSession();
        UserDao dao=new UserDao();
        User user=null;
        PrintWriter out=response.getWriter();
        ObjectMapper mapper=new ObjectMapper();
        if(dao.login(request.getParameter("l_email").toString(),request.getParameter("l_password").toString())){
            ArrayList<User> data=new ArrayList<User>();
            user=(User)dao.getUserByEmail(request.getParameter("l_email"));
            data.add(user);
            JsonReponse json=new JsonReponse(true,"User Connected");
            json.setData(data);
            
            //set session
            session.setAttribute("user",user);
            //RequestDispatcher dispatch=request.getRequestDispatcher("dashboard.jsp");
            mapper.writeValue(out, json);   
            //dispatch.forward(request,response);
        }else{
            JsonReponse json=new JsonReponse(false,"Password OR Email Incorrect");
            mapper.writeValue(out, json); 
        }
    }


}
