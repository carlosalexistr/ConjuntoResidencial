/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Julian Olarte Torres
 */
@Entity
@Table(name = "vivienda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vivienda.findAll", query = "SELECT v FROM Vivienda v")
    , @NamedQuery(name = "Vivienda.findByNumero", query = "SELECT v FROM Vivienda v WHERE v.numero = :numero")
    , @NamedQuery(name = "Vivienda.findByObservacion", query = "SELECT v FROM Vivienda v WHERE v.observacion = :observacion")})
public class Vivienda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "observacion")
    private String observacion;
    @OneToMany(mappedBy = "vivienda")
    private List<Recibo> reciboList;
    @JoinColumn(name = "responsable", referencedColumnName = "documento")
    @ManyToOne
    private Persona responsable;
    @JoinColumn(name = "tipo", referencedColumnName = "id")
    @ManyToOne
    private Tipo tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vivienda1")
    private List<Propietario> propietarioList;
    @OneToMany(mappedBy = "vivienda")
    private List<Multa> multaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vivienda1")
    private List<Inquilino> inquilinoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vivienda1")
    private List<Asistencia> asistenciaList;
    @OneToMany(mappedBy = "vivienda")
    private List<Solicitud> solicitudList;

    public Vivienda() {
    }

    public Vivienda(Integer numero) {
        this.numero = numero;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @XmlTransient
    public List<Recibo> getReciboList() {
        return reciboList;
    }

    public void setReciboList(List<Recibo> reciboList) {
        this.reciboList = reciboList;
    }

    public Persona getResponsable() {
        return responsable;
    }

    public void setResponsable(Persona responsable) {
        this.responsable = responsable;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Propietario> getPropietarioList() {
        return propietarioList;
    }

    public void setPropietarioList(List<Propietario> propietarioList) {
        this.propietarioList = propietarioList;
    }

    @XmlTransient
    public List<Multa> getMultaList() {
        return multaList;
    }

    public void setMultaList(List<Multa> multaList) {
        this.multaList = multaList;
    }

    @XmlTransient
    public List<Inquilino> getInquilinoList() {
        return inquilinoList;
    }

    public void setInquilinoList(List<Inquilino> inquilinoList) {
        this.inquilinoList = inquilinoList;
    }

    @XmlTransient
    public List<Asistencia> getAsistenciaList() {
        return asistenciaList;
    }

    public void setAsistenciaList(List<Asistencia> asistenciaList) {
        this.asistenciaList = asistenciaList;
    }

    @XmlTransient
    public List<Solicitud> getSolicitudList() {
        return solicitudList;
    }

    public void setSolicitudList(List<Solicitud> solicitudList) {
        this.solicitudList = solicitudList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vivienda)) {
            return false;
        }
        Vivienda other = (Vivienda) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Vivienda[ numero=" + numero + " ]";
    }
    
}
