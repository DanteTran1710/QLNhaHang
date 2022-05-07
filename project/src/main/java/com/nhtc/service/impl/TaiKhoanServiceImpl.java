/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.service.impl;

import com.nhtc.pojos.KhachHang;
import com.nhtc.pojos.TaiKhoan;
import com.nhtc.repository.KhachHangRepository;
import com.nhtc.repository.TaiKhoanRepository;
import com.nhtc.service.TaiKhoanService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service("userDetailsService")
public class TaiKhoanServiceImpl implements TaiKhoanService{
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public TaiKhoan getUserByUsername(String username) {
        return this.taiKhoanRepository.getUserByUsername(username);
    }

    @Override
    public boolean addUser(TaiKhoan user) {
        String password = user.getMatKhau();
        user.setMatKhau(this.passwordEncoder.encode(password));
        user.setLoaiTaiKhoan("người dùng");
        
        // Khi thêm tài khoản sẽ thêm thông tin người dùng ở dạng null
        KhachHang kh = new KhachHang();
        kh.setTaiKhoan(user);
        this.khachHangRepository.addKH(kh);
        
        return this.taiKhoanRepository.addUser(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Method get user
        TaiKhoan user = this.getUserByUsername(username);
        
        // Method check access permission
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getLoaiTaiKhoan()));
        
        return new org.springframework.security.core.userdetails
                .User(user.getTenDangNhap(), user.getMatKhau(), authorities);    }

    @Override
    public boolean updateUserRole(TaiKhoan user) {
        return this.taiKhoanRepository.updateUserRole(user);
    }
}
