package com.nhtc.pojos;

import com.nhtc.pojos.LoaiSanh;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-04-28T15:12:38")
@StaticMetamodel(SanhTiec.class)
public class SanhTiec_ { 

    public static volatile SingularAttribute<SanhTiec, String> anhSanhTiec;
    public static volatile SingularAttribute<SanhTiec, LoaiSanh> maLoaiSanh;
    public static volatile SingularAttribute<SanhTiec, Integer> idSanhTiec;
    public static volatile SingularAttribute<SanhTiec, Date> ngayDatSanh;
    public static volatile SingularAttribute<SanhTiec, String> tenSanhTiec;

}