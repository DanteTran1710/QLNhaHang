/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.service;

import com.nhtc.pojos.NhanVien;
import java.util.List;

/**
 *
 * @author USER
 */
public interface NhanVienService {
    List<NhanVien> getNhanVien();
    boolean addorUpdateNhanVien(NhanVien nv, String un);
    NhanVien getNhanVienById(int idSanhTiec);
}
