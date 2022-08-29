/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steevelinformaticien.javacrud.dao;

import com.steevelinformaticien.javacrud.dao.interfaces.DAO;
import com.steevelinformaticien.javacrud.model.People;
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
public class PeopleDao implements DAO<People> {

    private Connection conn = null;
    private PreparedStatement stm;

    public PeopleDao() {
        conn = SingletonDatabase.getConnection();
    }

    @Override
    public List<People> getAll() {
        List<People> listpeople = new ArrayList();
        try {
            stm = conn.prepareStatement("SELECT * FROM people");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                listpeople.add(new People(rs.getInt("id"), rs.getString("p_nom"), rs.getString("p_prenom"), rs.getString("p_email"), rs.getString("p_country")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listpeople;
    }

    @Override
    public void save(People t) {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            stm = conn.prepareStatement("INSERT INTO people(p_nom,p_prenom,p_email,p_country) VALUES(?,?,?,?)");
            stm.setString(1, t.getNom());
            stm.setString(2, t.getPrenom());
            stm.setString(3, t.getEmail());
            stm.setString(4, t.getPays());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(People t) {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            stm = conn.prepareStatement("UPDATE people SET p_nom=?,p_prenom=?,p_email=?,p_country=? WHERE id=?");
            stm.setString(1, t.getNom());
            stm.setString(2, t.getPrenom());
            stm.setString(3, t.getEmail());
            stm.setString(4, t.getPays());
            stm.setInt(5, t.getId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            stm = conn.prepareStatement("DELETE FROM people WHERE id=?");
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean verifyIfEmailExist(String email) {
        try {
            stm = conn.prepareStatement("SELECT COUNT(*) AS val FROM people WHERE p_email=? ");
            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();
            rs.next();
            if (rs.getInt("val") > 0) {
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }

    public boolean verifyIfAlreadyEmailExist(String oldmail, String newmail) {
        try {
            stm = conn.prepareStatement("SELECT COUNT(*) AS val FROM people WHERE p_email=? AND p_email!=? ");
            stm.setString(1, newmail);
            stm.setString(2, oldmail);
            ResultSet rs = stm.executeQuery();
            rs.next();
            if (rs.getInt("val") > 0) {
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }

    public People getPeopleById(int id) {
        try {
            stm = conn.prepareStatement("SELECT * FROM people WHERE id=?  ");
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return new People(rs.getInt("id"), rs.getString("p_nom"), rs.getString("p_prenom"), rs.getString("p_email"), rs.getString("p_country"));
            }

        } catch (Exception e) {

        }
        return null;
    }

}
