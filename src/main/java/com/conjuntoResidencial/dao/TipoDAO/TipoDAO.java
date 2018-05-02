/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.TipoDAO;

import com.conjuntoResidencial.model.Tipo;
import java.util.List;

/**
 *
 * @author Carlos
 */
public interface TipoDAO {
    
     List<Tipo> findAll();
    
    Tipo findById(Integer id);
    
    Tipo save(Tipo tipo);
    
    void delete(Tipo poll);
    
    void deleteById(Integer id);
    
    Tipo update(Tipo poll);
    
    
}
