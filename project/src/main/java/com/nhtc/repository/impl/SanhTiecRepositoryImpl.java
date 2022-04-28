/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.repository.impl;

import com.nhtc.pojos.SanhTiec;
import com.nhtc.repository.SanhTiecRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class SanhTiecRepositoryImpl implements SanhTiecRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<SanhTiec> getSanhTiecs(String kw, int page){
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<SanhTiec> q = builder.createQuery(SanhTiec.class);
        Root root = q.from(SanhTiec.class);
        q = q.select(root);
        
        if(kw != null){
           Predicate  p = builder.like(root.get("tenSanhTiec").as(String.class), String.format("%%%s%%", kw));
           q = q.where(p);
        }
        
        q = q.orderBy(builder.desc(root.get("idSanhTiec")));
        
        Query query = s.createQuery(q);
        
        // 1 page hiện max 20 phần tử
        int max = 20;
        query.setMaxResults(max);
        query.setFirstResult((page-1)*max);
        
        return query.getResultList();
    }

    @Override
    public boolean addOrUpdate(SanhTiec sanhTiec) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try {
            s.save(sanhTiec);
            return  true;
        } catch (Exception e) {
            System.err.println("== THÊM SẢNH THẤT BẠI ==" + e.getMessage());
            e.printStackTrace();
        }
        
        return false;
    }

    @Override
    public long countSanhTiec() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        //Truy vấn tên lớp đối tượng
        Query q = session.createQuery("Select Count(*) From SanhTiec");
    
        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public SanhTiec getSanhTiecById(int idSanhTiec) {
        Session s = sessionFactory.getObject().getCurrentSession();
        return s.get(SanhTiec.class, idSanhTiec);    
    }
    
}
