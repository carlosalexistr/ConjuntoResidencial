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
@Table(name = "inquilino")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inquilino.findAll", query = "SELECT i FROM Inquilino i")
    , @NamedQuery(name = "Inquilino.findByVivienda", query = "SELECT i FROM Inquilino i WHERE i.inquilinoPK.vivienda = :vivienda")
    , @NamedQuery(name = "Inquilino.findByPersona", query = "SELECT i FROM Inquilino i WHERE i.inquilinoPK.persona = :persona")
    , @NamedQuery(name = "Inquilino.findByFechainicio", query = "SELECT i FROM Inquilino i WHERE i.inquilinoPK.fechainicio = :fechainicio")
    , @NamedQuery(name = "Inquilino.findByFechafin", query = "SELECT i FROM Inquilino i WHERE i.fechafin = :fechafin")
    , @NamedQuery(name = "Inquilino.findByResponsable", query = "SELECT i FROM Inquilino i WHERE i.responsable = :responsable")})
public class Inquilino implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InquilinoPK inquilinoPK;
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

    public Inquilino() {
    }

    public Inquilino(InquilinoPK inquilinoPK) {
        this.inquilinoPK = inquilinoPK;
    }

    public Inquilino(int vivienda, String persona, Date fechainicio) {
        this.inquilinoPK = new InquilinoPK(vivienda, persona, fechainicio);
    }

    public InquilinoPK getInquilinoPK() {
        return inquilinoPK;
    }

    public void setInquilinoPK(InquilinoPK inquilinoPK) {
        this.inquilinoPK = inquilinoPK;
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
        hash += (inquilinoPK != null ? inquilinoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inquilino)) {
            return false;
        }
        Inquilino other = (Inquilino) object;
        if ((this.inquilinoPK == null && other.inquilinoPK != null) || (this.inquilinoPK != null && !this.inquilinoPK.equals(other.inquilinoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Inquilino[ inquilinoPK=" + inquilinoPK + " ]";
    }
    
}
