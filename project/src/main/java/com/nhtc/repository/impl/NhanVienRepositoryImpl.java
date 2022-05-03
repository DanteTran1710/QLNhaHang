/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.repository.impl;

import com.nhtc.pojos.NhanVien;
import com.nhtc.repository.NhanVienRepository;
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
 * @author USER
 */
@Repository
@Transactional
public class NhanVienRepositoryImpl implements NhanVienRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<NhanVien> getNhanVien(String kw, int page) {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<NhanVien> q = builder.createQuery(NhanVien.class);
        Root root = q.from(NhanVien.class);
        q = q.select(root);

        if (kw != null) {
            Predicate p = builder.like(root.get("hoTenNV").as(String.class), String.format("%%%s%%", kw));
            Predicate p1 = builder.like(root.get("sdtNV").as(String.class), String.format("%%%s%%", kw));
            Predicate p2 = builder.like(root.get("emailNV").as(String.class), String.format("%%%s%%", kw));
            Predicate p3 = builder.like(root.get("diaChiNV").as(String.class), String.format("%%%s%%", kw));

            q = q.where(builder.or(p1,p,p2,p3));
        }
        q = q.orderBy(builder.desc(root.get("idNhanVien")));

        Query query = s.createQuery(q);
        // 1 page hiện max 20 phần tử
        int max = 20;
        query.setMaxResults(max);
        query.setFirstResult((page - 1) * max);

        return query.getResultList();
    }

    @Override
    public boolean addorUpdateNhanVien(NhanVien nv) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try {
            s.saveOrUpdate(nv);
            return true;
        } catch (Exception e) {
            System.err.println("== THÊM DỊCH VỤ THẤT BẠI ==" + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public NhanVien getNhanVienById(int i) {
        Session s = sessionFactory.getObject().getCurrentSession();
        return s.get(NhanVien.class, i);
    }

}
