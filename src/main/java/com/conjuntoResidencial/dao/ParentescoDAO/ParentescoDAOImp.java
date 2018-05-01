/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.ParentescoDAO;

import com.conjuntoResidencial.dao.AbstractDAO;
import com.conjuntoResidencial.model.Parentesco;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class ParentescoDAOImp extends AbstractDAO implements ParentescoDAO {

    public ParentescoDAOImp() {
        super(Parentesco.class);
    }

    public List<Parentesco> findAll() {
            return (List<Parentesco>)super.findAll();       

    }

    public Parentesco findById(Integer id) {
        
            return (Parentesco) super.findByKey(id);

    }

    public Parentesco save(Parentesco par) {
        super.save(par);
        return (Parentesco) super.findByKey(par.getId());  
    }

    public void delete(Parentesco poll) {
         super.delete(poll);
    }

    public void deleteById(Integer id) {
         super.deleteByKey(id);  
    }

    public Parentesco update(Parentesco poll) {
         return (Parentesco) super.update(poll); 
    }
    
}
