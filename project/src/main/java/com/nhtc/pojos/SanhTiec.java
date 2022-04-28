/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.pojos;

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
@Table(name = "sanh_tiec")
public class SanhTiec implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSanhTiec")
    private Integer idSanhTiec;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tenSanhTiec")
    private String tenSanhTiec;
    @Column(name = "ngayDatSanh")
    @Temporal(TemporalType.DATE)
    private Date ngayDatSanh;
    @Size(max = 255)
    @Column(name = "anhSanhTiec")
    private String anhSanhTiec;
    @JoinColumn(name = "loaiSanh", referencedColumnName = "idLoaiSanh")
    @ManyToOne(optional = false)
    private LoaiSanh maLoaiSanh;
    
    @Transient
    private  MultipartFile file;


    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public SanhTiec() {
    }

    public SanhTiec(Integer idSanhTiec) {
        this.idSanhTiec = idSanhTiec;
    }

    public SanhTiec(Integer idSanhTiec, String tenSanhTiec) {
        this.idSanhTiec = idSanhTiec;
        this.tenSanhTiec = tenSanhTiec;
    }

    public Integer getIdSanhTiec() {
        return idSanhTiec;
    }

    public void setIdSanhTiec(Integer idSanhTiec) {
        this.idSanhTiec = idSanhTiec;
    }

    public String getTenSanhTiec() {
        return tenSanhTiec;
    }

    public void setTenSanhTiec(String tenSanhTiec) {
        this.tenSanhTiec = tenSanhTiec;
    }

    public Date getNgayDatSanh() {
        return ngayDatSanh;
    }

    public void setNgayDatSanh(Date ngayDatSanh) {
        this.ngayDatSanh = ngayDatSanh;
    }

    public String getAnhSanhTiec() {
        return anhSanhTiec;
    }

    public void setAnhSanhTiec(String anhSanhTiec) {
        this.anhSanhTiec = anhSanhTiec;
    }

    public LoaiSanh getMaLoaiSanh() {
        return maLoaiSanh;
    }

    public void setMaLoaiSanh(LoaiSanh maLoaiSanh) {
        this.maLoaiSanh = maLoaiSanh;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSanhTiec != null ? idSanhTiec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SanhTiec)) {
            return false;
        }
        SanhTiec other = (SanhTiec) object;
        if ((this.idSanhTiec == null && other.idSanhTiec != null) || (this.idSanhTiec != null && !this.idSanhTiec.equals(other.idSanhTiec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhtc.pojos.SanhTiec[ idSanhTiec=" + idSanhTiec + " ]";
    }
    
}
