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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "grupofamiliar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupofamiliar.findAll", query = "SELECT g FROM Grupofamiliar g")
    , @NamedQuery(name = "Grupofamiliar.findById", query = "SELECT g FROM Grupofamiliar g WHERE g.id = :id")
    , @NamedQuery(name = "Grupofamiliar.findByDocumento", query = "SELECT g FROM Grupofamiliar g WHERE g.documento = :documento")
    , @NamedQuery(name = "Grupofamiliar.findByNombre", query = "SELECT g FROM Grupofamiliar g WHERE g.nombre = :nombre")
    , @NamedQuery(name = "Grupofamiliar.findByFechanacimiento", query = "SELECT g FROM Grupofamiliar g WHERE g.fechanacimiento = :fechanacimiento")
    , @NamedQuery(name = "Grupofamiliar.findByCelular", query = "SELECT g FROM Grupofamiliar g WHERE g.celular = :celular")})
public class Grupofamiliar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "documento")
    private String documento;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fechanacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;
    @Column(name = "celular")
    private String celular;
    @JoinColumn(name = "parentesco", referencedColumnName = "id")
    @ManyToOne
    private Parentesco parentesco;
    @JoinColumn(name = "cabeza", referencedColumnName = "documento")
    @ManyToOne
    private Persona cabeza;

    public Grupofamiliar() {
    }

    public Grupofamiliar(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Parentesco getParentesco() {
        return parentesco;
    }

    public void setParentesco(Parentesco parentesco) {
        this.parentesco = parentesco;
    }

    public Persona getCabeza() {
        return cabeza;
    }

    public void setCabeza(Persona cabeza) {
        this.cabeza = cabeza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupofamiliar)) {
            return false;
        }
        Grupofamiliar other = (Grupofamiliar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Grupofamiliar[ id=" + id + " ]";
    }
    
}
