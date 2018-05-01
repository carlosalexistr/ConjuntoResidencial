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
@Table(name = "consejo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consejo.findAll", query = "SELECT c FROM Consejo c")
    , @NamedQuery(name = "Consejo.findByPersona", query = "SELECT c FROM Consejo c WHERE c.consejoPK.persona = :persona")
    , @NamedQuery(name = "Consejo.findByCargo", query = "SELECT c FROM Consejo c WHERE c.consejoPK.cargo = :cargo")
    , @NamedQuery(name = "Consejo.findByFechainicio", query = "SELECT c FROM Consejo c WHERE c.consejoPK.fechainicio = :fechainicio")
    , @NamedQuery(name = "Consejo.findByFechafin", query = "SELECT c FROM Consejo c WHERE c.fechafin = :fechafin")})
public class Consejo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConsejoPK consejoPK;
    @Column(name = "fechafin")
    @Temporal(TemporalType.DATE)
    private Date fechafin;
    @JoinColumn(name = "cargo", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cargo cargo1;
    @JoinColumn(name = "persona", referencedColumnName = "documento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona1;

    public Consejo() {
    }

    public Consejo(ConsejoPK consejoPK) {
        this.consejoPK = consejoPK;
    }

    public Consejo(String persona, int cargo, Date fechainicio) {
        this.consejoPK = new ConsejoPK(persona, cargo, fechainicio);
    }

    public ConsejoPK getConsejoPK() {
        return consejoPK;
    }

    public void setConsejoPK(ConsejoPK consejoPK) {
        this.consejoPK = consejoPK;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public Cargo getCargo1() {
        return cargo1;
    }

    public void setCargo1(Cargo cargo1) {
        this.cargo1 = cargo1;
    }

    public Persona getPersona1() {
        return persona1;
    }

    public void setPersona1(Persona persona1) {
        this.persona1 = persona1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consejoPK != null ? consejoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consejo)) {
            return false;
        }
        Consejo other = (Consejo) object;
        if ((this.consejoPK == null && other.consejoPK != null) || (this.consejoPK != null && !this.consejoPK.equals(other.consejoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Consejo[ consejoPK=" + consejoPK + " ]";
    }
    
}
