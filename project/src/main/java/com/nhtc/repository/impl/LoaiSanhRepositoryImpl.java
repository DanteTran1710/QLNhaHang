/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.repository.impl;

import com.nhtc.pojos.LoaiSanh;
import com.nhtc.repository.LoaiSanhRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ACER
 */
@Repository
@Transactional
public class LoaiSanhRepositoryImpl implements LoaiSanhRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<LoaiSanh> getLoaiSanhs() {
        Session s = sessionFactory.getObject().getCurrentSession();
//        CriteriaBuilder builder = s.getCriteriaBuilder();
//        CriteriaQuery<LoaiMon> q = builder.createQuery(LoaiMon.class);
//        Root root = q.from(LoaiMon.class);
//        q = q.select(root);
//        Query query = s.createQuery(q);
        Query query = s.createQuery("From LoaiSanh");
        return query.getResultList();
    }

    @Override
    public LoaiSanh getLoaiSanhById(int idLoaiSanh) {
        Session s = sessionFactory.getObject().getCurrentSession();
        return s.get(LoaiSanh.class, idLoaiSanh);
    }
    
}
