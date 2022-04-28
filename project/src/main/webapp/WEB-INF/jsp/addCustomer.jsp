
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1 class="text-center text-danger">QUẢN LÝ SẢNH TIỆC</h1>

<c:url value="/newKhachHang" var="action"/>

<c:if test="${errMsg} != null">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>

<form:form method="post" action="" modelAttribute="khachHang" enctype="multipart/form-data">
        
    <div class="form-group">
        <label for="tenSanhTiec">Họ tên khách hàng</label>
        <form:input type="text" id="hoTenKH" path="hoTenKH" cssClass="form-control"/>
    </div>
        <div class="form-group">
        <label for="tenSanhTiec">Email</label>
        <form:input type="text" id="email" path="emailKH" cssClass="form-control"/>
    </div>
    <div class="form-group">
        <label for="loaiSanhTiec">Số điện thoại liên hệ</label>
        <form:input type="text" id="sdt" path="sdtKH" cssClass="form-control"/>
    </div>
        <div class="form-group">
        <label for="tenSanhTiec">Địa chỉ thường trú</label>
        <form:input type="text" id="diaChiKH" path="diaChiKH" cssClass="form-control"/>
    </div>
 <div class="form-group">
        <label for="loaiSanhTiec">Giới tính</label>
        <form:select id="gioiTinhKH" path="gioiTinhKH" cssClass="form-control">
            <option value="Nam">Nam</option>
            <option value="Nữ">Nữ</option>
        </form:select>
    </div>
    <div class="form-group">
        <label for="file">Ảnh avatar</label>
        <form:input type="file" id="file" path="file" cssClass="form-control"/>
    </div>
    <div class="form-group">
        <input type="submit" value="Thêm thông tin khách hàng" class="btn btn-danger">
    </div>
</form:form>