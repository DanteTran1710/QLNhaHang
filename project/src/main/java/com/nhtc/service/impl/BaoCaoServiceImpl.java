/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.service.impl;

import com.nhtc.pojos.BaoCao;
import com.nhtc.pojos.TaiKhoan;
import com.nhtc.repository.BaoCaoRepository;
import com.nhtc.repository.TaiKhoanRepository;
import com.nhtc.service.BaoCaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
public class BaoCaoServiceImpl implements BaoCaoService{
    @Autowired
    private BaoCaoRepository baoCaoRepository; 
    @Autowired
    private TaiKhoanRepository taiKhoanRepository; 
    
    @Override
    public boolean addBaoCao(BaoCao bc) {
        TaiKhoan tk = this.taiKhoanRepository.getUserByUsername(
                SecurityContextHolder.getContext().getAuthentication().getName());
        
        bc.setIdKhachHang(tk.getKhachHang());
        
        return this.baoCaoRepository.addBaoCao(bc);
    }
    
}
