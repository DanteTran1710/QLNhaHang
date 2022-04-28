/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.service;

import com.nhtc.pojos.TaiKhoan;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author USER
 */
public interface TaiKhoanService extends UserDetailsService {

    boolean addUser(TaiKhoan user);

    boolean updateUserRole(TaiKhoan user);

    TaiKhoan getUserByUsername(String username);
}
