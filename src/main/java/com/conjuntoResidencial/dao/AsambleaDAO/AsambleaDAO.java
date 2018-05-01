/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.AsambleaDAO;

import com.conjuntoResidencial.model.Asamblea;
import java.util.List;

/**
 *
 * @author Julian Olarte Torres
 */
public interface AsambleaDAO {
    
    List<Asamblea> findAll();
    
    Asamblea findById(Integer id);
    
    Asamblea save(Asamblea asamblea);
    
    void delete(Asamblea poll);
    
    void deleteById(Integer id);
    
    Asamblea update(Asamblea poll);
    
}
