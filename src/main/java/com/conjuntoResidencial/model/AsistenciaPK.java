/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Julian Olarte Torres
 */
@Embeddable
public class AsistenciaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "asamblea")
    private int asamblea;
    @Basic(optional = false)
    @Column(name = "vivienda")
    private int vivienda;

    public AsistenciaPK() {
    }

    public AsistenciaPK(int asamblea, int vivienda) {
        this.asamblea = asamblea;
        this.vivienda = vivienda;
    }

    public int getAsamblea() {
        return asamblea;
    }

    public void setAsamblea(int asamblea) {
        this.asamblea = asamblea;
    }

    public int getVivienda() {
        return vivienda;
    }

    public void setVivienda(int vivienda) {
        this.vivienda = vivienda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) asamblea;
        hash += (int) vivienda;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsistenciaPK)) {
            return false;
        }
        AsistenciaPK other = (AsistenciaPK) object;
        if (this.asamblea != other.asamblea) {
            return false;
        }
        if (this.vivienda != other.vivienda) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.AsistenciaPK[ asamblea=" + asamblea + ", vivienda=" + vivienda + " ]";
    }
    
}
