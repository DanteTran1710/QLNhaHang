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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "mon_an")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MonAn.findAll", query = "SELECT m FROM MonAn m"),
    @NamedQuery(name = "MonAn.findByIdMonAn", query = "SELECT m FROM MonAn m WHERE m.idMonAn = :idMonAn"),
    @NamedQuery(name = "MonAn.findByTenMonAn", query = "SELECT m FROM MonAn m WHERE m.tenMonAn = :tenMonAn"),
    @NamedQuery(name = "MonAn.findByGiaMonAn", query = "SELECT m FROM MonAn m WHERE m.giaMonAn = :giaMonAn"),
    @NamedQuery(name = "MonAn.findByAnhMonAn", query = "SELECT m FROM MonAn m WHERE m.anhMonAn = :anhMonAn")})
public class MonAn implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMonAn")
    private Integer idMonAn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tenMonAn")
    private String tenMonAn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "giaMonAn")
    private long giaMonAn;
    @Size(max = 100)
    @Column(name = "anhMonAn")
    private String anhMonAn;
    @JoinColumn(name = "maLoaiMon", referencedColumnName = "idLoaiMon")
    @ManyToOne(optional = false)
    private LoaiMon maLoaiMon;
    
     @Transient
    private  MultipartFile file;


    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public MonAn() {
    }

    public MonAn(Integer idMonAn) {
        this.idMonAn = idMonAn;
    }

    public MonAn(Integer idMonAn, String tenMonAn, long giaMonAn) {
        this.idMonAn = idMonAn;
        this.tenMonAn = tenMonAn;
        this.giaMonAn = giaMonAn;
    }

    public Integer getIdMonAn() {
        return idMonAn;
    }

    public void setIdMonAn(Integer idMonAn) {
        this.idMonAn = idMonAn;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public long getGiaMonAn() {
        return giaMonAn;
    }

    public void setGiaMonAn(long giaMonAn) {
        this.giaMonAn = giaMonAn;
    }

    public String getAnhMonAn() {
        return anhMonAn;
    }

    public void setAnhMonAn(String anhMonAn) {
        this.anhMonAn = anhMonAn;
    }

    public LoaiMon getMaLoaiMon() {
        return maLoaiMon;
    }

    public void setMaLoaiMon(LoaiMon maLoaiMon) {
        this.maLoaiMon = maLoaiMon;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMonAn != null ? idMonAn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MonAn)) {
            return false;
        }
        MonAn other = (MonAn) object;
        if ((this.idMonAn == null && other.idMonAn != null) || (this.idMonAn != null && !this.idMonAn.equals(other.idMonAn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhtc.pojos.MonAn[ idMonAn=" + idMonAn + " ]";
    }
    
}
