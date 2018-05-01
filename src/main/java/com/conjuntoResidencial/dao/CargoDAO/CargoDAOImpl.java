/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.CargoDAO;

import com.conjuntoResidencial.dao.AbstractDAO;
import com.conjuntoResidencial.model.Cargo;
import java.util.List;
import javax.transaction.Transactional;

/**
 *
 * @author Julian Olarte Torres
 */
public class CargoDAOImpl extends AbstractDAO implements CargoDAO {

    public CargoDAOImpl() {
        super(Cargo.class);
    }

    public List<Cargo> findAll() {
        return (List<Cargo>) super.findAll();
    }

    public Cargo findById(Integer id) {
        return (Cargo)super.findByKey(id);
    }

    @Transactional
    public Cargo save(Cargo cargo) {
        super.save(cargo);
        return this.findById(cargo.getId());
    }

    public void delete(Cargo cargo) {
        super.delete(cargo);
    }

    public void deleteById(Integer id) {
        super.deleteByKey(id);
    }

    @Transactional
    public Cargo update(Cargo cargo) {
        return (Cargo)super.update(cargo);
    }

    
}
