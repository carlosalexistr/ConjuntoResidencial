/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.MultaDAO;

import com.conjuntoResidencial.dao.AbstractDAO;
import com.conjuntoResidencial.model.Grupofamiliar;
import com.conjuntoResidencial.model.Multa;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class MultaDAOImpl extends AbstractDAO implements MultaDAO {

    public MultaDAOImpl() {
        super(Multa.class);
    }

    public List<Multa> findAll() {
        return (List<Multa>)super.findAll(); 
    }

    public Multa findById(Integer id) {
        return (Multa) super.findByKey(id);
    }

    public Multa save(Multa multa) {
       super.save(multa);
        System.out.println("guardo una Multa");
        return (Multa) super.findByKey(multa.getNumero());
    }

    public void delete(Multa poll) {
        super.delete(poll);
    }

    public void deleteById(Integer id) {
        super.deleteByKey(id);
    }

    public Multa update(Multa poll) {
        return (Multa) super.update(poll);
    }
    
    
    
}
