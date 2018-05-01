/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.AsambleaDAO;

import com.conjuntoResidencial.dao.AbstractDAO;
import com.conjuntoResidencial.model.Asamblea;
import java.util.List;
import javax.transaction.Transactional;

/**
 *
 * @author Julian Olarte Torres
 */
public class AsambleaDAOImpl extends AbstractDAO implements AsambleaDAO {

    public AsambleaDAOImpl() {
        super(Asamblea.class);
    }

    public List<Asamblea> findAll() {
        return (List<Asamblea>)super.findAll();
    }

    public Asamblea findById(Integer id) {
        return (Asamblea) super.findByKey(id);
    }

    @Transactional
    public Asamblea save(Asamblea asamblea) {
        super.save(asamblea);
        return (Asamblea) super.findByKey(asamblea.getId());
    }

    public void delete(Asamblea asamblea) {
        super.delete(asamblea);
    }

    public void deleteById(Integer id) {
        super.deleteByKey(id);
    }

    @Transactional
    public Asamblea update(Asamblea asamblea) {
        return (Asamblea) super.update(asamblea);
    }
    
}
