/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.SolicitudDAO;

import com.conjuntoResidencial.model.Solicitud;
import java.util.List;

/**
 *
 * @author Carlos
 */
public interface SolicitudDAO {
    
     List<Solicitud> findAll();
    
    Solicitud findById(Integer id);
    
    Solicitud save(Solicitud solicitud);
    
    void delete(Solicitud poll);
    
    void deleteById(Integer id);
    
    Solicitud update(Solicitud poll);
    
    
}
