/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.repository;

import com.nhtc.pojos.TaiKhoan;
import java.util.List;


/**
 *
 * @author USER
 */
public interface TaiKhoanRepository {
    boolean addUser(TaiKhoan user);
    boolean updateUserRole(TaiKhoan user);
    TaiKhoan getUserByUsername(String name);
    
}
