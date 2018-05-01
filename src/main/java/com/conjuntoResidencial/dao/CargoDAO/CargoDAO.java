/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.CargoDAO;

import com.conjuntoResidencial.model.Cargo;
import java.util.List;

/**
 *
 * @author Julian Olarte Torres
 */
public interface CargoDAO {
    
    List<Cargo> findAll();
    
    Cargo findById(Integer id);
    
    Cargo save(Cargo cargo);
    
    void delete(Cargo cargo);
    
    void deleteById(Integer id);
    
    Cargo update(Cargo cargo);
    
}
