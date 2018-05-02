/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.ServicioDAO;

import com.conjuntoResidencial.dao.AbstractDAO;
import com.conjuntoResidencial.model.Servicio;
import java.util.List;
import javax.transaction.Transactional;

/**
 *
 * @author Carlos
 */
public class ServicioDAOImpl extends AbstractDAO implements ServicioDAO{
    
    public ServicioDAOImpl() {
        super(Servicio.class);
    }

    public List<Servicio> findAll() {
        return (List<Servicio>)super.findAll();
    }

    public Servicio findById(Integer id) {
        return (Servicio) super.findByKey(id);
    }

    @Transactional
    public Servicio save(Servicio servicio) {
        super.save(servicio);
        return (Servicio) super.findByKey(servicio.getId());
    }

    public void delete(Servicio servicio) {
        super.delete(servicio);
    }

    public void deleteById(Integer id) {
        super.deleteByKey(id);
    }

    @Transactional
    public Servicio update(Servicio servicio) {
        return (Servicio) super.update(servicio);
    }
    
}
