/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.InquilinoDAO;

import com.conjuntoResidencial.model.AsistenciaPK;
import com.conjuntoResidencial.model.Inquilino;
import com.conjuntoResidencial.model.InquilinoPK;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface InquilinoDAO {
    List<Inquilino> findAll();
    
    Inquilino findById(InquilinoPK id);
    
    Inquilino save(Inquilino inqui);
    
    void delete(Inquilino poll);
    
    void deleteById(InquilinoPK id);
    
    Inquilino update(Inquilino poll);
}
