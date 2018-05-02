/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.PropietarioDAO;

import com.conjuntoResidencial.dao.AbstractDAO;
import com.conjuntoResidencial.model.Propietario;
import com.conjuntoResidencial.model.PropietarioPK;
import java.util.List;
import javax.transaction.Transactional;

/**
 *
 * @author Carlos
 */
public class PropietarioDAOImpl extends AbstractDAO implements PropietarioDAO{
    
     public PropietarioDAOImpl() {
        super(Propietario.class);
    }

    public List<Propietario> findAll() {
        return (List<Propietario>) super.findAll();
    }

    public Propietario findById(PropietarioPK id) {
        return (Propietario)super.findByKey(id);
    }

    @Transactional
    public Propietario save(Propietario propietario) {
        super.save(propietario);
        return this.findById(propietario.getPropietarioPK());
    }

    public void delete(Propietario propietario) {
        super.delete(propietario);
    }

    public void deleteById(PropietarioPK id) {
        super.deleteByKey(id);
    }

    @Transactional
    public Propietario update(Propietario propietario) {
        return (Propietario) super.update(propietario);
    } 



  
}
    

