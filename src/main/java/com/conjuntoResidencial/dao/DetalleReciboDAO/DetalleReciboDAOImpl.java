/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.DetalleReciboDAO;

import com.conjuntoResidencial.dao.AbstractDAO;
import com.conjuntoResidencial.model.Detallerecibo;
import com.conjuntoResidencial.model.DetallereciboPK;
import java.util.List;
import javax.transaction.Transactional;

/**
 *
 * @author Julian Olarte Torres
 */
public class DetalleReciboDAOImpl extends AbstractDAO implements DetalleReciboDAO {

    public DetalleReciboDAOImpl() {
        super(Detallerecibo.class);
    }

    @Override
    public List<Detallerecibo> findAll() {
        return (List<Detallerecibo>) super.findAll();
    }

    @Override
    public Detallerecibo findById(DetallereciboPK id) {
        return (Detallerecibo) super.findByKey(id);
    }

    @Override
    @Transactional
    public Detallerecibo save(Detallerecibo detallerecibo) {
        super.save(detallerecibo);
        return this.findById(detallerecibo.getDetallereciboPK());
    }

    @Override
    public void delete(Detallerecibo detallerecibo) {
        super.delete(detallerecibo);
    }

    @Override
    public void deleteById(DetallereciboPK id) {
        super.deleteByKey(id);
    }

    @Override
    @Transactional
    public Detallerecibo update(Detallerecibo detallerecibo) {
        return (Detallerecibo) super.update(detallerecibo);
    }

    

    
}
