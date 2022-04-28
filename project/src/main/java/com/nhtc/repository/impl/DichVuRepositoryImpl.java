/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.repository.impl;

import com.nhtc.pojos.DichVu;
import com.nhtc.repository.DichVuRepository;
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
 * @author hp
 */
@Repository
@Transactional
public class DichVuRepositoryImpl implements DichVuRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addOrUpdate(DichVu dichVu) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try {
            s.save(dichVu);
            return true;
        } catch (Exception e) {
            System.err.println("== THÊM DỊCH VỤ THẤT BẠI ==" + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<DichVu> getDichVus(String kw, int page) {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<DichVu> q = builder.createQuery(DichVu.class);
        Root root = q.from(DichVu.class);
        q = q.select(root);

        if (kw != null) {
            Predicate p = builder.like(root.get("tenDichVu").as(String.class), String.format("%%%s%%", kw));
            q = q.where(p);
        }

        q = q.orderBy(builder.desc(root.get("idDichVu")));

        Query query = s.createQuery(q);

        // 1 page hiện max 20 phần tử
        int max = 20;
        query.setMaxResults(max);
        query.setFirstResult((page - 1) * max);

        return query.getResultList();
    }

    @Override
    public DichVu getDichVuById(int i) {
        Session s = sessionFactory.getObject().getCurrentSession();
        return s.get(DichVu.class, i); 
    }

    @Override
    public long countDichVu() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        //Truy vấn tên lớp đối tượng
        Query q = session.createQuery("Select Count(*) From DichVu");
    
        return Long.parseLong(q.getSingleResult().toString());    }

}
