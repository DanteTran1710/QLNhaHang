/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "dich_vu")
public class DichVu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDichVu")
    private Integer idDichVu;
    @Column(name = "tenDichVu")
    private String tenDichVu;
    private BigDecimal bangGia;
    private String anhDV;
    private String ghiChu;
    
    @Transient
    private  MultipartFile file;

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

    /**
     * @return the bangGia
     */
    public BigDecimal getBangGia() {
        return bangGia;
    }

    /**
     * @param bangGia the bangGia to set
     */
    public void setBangGia(BigDecimal bangGia) {
        this.bangGia = bangGia;
    }

    /**
     * @return the anhDV
     */
    public String getAnhDV() {
        return anhDV;
    }

    /**
     * @param anhDV the anhDV to set
     */
    public void setAnhDV(String anhDV) {
        this.anhDV = anhDV;
    }

    /**
     * @return the ghiChu
     */
    public String getGhiChu() {
        return ghiChu;
    }

    /**
     * @param ghiChu the ghiChu to set
     */
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }
    
}
