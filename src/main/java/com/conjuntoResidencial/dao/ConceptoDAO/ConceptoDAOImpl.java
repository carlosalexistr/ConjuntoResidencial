/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.ConceptoDAO;

import com.conjuntoResidencial.dao.AbstractDAO;
import com.conjuntoResidencial.model.Cargo;
import com.conjuntoResidencial.model.Concepto;
import java.util.List;
import javax.transaction.Transactional;

/**
 *
 * @author Julian Olarte Torres
 */
public class ConceptoDAOImpl extends AbstractDAO implements ConceptoDAO {

    public ConceptoDAOImpl() {
        super(Concepto.class);
    }

    public List<Concepto> findAll() {
        return (List<Concepto>) super.findAll();
    }

    public Concepto findById(Integer id) {
        return (Concepto)super.findByKey(id);
    }

    @Transactional
    public Concepto save(Concepto concepto) {
        super.save(concepto);
        return this.findById(concepto.getId());
    }

    public void delete(Concepto concepto) {
        super.delete(concepto);
    }

    public void deleteById(Integer id) {
        super.deleteByKey(id);
    }

    @Transactional
    public Concepto update(Concepto concepto) {
        return (Concepto)super.update(concepto);
    }

    
}
