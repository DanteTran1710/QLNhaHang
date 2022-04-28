/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.repository;

import com.nhtc.pojos.NhanVien;
import java.util.List;

/**
 *
 * @author USER
 */
public interface NhanVienRepository {
    List<NhanVien> getNhanVien();
    boolean addorUpdateNhanVien(NhanVien nv);
    NhanVien getNhanVienById(int idSanhTiec);

}
