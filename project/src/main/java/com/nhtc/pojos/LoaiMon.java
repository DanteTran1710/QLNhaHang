/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.pojos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "loai_mon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoaiMon.findAll", query = "SELECT l FROM LoaiMon l"),
    @NamedQuery(name = "LoaiMon.findByIdLoaiMon", query = "SELECT l FROM LoaiMon l WHERE l.idLoaiMon = :idLoaiMon"),
    @NamedQuery(name = "LoaiMon.findByTenLoaiMon", query = "SELECT l FROM LoaiMon l WHERE l.tenLoaiMon = :tenLoaiMon")})
public class LoaiMon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idLoaiMon")
    private Integer idLoaiMon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tenLoaiMon")
    private String tenLoaiMon;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "maLoaiMon")
    private Collection<MonAn> monAnCollection;

    public LoaiMon() {
    }

    public LoaiMon(Integer idLoaiMon) {
        this.idLoaiMon = idLoaiMon;
    }

    public LoaiMon(Integer idLoaiMon, String tenLoaiMon) {
        this.idLoaiMon = idLoaiMon;
        this.tenLoaiMon = tenLoaiMon;
    }

    public Integer getIdLoaiMon() {
        return idLoaiMon;
    }

    public void setIdLoaiMon(Integer idLoaiMon) {
        this.idLoaiMon = idLoaiMon;
    }

    public String getTenLoaiMon() {
        return tenLoaiMon;
    }

    public void setTenLoaiMon(String tenLoaiMon) {
        this.tenLoaiMon = tenLoaiMon;
    }

    @XmlTransient
    public Collection<MonAn> getMonAnCollection() {
        return monAnCollection;
    }

    public void setMonAnCollection(Collection<MonAn> monAnCollection) {
        this.monAnCollection = monAnCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLoaiMon != null ? idLoaiMon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoaiMon)) {
            return false;
        }
        LoaiMon other = (LoaiMon) object;
        if ((this.idLoaiMon == null && other.idLoaiMon != null) || (this.idLoaiMon != null && !this.idLoaiMon.equals(other.idLoaiMon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhtc.pojos.LoaiMon[ idLoaiMon=" + idLoaiMon + " ]";
    }
    
}
