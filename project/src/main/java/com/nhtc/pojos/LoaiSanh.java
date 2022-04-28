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
@Table(name = "loai_sanh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoaiSanh.findAll", query = "SELECT l FROM LoaiSanh l"),
    @NamedQuery(name = "LoaiSanh.findByIdLoaiSanh", query = "SELECT l FROM LoaiSanh l WHERE l.idLoaiSanh = :idLoaiSanh"),
    @NamedQuery(name = "LoaiSanh.findByTenLoaiSanh", query = "SELECT l FROM LoaiSanh l WHERE l.tenLoaiSanh = :tenLoaiSanh")})
public class LoaiSanh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idLoaiSanh")
    private Integer idLoaiSanh;
    @Size(max = 45)
    @Column(name = "tenLoaiSanh")
    private String tenLoaiSanh;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "maLoaiSanh")
    private Collection<SanhTiec> sanhTiecCollection;

    public LoaiSanh() {
    }

    public LoaiSanh(Integer idLoaiSanh) {
        this.idLoaiSanh = idLoaiSanh;
    }

    public Integer getIdLoaiSanh() {
        return idLoaiSanh;
    }

    public void setIdLoaiSanh(Integer idLoaiSanh) {
        this.idLoaiSanh = idLoaiSanh;
    }

    public String getTenLoaiSanh() {
        return tenLoaiSanh;
    }

    public void setTenLoaiSanh(String tenLoaiSanh) {
        this.tenLoaiSanh = tenLoaiSanh;
    }

    @XmlTransient
    public Collection<SanhTiec> getSanhTiecCollection() {
        return sanhTiecCollection;
    }

    public void setSanhTiecCollection(Collection<SanhTiec> sanhTiecCollection) {
        this.sanhTiecCollection = sanhTiecCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLoaiSanh != null ? idLoaiSanh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoaiSanh)) {
            return false;
        }
        LoaiSanh other = (LoaiSanh) object;
        if ((this.idLoaiSanh == null && other.idLoaiSanh != null) || (this.idLoaiSanh != null && !this.idLoaiSanh.equals(other.idLoaiSanh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhtc.pojos.LoaiSanh[ idLoaiSanh=" + idLoaiSanh + " ]";
    }
    
}
