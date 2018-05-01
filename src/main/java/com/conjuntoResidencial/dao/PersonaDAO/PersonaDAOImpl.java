/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.PersonaDAO;

import com.conjuntoResidencial.dao.AbstractDAO;
import com.conjuntoResidencial.model.Persona;
import java.util.List;
import javax.transaction.Transactional;

/**
 *
 * @author DELL
 */
public class PersonaDAOImpl extends AbstractDAO implements PersonaDAO{
    
    
    public PersonaDAOImpl() {
        super(Persona.class);
    }

    public List<Persona> findAll() {
    return (List<Persona>)super.findAll();       
    }

    public Persona findById(String id) {
    return (Persona) super.findByKey(id);
    }
    
  @Transactional
    public Persona save(Persona per) {
    super.save(per);
        return (Persona) super.findByKey(per.getDocumento());    
    }

    public void delete(Persona poll) {
    super.delete(poll);
    }

    public void deleteById(String id) {
    super.deleteByKey(id);    
    }

    public Persona update(Persona per) {
    return (Persona) super.update(per);   
    }

    
}
