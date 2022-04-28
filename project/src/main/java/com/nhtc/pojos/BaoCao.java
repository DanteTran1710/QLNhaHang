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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "bao_cao")
public class BaoCao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBaoCao")
    private Integer idBaoCao;
    @Size(max = 45)
    @Column(name = "doiTuong")
    private String doiTuong;
    @Lob
    @Size(max = 65535)
    @Column(name = "noiDung")
    private String noiDung;
    @JoinColumn(name = "idKhachHang", referencedColumnName = "idKhachHang")
    @ManyToOne
    private KhachHang idKhachHang;

    public BaoCao() {
    }

    public BaoCao(Integer idBaoCao) {
        this.idBaoCao = idBaoCao;
    }

    public Integer getIdBaoCao() {
        return idBaoCao;
    }

    public void setIdBaoCao(Integer idBaoCao) {
        this.idBaoCao = idBaoCao;
    }

    public String getDoiTuong() {
        return doiTuong;
    }

    public void setDoiTuong(String doiTuong) {
        this.doiTuong = doiTuong;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public KhachHang getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(KhachHang idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBaoCao != null ? idBaoCao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BaoCao)) {
            return false;
        }
        BaoCao other = (BaoCao) object;
        if ((this.idBaoCao == null && other.idBaoCao != null) || (this.idBaoCao != null && !this.idBaoCao.equals(other.idBaoCao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhtc.pojos.BaoCao_1[ idBaoCao=" + idBaoCao + " ]";
    }
    
}
