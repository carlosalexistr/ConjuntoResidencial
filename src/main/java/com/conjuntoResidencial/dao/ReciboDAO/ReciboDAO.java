/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.ReciboDAO;

import com.conjuntoResidencial.model.Recibo;
import java.util.List;

/**
 *
 * @author Carlos
 */
public interface ReciboDAO {
    
    List<Recibo> findAll();
    
    Recibo findById(Integer id);
    
    Recibo save(Recibo recibo);
    
    void delete(Recibo poll);
    
    void deleteById(Integer id);
    
    Recibo update(Recibo poll);
    
    
}
