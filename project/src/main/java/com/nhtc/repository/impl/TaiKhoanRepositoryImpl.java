/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.repository.impl;

import com.nhtc.pojos.TaiKhoan;
import com.nhtc.repository.TaiKhoanRepository;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
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
public class TaiKhoanRepositoryImpl implements TaiKhoanRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public TaiKhoan getUserByUsername(String name) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TaiKhoan> query = builder.createQuery(TaiKhoan.class);
        Root root = query.from(TaiKhoan.class);
        query = query.select(root);

        if (!name.isEmpty()) {
            Predicate p = builder.equal(root.get("tenDangNhap").as(String.class), name.trim());

            query = query.where(p);
        }
        else
            System.out.println("Your username is null");

        TaiKhoan user = session.createQuery(query).uniqueResult();
        return user;    }

    @Override
    public boolean addUser(TaiKhoan user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            session.save(user);
            
            return true;
        } catch(HibernateException ex){
            System.err.println(ex.getMessage());
        }
        return false;    }

    @Override
    public boolean updateUserRole(TaiKhoan tk) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        if(!tk.getLoaiTaiKhoan().isEmpty()){
            Query q = session.createQuery("UPDATE TaiKhoan SET loaiTaiKhoan=:ul WHERE idTaiKhoan=:id ");
            q.setParameter("ul", tk.getLoaiTaiKhoan());
            q.setParameter("id", tk.getIdTaiKhoan());
            
            q.executeUpdate();
            
            return true;
        }
        
        return false;    }
    
}
