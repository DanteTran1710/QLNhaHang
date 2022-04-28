/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.service.impl;

import com.nhtc.pojos.NhanVien;
import com.nhtc.pojos.TaiKhoan;
import com.nhtc.repository.NhanVienRepository;
import com.nhtc.repository.TaiKhoanRepository;
import com.nhtc.service.NhanVienService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class NhanVienServiceImpl implements NhanVienService{

    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;
    
    @Override
    public List<NhanVien> getNhanVien() {
        return this.nhanVienRepository.getNhanVien();
    }

    @Override
    public boolean addorUpdateNhanVien(NhanVien nv, String username) {
        if(!username.equals("")){
        TaiKhoan tk = this.taiKhoanRepository.getUserByUsername(username);
        tk.setLoaiTaiKhoan("nhân viên");
        
        nv.setTaiKhoan(tk);
        }
        
        return this.nhanVienRepository.addorUpdateNhanVien(nv);
        
    }

    @Override
    public NhanVien getNhanVienById(int i) {
        return this.nhanVienRepository.getNhanVienById(i);
    }
    
}
