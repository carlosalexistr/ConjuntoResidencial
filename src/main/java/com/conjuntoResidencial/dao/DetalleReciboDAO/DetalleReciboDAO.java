/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.DetalleReciboDAO;

import com.conjuntoResidencial.model.Detallerecibo;
import com.conjuntoResidencial.model.DetallereciboPK;
import java.util.List;

/**
 *
 * @author Julian Olarte Torres
 */
public interface DetalleReciboDAO {
    
    List<Detallerecibo> findAll();
    
    Detallerecibo findById(DetallereciboPK id);
    
    Detallerecibo save(Detallerecibo detallerecibo);
    
    void delete(Detallerecibo detallerecibo);
    
    void deleteById(DetallereciboPK id);
    
    Detallerecibo update(Detallerecibo detallerecibo);
    
}
