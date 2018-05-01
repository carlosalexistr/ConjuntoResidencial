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
@Table(name = "detallerecibo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallerecibo.findAll", query = "SELECT d FROM Detallerecibo d")
    , @NamedQuery(name = "Detallerecibo.findByRecibo", query = "SELECT d FROM Detallerecibo d WHERE d.detallereciboPK.recibo = :recibo")
    , @NamedQuery(name = "Detallerecibo.findByConcepto", query = "SELECT d FROM Detallerecibo d WHERE d.detallereciboPK.concepto = :concepto")
    , @NamedQuery(name = "Detallerecibo.findByValor", query = "SELECT d FROM Detallerecibo d WHERE d.valor = :valor")
    , @NamedQuery(name = "Detallerecibo.findByObservacion", query = "SELECT d FROM Detallerecibo d WHERE d.observacion = :observacion")
    , @NamedQuery(name = "Detallerecibo.findByUsuario", query = "SELECT d FROM Detallerecibo d WHERE d.usuario = :usuario")})
public class Detallerecibo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetallereciboPK detallereciboPK;
    @Column(name = "valor")
    private Integer valor;
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "usuario")
    private String usuario;
    @JoinColumn(name = "concepto", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Concepto concepto1;
    @JoinColumn(name = "recibo", referencedColumnName = "numero", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Recibo recibo1;

    public Detallerecibo() {
    }

    public Detallerecibo(DetallereciboPK detallereciboPK) {
        this.detallereciboPK = detallereciboPK;
    }

    public Detallerecibo(int recibo, int concepto) {
        this.detallereciboPK = new DetallereciboPK(recibo, concepto);
    }

    public DetallereciboPK getDetallereciboPK() {
        return detallereciboPK;
    }

    public void setDetallereciboPK(DetallereciboPK detallereciboPK) {
        this.detallereciboPK = detallereciboPK;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Concepto getConcepto1() {
        return concepto1;
    }

    public void setConcepto1(Concepto concepto1) {
        this.concepto1 = concepto1;
    }

    public Recibo getRecibo1() {
        return recibo1;
    }

    public void setRecibo1(Recibo recibo1) {
        this.recibo1 = recibo1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detallereciboPK != null ? detallereciboPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallerecibo)) {
            return false;
        }
        Detallerecibo other = (Detallerecibo) object;
        if ((this.detallereciboPK == null && other.detallereciboPK != null) || (this.detallereciboPK != null && !this.detallereciboPK.equals(other.detallereciboPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Detallerecibo[ detallereciboPK=" + detallereciboPK + " ]";
    }
    
}
