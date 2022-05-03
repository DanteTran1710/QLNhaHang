package com.nhtc.pojos;

import com.nhtc.pojos.BaoCao;
import com.nhtc.pojos.TaiKhoan;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-05-03T21:25:45")
@StaticMetamodel(KhachHang.class)
public class KhachHang_ { 

    public static volatile SingularAttribute<KhachHang, TaiKhoan> taiKhoan;
    public static volatile SingularAttribute<KhachHang, String> hoTenKH;
    public static volatile SingularAttribute<KhachHang, String> sdtKH;
    public static volatile SingularAttribute<KhachHang, String> emailKH;
    public static volatile SingularAttribute<KhachHang, String> gioiTinhKH;
    public static volatile SingularAttribute<KhachHang, String> avatar;
    public static volatile SingularAttribute<KhachHang, Integer> idKhachHang;
    public static volatile CollectionAttribute<KhachHang, BaoCao> baoCaoCollection;
    public static volatile SingularAttribute<KhachHang, String> diaChiKH;

}