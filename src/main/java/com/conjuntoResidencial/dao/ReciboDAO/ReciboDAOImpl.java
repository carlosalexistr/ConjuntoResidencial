/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.ReciboDAO;

import com.conjuntoResidencial.dao.AbstractDAO;
import com.conjuntoResidencial.model.Recibo;
import java.util.List;
import javax.transaction.Transactional;

/**
 *
 * @author Carlos
 */
public class ReciboDAOImpl extends AbstractDAO implements ReciboDAO{
    
   public ReciboDAOImpl() {
        super(Recibo.class);
    }

    public List<Recibo> findAll() {
        return (List<Recibo>)super.findAll();
    }

    public Recibo findById(Integer id) {
        return (Recibo) super.findByKey(id);
    }

    @Transactional
    public Recibo save(Recibo recibo) {
        super.save(recibo);
        return (Recibo) super.findByKey(recibo.getNumero());
    }

    public void delete(Recibo recibo) {
        super.delete(recibo);
    }

    public void deleteById(Integer id) {
        super.deleteByKey(id);
    }

    @Transactional
    public Recibo update(Recibo recibo) {
        return (Recibo) super.update(recibo);
    } 
   
}
