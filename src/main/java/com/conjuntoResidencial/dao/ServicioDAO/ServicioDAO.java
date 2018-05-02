/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.ServicioDAO;

import com.conjuntoResidencial.model.Servicio;
import java.util.List;

/**
 *
 * @author Carlos
 */
public interface ServicioDAO {
    
     List<Servicio> findAll();
    
    Servicio findById(Integer id);
    
    Servicio save(Servicio servicio);
    
    void delete(Servicio poll);
    
    void deleteById(Integer id);
    
    Servicio update(Servicio poll);
    
    
}
