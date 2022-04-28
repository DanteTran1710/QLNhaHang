/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "khach_hang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KhachHang.findAll", query = "SELECT k FROM KhachHang k"),
    @NamedQuery(name = "KhachHang.findByIdKhachHang", query = "SELECT k FROM KhachHang k WHERE k.idKhachHang = :idKhachHang"),
    @NamedQuery(name = "KhachHang.findByHoTenKH", query = "SELECT k FROM KhachHang k WHERE k.hoTenKH = :hoTenKH"),
    @NamedQuery(name = "KhachHang.findByEmailKH", query = "SELECT k FROM KhachHang k WHERE k.emailKH = :emailKH"),
    @NamedQuery(name = "KhachHang.findBySdtKH", query = "SELECT k FROM KhachHang k WHERE k.sdtKH = :sdtKH"),
    @NamedQuery(name = "KhachHang.findByDiaChiKH", query = "SELECT k FROM KhachHang k WHERE k.diaChiKH = :diaChiKH"),
    @NamedQuery(name = "KhachHang.findByGioiTinhKH", query = "SELECT k FROM KhachHang k WHERE k.gioiTinhKH = :gioiTinhKH")})
public class KhachHang implements Serializable {

    @OneToMany(mappedBy = "idKhachHang")
    private Collection<BaoCao> baoCaoCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idKhachHang")
    private Integer idKhachHang;
    @Size(max = 45)
    @Column(name = "hoTenKH")
    private String hoTenKH;
    @Size(max = 45)
    @Column(name = "emailKH")
    private String emailKH;
    @Size(max = 45)
    @Column(name = "sdtKH")
    private String sdtKH;
    @Size(max = 50)
    @Column(name = "diaChiKH")
    private String diaChiKH;
    @Size(max = 5)
    @Column(name = "gioiTinhKH")
    private String gioiTinhKH;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTaiKhoan")
    @JsonIgnore
    private TaiKhoan taiKhoan;
    private String avatar;
    @Transient
    private  MultipartFile file;

    public KhachHang() {
    }

    public KhachHang(Integer idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public Integer getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(Integer idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getHoTenKH() {
        return hoTenKH;
    }

    public void setHoTenKH(String hoTenKH) {
        this.hoTenKH = hoTenKH;
    }

    public String getEmailKH() {
        return emailKH;
    }

    public void setEmailKH(String emailKH) {
        this.emailKH = emailKH;
    }

    public String getSdtKH() {
        return sdtKH;
    }

    public void setSdtKH(String sdtKH) {
        this.sdtKH = sdtKH;
    }

    public String getDiaChiKH() {
        return diaChiKH;
    }

    public void setDiaChiKH(String diaChiKH) {
        this.diaChiKH = diaChiKH;
    }

    public String getGioiTinhKH() {
        return gioiTinhKH;
    }

    public void setGioiTinhKH(String gioiTinhKH) {
        this.gioiTinhKH = gioiTinhKH;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKhachHang != null ? idKhachHang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KhachHang)) {
            return false;
        }
        KhachHang other = (KhachHang) object;
        if ((this.idKhachHang == null && other.idKhachHang != null) || (this.idKhachHang != null && !this.idKhachHang.equals(other.idKhachHang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhtc.pojos.KhachHang[ idKhachHang=" + idKhachHang + " ]";
    }

    @XmlTransient
    public Collection<BaoCao> getBaoCaoCollection() {
        return baoCaoCollection;
    }

    public void setBaoCaoCollection(Collection<BaoCao> baoCaoCollection) {
        this.baoCaoCollection = baoCaoCollection;
    }

    /**
     * @return the avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * @param avatar the avatar to set
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
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
