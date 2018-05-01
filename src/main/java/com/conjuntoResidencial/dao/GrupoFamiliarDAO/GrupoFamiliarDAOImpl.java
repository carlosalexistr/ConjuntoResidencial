/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.GrupoFamiliarDAO;

import com.conjuntoResidencial.dao.AbstractDAO;
import com.conjuntoResidencial.model.Grupofamiliar;
import java.util.List;
import javax.transaction.Transactional;

/**
 *
 * @author DELL
 */
public class GrupoFamiliarDAOImpl extends AbstractDAO implements GrupoFamiliarDAO{

    public GrupoFamiliarDAOImpl() {
        super(Grupofamiliar.class);
    }

    public List<Grupofamiliar> findAll() {
    return (List<Grupofamiliar>)super.findAll();       
    }

    public Grupofamiliar findById(Integer id) {
    return (Grupofamiliar) super.findByKey(id);
    }
    
  @Transactional
    public Grupofamiliar save(Grupofamiliar grufa) {
    super.save(grufa);
        return (Grupofamiliar) super.findByKey(grufa.getId());    
    }

    public void delete(Grupofamiliar poll) {
    super.delete(poll);
    }

    public void deleteById(Integer id) {
    super.deleteByKey(id);    
    }

    public Grupofamiliar update(Grupofamiliar poll) {
    return (Grupofamiliar) super.update(poll);   
    }

    
}
