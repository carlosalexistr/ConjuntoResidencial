/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.PersonaDAO;


import com.conjuntoResidencial.model.Persona;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface PersonaDAO {
        List<Persona> findAll();
    
    Persona findById(String cc);
    
    Persona save(Persona per);
    
    void delete(Persona per);
    
    void deleteById(String cc);
    
    Persona update(Persona per);
}
