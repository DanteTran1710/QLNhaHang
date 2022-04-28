/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.repository.impl;

import com.nhtc.pojos.KhachHang;
import com.nhtc.repository.KhachHangRepository;
import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author USER
 */
@Repository
@Transactional
public class KhachHangRepositoryImpl implements KhachHangRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addKH(KhachHang kh) {
     Session s = sessionFactory.getObject().getCurrentSession();
        try {
            s.save(kh);
            return  true;
        } catch (Exception e) {
            System.err.println("== THÊM KHÁCH HÀNG THẤT BẠI ==" + e.getMessage());
            e.printStackTrace();
        }
        
        return false;      }
    
    
}
