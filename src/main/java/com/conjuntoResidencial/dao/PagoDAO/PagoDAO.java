/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.PagoDAO;

import com.conjuntoResidencial.model.Pago;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface PagoDAO {
    
     List<Pago> findAll();
    
    Pago findById(Integer id);
    
    Pago save(Pago pag);
    
    void delete(Pago poll);
    
    void deleteById(Integer id);
    
    Pago update(Pago poll);
    
}
