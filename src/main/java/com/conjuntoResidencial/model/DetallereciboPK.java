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
public class DetallereciboPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "recibo")
    private int recibo;
    @Basic(optional = false)
    @Column(name = "concepto")
    private int concepto;

    public DetallereciboPK() {
    }

    public DetallereciboPK(int recibo, int concepto) {
        this.recibo = recibo;
        this.concepto = concepto;
    }

    public int getRecibo() {
        return recibo;
    }

    public void setRecibo(int recibo) {
        this.recibo = recibo;
    }

    public int getConcepto() {
        return concepto;
    }

    public void setConcepto(int concepto) {
        this.concepto = concepto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) recibo;
        hash += (int) concepto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallereciboPK)) {
            return false;
        }
        DetallereciboPK other = (DetallereciboPK) object;
        if (this.recibo != other.recibo) {
            return false;
        }
        if (this.concepto != other.concepto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.DetallereciboPK[ recibo=" + recibo + ", concepto=" + concepto + " ]";
    }
    
}
