/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.GrupoFamiliarDAO;

import com.conjuntoResidencial.model.Grupofamiliar;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface GrupoFamiliarDAO {
      List<Grupofamiliar> findAll();
    
    Grupofamiliar findById(Integer id);
    
    Grupofamiliar save(Grupofamiliar grufa);
    
    void delete(Grupofamiliar poll);
    
    void deleteById(Integer id);
    
    Grupofamiliar update(Grupofamiliar poll);
}
