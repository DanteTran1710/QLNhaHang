/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.pojos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "dich_vu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DichVu.findAll", query = "SELECT d FROM DichVu d"),
    @NamedQuery(name = "DichVu.findByIdDichVu", query = "SELECT d FROM DichVu d WHERE d.idDichVu = :idDichVu"),
    @NamedQuery(name = "DichVu.findByTenDichVu", query = "SELECT d FROM DichVu d WHERE d.tenDichVu = :tenDichVu")})
public class DichVu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDichVu")
    private Integer idDichVu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tenDichVu")
    private String tenDichVu;

    public DichVu() {
    }

    public DichVu(Integer idDichVu) {
        this.idDichVu = idDichVu;
    }

    public DichVu(Integer idDichVu, String tenDichVu) {
        this.idDichVu = idDichVu;
        this.tenDichVu = tenDichVu;
    }

    public Integer getIdDichVu() {
        return idDichVu;
    }

    public void setIdDichVu(Integer idDichVu) {
        this.idDichVu = idDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDichVu != null ? idDichVu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DichVu)) {
            return false;
        }
        DichVu other = (DichVu) object;
        if ((this.idDichVu == null && other.idDichVu != null) || (this.idDichVu != null && !this.idDichVu.equals(other.idDichVu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhtc.pojos.DichVu[ idDichVu=" + idDichVu + " ]";
    }
    
}
