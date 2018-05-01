/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.PagoDAO;

import com.conjuntoResidencial.dao.AbstractDAO;
import com.conjuntoResidencial.model.Pago;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class PagoDAOImp extends AbstractDAO implements PagoDAO {

    public PagoDAOImp() {
        super(Pago.class);
    }

    public List<Pago> findAll() {
        return (List<Pago>)super.findAll();
    }

    public Pago findById(Integer id) {
        return (Pago) super.findByKey(id);
    }

    public Pago save(Pago pag) {
        super.save(pag);
        return (Pago) super.findByKey(pag.getNumero());
        
    }

    public void delete(Pago poll) {
          super.delete(poll);
    }

    public void deleteById(Integer id) {
        super.deleteByKey(id);
    }

    public Pago update(Pago poll) {
        return (Pago) super.update(poll);
    }
    
}
