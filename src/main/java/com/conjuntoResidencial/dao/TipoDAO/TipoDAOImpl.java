/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.TipoDAO;

import com.conjuntoResidencial.dao.AbstractDAO;
import com.conjuntoResidencial.model.Tipo;
import java.util.List;
import javax.transaction.Transactional;

/**
 *
 * @author Carlos
 */
public class TipoDAOImpl extends AbstractDAO implements TipoDAO{
    
     public TipoDAOImpl() {
        super(Tipo.class);
    }

    public List<Tipo> findAll() {
        return (List<Tipo>)super.findAll();
    }

    public Tipo findById(Integer id) {
        return (Tipo) super.findByKey(id);
    }

    @Transactional
    public Tipo save(Tipo tipo) {
        super.save(tipo);
        return (Tipo) super.findByKey(tipo.getId());
    }

    public void delete(Tipo tipo) {
        super.delete(tipo);
    }

    public void deleteById(Integer id) {
        super.deleteByKey(id);
    }

    @Transactional
    public Tipo update(Tipo tipo) {
        return (Tipo) super.update(tipo);
    }
    
    
}
