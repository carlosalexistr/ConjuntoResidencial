/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.ParentescoDAO;

import com.conjuntoResidencial.model.Parentesco;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface ParentescoDAO {
    
   List<Parentesco> findAll();
    
    Parentesco findById(Integer id);
    
    Parentesco save(Parentesco par);
    
    void delete(Parentesco poll);
    
    void deleteById(Integer id);
    
    Parentesco update(Parentesco poll);
    
}
