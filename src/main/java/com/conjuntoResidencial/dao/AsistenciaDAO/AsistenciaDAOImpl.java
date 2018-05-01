/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao.AsistenciaDAO;

import com.conjuntoResidencial.dao.AbstractDAO;
import com.conjuntoResidencial.model.Asistencia;
import com.conjuntoResidencial.model.AsistenciaPK;
import java.util.List;
import javax.transaction.Transactional;

/**
 *
 * @author Julian Olarte Torres
 */
public class AsistenciaDAOImpl extends AbstractDAO implements AsistenciaDAO {

    public AsistenciaDAOImpl() {
        super(Asistencia.class);
    }

    public List<Asistencia> findAll() {
        return (List<Asistencia>) super.findAll();
    }

    public Asistencia findById(AsistenciaPK id) {
        return (Asistencia)super.findByKey(id);
    }

    @Transactional
    public Asistencia save(Asistencia asistencia) {
        super.save(asistencia);
        return this.findById(asistencia.getAsistenciaPK());
    }

    public void delete(Asistencia asistencia) {
        super.delete(asistencia);
    }

    public void deleteById(AsistenciaPK id) {
        super.deleteByKey(id);
    }

    @Transactional
    public Asistencia update(Asistencia asistencia) {
        return (Asistencia) super.update(asistencia);
    } 
}
