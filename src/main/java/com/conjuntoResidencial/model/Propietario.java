/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Julian Olarte Torres
 */
@Entity
@Table(name = "propietario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propietario.findAll", query = "SELECT p FROM Propietario p")
    , @NamedQuery(name = "Propietario.findByVivienda", query = "SELECT p FROM Propietario p WHERE p.propietarioPK.vivienda = :vivienda")
    , @NamedQuery(name = "Propietario.findByPersona", query = "SELECT p FROM Propietario p WHERE p.propietarioPK.persona = :persona")
    , @NamedQuery(name = "Propietario.findByFechainicio", query = "SELECT p FROM Propietario p WHERE p.propietarioPK.fechainicio = :fechainicio")
    , @NamedQuery(name = "Propietario.findByFechafin", query = "SELECT p FROM Propietario p WHERE p.fechafin = :fechafin")
    , @NamedQuery(name = "Propietario.findByResponsable", query = "SELECT p FROM Propietario p WHERE p.responsable = :responsable")})
public class Propietario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PropietarioPK propietarioPK;
    @Column(name = "fechafin")
    @Temporal(TemporalType.DATE)
    private Date fechafin;
    @Column(name = "responsable")
    private Integer responsable;
    @JoinColumn(name = "persona", referencedColumnName = "documento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona1;
    @JoinColumn(name = "vivienda", referencedColumnName = "numero", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Vivienda vivienda1;

    public Propietario() {
    }

    public Propietario(PropietarioPK propietarioPK) {
        this.propietarioPK = propietarioPK;
    }

    public Propietario(int vivienda, String persona, Date fechainicio) {
        this.propietarioPK = new PropietarioPK(vivienda, persona, fechainicio);
    }

    public PropietarioPK getPropietarioPK() {
        return propietarioPK;
    }

    public void setPropietarioPK(PropietarioPK propietarioPK) {
        this.propietarioPK = propietarioPK;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public Integer getResponsable() {
        return responsable;
    }

    public void setResponsable(Integer responsable) {
        this.responsable = responsable;
    }

    public Persona getPersona1() {
        return persona1;
    }

    public void setPersona1(Persona persona1) {
        this.persona1 = persona1;
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
        hash += (propietarioPK != null ? propietarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propietario)) {
            return false;
        }
        Propietario other = (Propietario) object;
        if ((this.propietarioPK == null && other.propietarioPK != null) || (this.propietarioPK != null && !this.propietarioPK.equals(other.propietarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Propietario[ propietarioPK=" + propietarioPK + " ]";
    }
    
}
