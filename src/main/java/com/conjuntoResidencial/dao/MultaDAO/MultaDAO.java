/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.MultaDAO;

import com.conjuntoResidencial.model.Multa;

import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface MultaDAO {
    
    List<Multa> findAll();
    
    Multa findById(Integer id);
    
    Multa save(Multa multa);
    
    void delete(Multa poll);
    
    void deleteById(Integer id);
    
    Multa update(Multa poll);
    
}
