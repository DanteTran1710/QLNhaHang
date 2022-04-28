/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.pojos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "tai_khoan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TaiKhoan.findAll", query = "SELECT t FROM TaiKhoan t"),
    @NamedQuery(name = "TaiKhoan.findByIdTaiKhoan", query = "SELECT t FROM TaiKhoan t WHERE t.idTaiKhoan = :idTaiKhoan"),
    @NamedQuery(name = "TaiKhoan.findByTenDangNhap", query = "SELECT t FROM TaiKhoan t WHERE t.tenDangNhap = :tenDangNhap"),
    @NamedQuery(name = "TaiKhoan.findByMatKhau", query = "SELECT t FROM TaiKhoan t WHERE t.matKhau = :matKhau"),
    @NamedQuery(name = "TaiKhoan.findByLoaiTaiKhoan", query = "SELECT t FROM TaiKhoan t WHERE t.loaiTaiKhoan = :loaiTaiKhoan")})
public class TaiKhoan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTaiKhoan")
    private Integer idTaiKhoan;
    @Size(max = 45)
    @Column(name = "tenDangNhap")
    private String tenDangNhap;
    @Size(max = 100)
    @Column(name = "matKhau")
    private String matKhau;
    @Size(max = 45)
    @Column(name = "loaiTaiKhoan")
    private String loaiTaiKhoan;
    @OneToMany(mappedBy = "taiKhoan")
    private Collection<NhanVien> nhanVienCollection;
    @OneToOne(mappedBy = "taiKhoan", fetch = FetchType.LAZY)
    private KhachHang khachHang;

    public TaiKhoan() {
    }

    public TaiKhoan(Integer idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public Integer getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(Integer idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getLoaiTaiKhoan() {
        return loaiTaiKhoan;
    }

    public void setLoaiTaiKhoan(String loaiTaiKhoan) {
        this.loaiTaiKhoan = loaiTaiKhoan;
    }

    @XmlTransient
    public Collection<NhanVien> getNhanVienCollection() {
        return nhanVienCollection;
    }

    public void setNhanVienCollection(Collection<NhanVien> nhanVienCollection) {
        this.nhanVienCollection = nhanVienCollection;
    }

    @XmlTransient
    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTaiKhoan != null ? idTaiKhoan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaiKhoan)) {
            return false;
        }
        TaiKhoan other = (TaiKhoan) object;
        if ((this.idTaiKhoan == null && other.idTaiKhoan != null) || (this.idTaiKhoan != null && !this.idTaiKhoan.equals(other.idTaiKhoan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhtc.pojos.TaiKhoan[ idTaiKhoan=" + idTaiKhoan + " ]";
    }
    
}
