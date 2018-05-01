/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.ConsejoDAO;

import com.conjuntoResidencial.dao.AbstractDAO;
import com.conjuntoResidencial.model.Cargo;
import com.conjuntoResidencial.model.Consejo;
import com.conjuntoResidencial.model.ConsejoPK;
import java.util.List;
import javax.transaction.Transactional;

/**
 *
 * @author Julian Olarte Torres
 */
public class ConsejoDAOImpl extends AbstractDAO implements ConsejoDAO {

    public ConsejoDAOImpl() {
        super(Consejo.class);
    }

    public List<Consejo> findAll() {
        return (List<Consejo>) super.findAll();
    }

    public Consejo findById(ConsejoPK id) {
        return (Consejo) super.findByKey(id);
    }

    public Consejo save(Consejo consejo) {
        super.save(consejo);
        return this.findById(consejo.getConsejoPK());
    }

    public void delete(Consejo consejo) {
        super.delete(consejo);
    }

    public void deleteById(ConsejoPK id) {
        super.deleteByKey(id);
    }

    public Consejo update(Consejo consejo) {
        return (Consejo) super.update(consejo);
    }

    
}
