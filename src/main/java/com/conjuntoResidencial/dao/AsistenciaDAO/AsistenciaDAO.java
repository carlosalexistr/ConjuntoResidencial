/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.AsistenciaDAO;

import com.conjuntoResidencial.model.Asistencia;
import com.conjuntoResidencial.model.AsistenciaPK;
import java.util.List;

/**
 *
 * @author Julian Olarte Torres
 */
public interface AsistenciaDAO {
    
    List<Asistencia> findAll();
    
    Asistencia findById(AsistenciaPK id);
    
    Asistencia save(Asistencia asistencia);
    
    void delete(Asistencia asistencia);
    
    void deleteById(AsistenciaPK id);
    
    Asistencia update(Asistencia asistencia);
    
}
