/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Julian Olarte Torres
 */
@Embeddable
public class InquilinoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "vivienda")
    private int vivienda;
    @Basic(optional = false)
    @Column(name = "persona")
    private String persona;
    @Basic(optional = false)
    @Column(name = "fechainicio")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;

    public InquilinoPK() {
    }

    public InquilinoPK(int vivienda, String persona, Date fechainicio) {
        this.vivienda = vivienda;
        this.persona = persona;
        this.fechainicio = fechainicio;
    }

    public int getVivienda() {
        return vivienda;
    }

    public void setVivienda(int vivienda) {
        this.vivienda = vivienda;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) vivienda;
        hash += (persona != null ? persona.hashCode() : 0);
        hash += (fechainicio != null ? fechainicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InquilinoPK)) {
            return false;
        }
        InquilinoPK other = (InquilinoPK) object;
        if (this.vivienda != other.vivienda) {
            return false;
        }
        if ((this.persona == null && other.persona != null) || (this.persona != null && !this.persona.equals(other.persona))) {
            return false;
        }
        if ((this.fechainicio == null && other.fechainicio != null) || (this.fechainicio != null && !this.fechainicio.equals(other.fechainicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.InquilinoPK[ vivienda=" + vivienda + ", persona=" + persona + ", fechainicio=" + fechainicio + " ]";
    }
    
}
