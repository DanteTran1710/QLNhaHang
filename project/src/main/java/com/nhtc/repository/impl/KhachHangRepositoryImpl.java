/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.repository.impl;

import com.nhtc.pojos.KhachHang;
import com.nhtc.pojos.TaiKhoan;
import com.nhtc.repository.KhachHangRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.eclipse.persistence.annotations.QueryRedirectors;
import org.hibernate.Session;
import org.hibernate.query.Query;
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

    @Override
    public KhachHang getKhachHangByIDTaiKhoan(int idTaiKhoan) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<KhachHang> query = builder.createQuery(KhachHang.class);
        Root root = query.from(KhachHang.class);
        //query = query.select(root);
        Predicate p = builder.equal(root.get("taiKhoan"), idTaiKhoan);

        query = query.where(p);
        KhachHang kh = session.createQuery(query).uniqueResult();     
        return kh;   
    }
    
    
}
