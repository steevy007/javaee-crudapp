/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.steevelinformaticien.javacrud.dao.interfaces;

import java.util.List;

/**
 *
 * @author PEPECELL
 */
public interface DAO<T> {
    List<T> getAll();
    
    void save(T t);
    
    void update(T t);
    
    void delete(int id);
}
