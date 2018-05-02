/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.SolicitudDAO;

import com.conjuntoResidencial.dao.AbstractDAO;
import com.conjuntoResidencial.model.Solicitud;
import java.util.List;
import javax.transaction.Transactional;

/**
 *
 * @author Carlos
 */
public class SolicitudDAOImpl extends AbstractDAO implements SolicitudDAO {
    
    public SolicitudDAOImpl() {
        super(Solicitud.class);
    }

    public List<Solicitud> findAll() {
        return (List<Solicitud>)super.findAll();
    }

    public Solicitud findById(Integer id) {
        return (Solicitud) super.findByKey(id);
    }

    @Transactional
    public Solicitud save(Solicitud solicitud) {
        super.save(solicitud);
        return (Solicitud) super.findByKey(solicitud.getNumero());
    }

    public void delete(Solicitud solicitud) {
        super.delete(solicitud);
    }

    public void deleteById(Integer id) {
        super.deleteByKey(id);
    }

    @Transactional
    public Solicitud update(Solicitud solicitud) {
        return (Solicitud) super.update(solicitud);
    }
    
}
