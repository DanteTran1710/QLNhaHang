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
    public List<NhanVien> getNhanVien() {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<NhanVien> q = builder.createQuery(NhanVien.class);
        Root root = q.from(NhanVien.class);
        q = q.select(root);

        q = q.orderBy(builder.desc(root.get("idNhanVien")));

        Query query = s.createQuery(q);

        return query.getResultList();
    }

    @Override
    public boolean addorUpdateNhanVien(NhanVien nv) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try {
            s.save(nv);
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
