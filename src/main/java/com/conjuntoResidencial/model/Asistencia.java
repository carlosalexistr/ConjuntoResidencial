/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Julian Olarte Torres
 */
@Entity
@Table(name = "asistencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asistencia.findAll", query = "SELECT a FROM Asistencia a")
    , @NamedQuery(name = "Asistencia.findByAsamblea", query = "SELECT a FROM Asistencia a WHERE a.asistenciaPK.asamblea = :asamblea")
    , @NamedQuery(name = "Asistencia.findByVivienda", query = "SELECT a FROM Asistencia a WHERE a.asistenciaPK.vivienda = :vivienda")
    , @NamedQuery(name = "Asistencia.findByAsistio", query = "SELECT a FROM Asistencia a WHERE a.asistio = :asistio")
    , @NamedQuery(name = "Asistencia.findByObservacion", query = "SELECT a FROM Asistencia a WHERE a.observacion = :observacion")})
public class Asistencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AsistenciaPK asistenciaPK;
    @Column(name = "asistio")
    private Boolean asistio;
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "asamblea", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Asamblea asamblea1;
    @JoinColumn(name = "vivienda", referencedColumnName = "numero", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Vivienda vivienda1;

    public Asistencia() {
    }

    public Asistencia(AsistenciaPK asistenciaPK) {
        this.asistenciaPK = asistenciaPK;
    }

    public Asistencia(int asamblea, int vivienda) {
        this.asistenciaPK = new AsistenciaPK(asamblea, vivienda);
    }

    public AsistenciaPK getAsistenciaPK() {
        return asistenciaPK;
    }

    public void setAsistenciaPK(AsistenciaPK asistenciaPK) {
        this.asistenciaPK = asistenciaPK;
    }

    public Boolean getAsistio() {
        return asistio;
    }

    public void setAsistio(Boolean asistio) {
        this.asistio = asistio;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Asamblea getAsamblea1() {
        return asamblea1;
    }

    public void setAsamblea1(Asamblea asamblea1) {
        this.asamblea1 = asamblea1;
    }

    public Vivienda getVivienda1() {
        return vivienda1;
    }

    public void setVivienda1(Vivienda vivienda1) {
        this.vivienda1 = vivienda1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asistenciaPK != null ? asistenciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asistencia)) {
            return false;
        }
        Asistencia other = (Asistencia) object;
        if ((this.asistenciaPK == null && other.asistenciaPK != null) || (this.asistenciaPK != null && !this.asistenciaPK.equals(other.asistenciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Asistencia[ asistenciaPK=" + asistenciaPK + " ]";
    }
    
}
