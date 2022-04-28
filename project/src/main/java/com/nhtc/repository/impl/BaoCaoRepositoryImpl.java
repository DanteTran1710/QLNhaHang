/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.repository.impl;

import com.nhtc.pojos.BaoCao;
import com.nhtc.repository.BaoCaoRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hp
 */
@Repository
@Transactional
public class BaoCaoRepositoryImpl implements BaoCaoRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public boolean addBaoCao(BaoCao bc) {
    Session s = sessionFactory.getObject().getCurrentSession();
        try {
            s.save(bc);
            return  true;
        } catch (Exception e) {
            System.err.println("== THÊM BÁO CÁO THẤT BẠI ==" + e.getMessage());
            e.printStackTrace();
        }
        
        return false;    }
    
}
