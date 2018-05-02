/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.PropietarioDAO;

import com.conjuntoResidencial.model.Propietario;
import com.conjuntoResidencial.model.PropietarioPK;
import java.util.List;

/**
 *
 * @author Carlos
 */
public interface PropietarioDAO {
    
    List<Propietario> findAll();
    
    Propietario findById(PropietarioPK id);
    
    Propietario save(Propietario propietario);
    
    void delete(Propietario poll);
    
    void deleteById(PropietarioPK id);
     
    Propietario update(Propietario poll);
    
}
