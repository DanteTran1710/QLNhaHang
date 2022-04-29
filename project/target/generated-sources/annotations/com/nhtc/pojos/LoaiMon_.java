package com.nhtc.pojos;

import com.nhtc.pojos.MonAn;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-04-29T14:21:07")
@StaticMetamodel(LoaiMon.class)
public class LoaiMon_ { 

    public static volatile SingularAttribute<LoaiMon, Integer> idLoaiMon;
    public static volatile SingularAttribute<LoaiMon, String> tenLoaiMon;
    public static volatile CollectionAttribute<LoaiMon, MonAn> monAnCollection;

}