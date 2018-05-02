/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.ViviendaDAO;

import com.conjuntoResidencial.dao.AbstractDAO;
import com.conjuntoResidencial.model.Vivienda;
import java.util.List;
import javax.transaction.Transactional;

/**
 *
 * @author Carlos
 */
public class ViviendaDAOImpl extends AbstractDAO implements ViviendaDAO{
    
    public ViviendaDAOImpl() {
        super(Vivienda.class);
    }

    public List<Vivienda> findAll() {
        return (List<Vivienda>)super.findAll();
    }

    public Vivienda findById(Integer id) {
        return (Vivienda) super.findByKey(id);
    }

    @Transactional
    public Vivienda save(Vivienda vivienda) {
        super.save(vivienda);
        return (Vivienda) super.findByKey(vivienda.getNumero());
    }

    public void delete(Vivienda vivienda) {
        super.delete(vivienda);
    }

    public void deleteById(Integer id) {
        super.deleteByKey(id);
    }

    @Transactional
    public Vivienda update(Vivienda vivienda) {
        return (Vivienda) super.update(vivienda);
    }
    
}
