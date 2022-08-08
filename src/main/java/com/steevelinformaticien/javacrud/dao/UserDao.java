/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steevelinformaticien.javacrud.dao;

import com.steevelinformaticien.javacrud.dao.interfaces.DAO;
import com.steevelinformaticien.javacrud.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PEPECELL
 */
public class UserDao implements DAO<User> {

    private Connection conn = null;
    private PreparedStatement stm;
    private ResultSet rs;

    public UserDao() {
        conn = SingletonDatabase.getConnection();
    }

    @Override
    public List<User> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        List<User> listuser = new ArrayList();
        try {
            stm = conn.prepareStatement("SELECT * FROM users");
            rs = stm.executeQuery();
            while (rs.next()) {
                listuser.add(new User(rs.getInt("id"), rs.getString("u_username"), rs.getString("u_email"), rs.getString("u_phone"), rs.getString("u_password"), rs.getString("u_created")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listuser;
    }

    @Override
    public void save(User t) {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            stm = conn.prepareStatement("INSERT INTO users(u_username,u_email,u_phone,u_password)  VALUES(?,?,?,?)");
            stm.setString(1, t.getUsername());
            stm.setString(2, t.getEmail());
            stm.setString(3, t.getPhone());
            stm.setString(4, t.getPassword());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(User t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean verifyIfEmailExist(String email) {
        boolean reponse = false;
        try {
            stm=conn.prepareStatement("SELECT COUNT(*) AS val FROM users WHERE u_email=? ");
            stm.setString(1, email);
            rs=stm.executeQuery();
            rs.next();
            if(rs.getInt("val")>0)
                reponse=true;
        } catch (Exception e) {

        }
        return reponse;
    }
    
    public boolean verifyIfUsernameExist(String username) {
        boolean reponse = false;
        try {
            stm=conn.prepareStatement("SELECT COUNT(*) AS val FROM users WHERE u_username=? ");
            stm.setString(1, username);
            rs=stm.executeQuery();
            rs.next();
            if(rs.getInt("val")>0)
                reponse=true;
        } catch (Exception e) {

        }
        return reponse;
    }

}
