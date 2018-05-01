/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.ConceptoDAO;

import com.conjuntoResidencial.model.Concepto;
import java.util.List;

/**
 *
 * @author Julian Olarte Torres
 */
public interface ConceptoDAO {
    
    List<Concepto> findAll();
    
    Concepto findById(Integer id);
    
    Concepto save(Concepto concepto);
    
    void delete(Concepto concepto);
    
    void deleteById(Integer id);
    
    Concepto update(Concepto concepto);
    
}
