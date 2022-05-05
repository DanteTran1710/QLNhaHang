/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhtc.repository.impl;

import com.nhtc.pojos.HoaDon;
import com.nhtc.pojos.KhachHang;
import com.nhtc.repository.HoaDonRepository;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
public class HoaDonRepositoryImpl implements HoaDonRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Object> getListHoaDonByElements(int option, String month, String year, Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root rootR = query.from(KhachHang.class);
        Root rootC = query.from(HoaDon.class);
        Predicate p = builder.equal(rootC.get("idKhachHang"), rootR.get("idKhachHang"));
        
        if (option == 2) {
            query.multiselect(builder.function("MONTH", Integer.class, rootC.get("ngayDat")),
                    builder.sum(rootC.get("tongTien")));
        } else {
            query.multiselect(builder.function("YEAR", Integer.class, rootC.get("ngayDat")),
                    builder.sum(rootC.get("tongTien")));
        }
        switch (option) {
            case 1:
                Predicate pelemnet = builder.equal(builder.function("MONTH", Integer.class, rootC.get("ngayDat")), month);
                query = query.where(builder.and(pelemnet, p));
                query = query.groupBy(builder.function("YEAR", Integer.class, rootC.get("ngayDat")));
                break;
            case 2:
                Predicate pelemnet2 = builder.equal(builder.function("YEAR", Integer.class, rootC.get("ngayDat")), year);
                query = query.where(builder.and(pelemnet2, p));
                query = query.groupBy(builder.function("MONTH", Integer.class, rootC.get("ngayDat")));
                break;
            case 3:
                Predicate pfrom = builder.greaterThanOrEqualTo(rootC.get("ngayDat"), fromDate);
                Predicate pto = builder.lessThanOrEqualTo(rootC.get("ngayDat"), toDate);
                query = query.where(builder.and(p, pfrom, pto));
                query = query.groupBy(builder.function("YEAR", Integer.class, rootC.get("ngayDat")));
                break;
        }

        Query q = session.createQuery(query);

        return q.getResultList();
    }

}
