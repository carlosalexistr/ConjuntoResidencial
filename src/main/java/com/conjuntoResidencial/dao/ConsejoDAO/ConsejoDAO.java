/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.ConsejoDAO;

import com.conjuntoResidencial.model.Consejo;
import com.conjuntoResidencial.model.ConsejoPK;
import java.util.List;

/**
 *
 * @author Julian Olarte Torres
 */
public interface ConsejoDAO {
    
    List<Consejo> findAll();
    
    Consejo findById(ConsejoPK id);
    
    Consejo save(Consejo consejo);
    
    void delete(Consejo consejo);
    
    void deleteById(ConsejoPK id);
    
    Consejo update(Consejo consejo);
    
}
