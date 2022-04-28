/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.nhtc.pojos.KhachHang;
import com.nhtc.pojos.TaiKhoan;
import com.nhtc.repository.KhachHangRepository;
import com.nhtc.repository.TaiKhoanRepository;
import com.nhtc.service.KhachHangService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public boolean addKH(KhachHang kh) {
        TaiKhoan tk = this.taiKhoanRepository.getUserByUsername(
                SecurityContextHolder.getContext().getAuthentication().getName());
        Map r;
        try {
            r = this.cloudinary.uploader().upload(kh.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
            kh.setAvatar((String) r.get("secure_url"));

            kh.setTaiKhoan(tk);
            tk.setLoaiTaiKhoan("khách hàng");
            this.taiKhoanRepository.updateUserRole(tk);
        } catch (IOException ex) {
            Logger.getLogger(KhachHangServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return this.khachHangRepository.addKH(kh);
    }

}
