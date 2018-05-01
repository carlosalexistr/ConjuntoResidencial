/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.InquilinoDAO;

import com.conjuntoResidencial.dao.AbstractDAO;
import com.conjuntoResidencial.model.Inquilino;
import com.conjuntoResidencial.model.InquilinoPK;
import java.util.List;
import javax.transaction.Transactional;

/**
 *
 * @author DELL
 */
public class InquilinoDAOImpl extends AbstractDAO implements InquilinoDAO {
    

    public InquilinoDAOImpl() {
        super(Inquilino.class);
    }

    public List<Inquilino> findAll() {
    return (List<Inquilino>)super.findAll();       
    }

    public Inquilino findById(InquilinoPK id) {
    return (Inquilino) super.findByKey(id);
    }
    
  @Transactional
    public Inquilino save(Inquilino inq) {
    super.save(inq);       
    return (Inquilino) super.findByKey(inq.getInquilinoPK());    
    
    }

    public void delete(Inquilino poll) {
    super.delete(poll);
    }

    public void deleteById(InquilinoPK id) {
    super.deleteByKey(id);    
    }

    public Inquilino update(Inquilino poll) {
    return (Inquilino) super.update(poll);   
    }

    
}
