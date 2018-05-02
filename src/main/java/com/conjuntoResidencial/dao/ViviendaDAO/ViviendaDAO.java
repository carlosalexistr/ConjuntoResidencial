/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.ViviendaDAO;

import com.conjuntoResidencial.model.Vivienda;
import java.util.List;

/**
 *
 * @author Carlos
 */
public interface ViviendaDAO {
    
     List<Vivienda> findAll();
    
    Vivienda findById(Integer id);
    
    Vivienda save(Vivienda vivienda);
    
    void delete(Vivienda poll);
    
    void deleteById(Integer id);
    
    Vivienda update(Vivienda poll);
    
    
}
