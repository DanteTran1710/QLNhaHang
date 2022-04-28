<%-- 
    Document   : editEmployee
    Created on : Feb 14, 2022, 11:51:33 PM
    Author     : hp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url value="/admin/listnv/${nhanvien.idNhanVien}" var="action"/>

<c:if test="${errMsg} != null">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>

<div class="container">
    <h1 class="text-center text-danger">Thêm thông tin nhân viên mới</h1>
    <form:form method="post" action="" modelAttribute="nhanVien" enctype="multipart/form-data">
        <div class="form-group">
            <label for="tenSanhTiec" style="width: 100%">Tên nhân viên</label>
            <div style="width: 100%">
                <form:input type="text" path="hoTenNV" id="title-company-job"/>
            </div>
        </div>
        <div class="form-group">
            <label for="tenSanhTiec" style="width: 100%">Số điện thoại liên hệ</label>
            <div style="width: 100%">
                <form:input type="text" path="sdtNV" id="title-company-job"/>
            </div>
        </div>
        <div class="form-group">
            <label for="tenSanhTiec" style="width: 100%">Email</label>
            <div style="width: 100%">
                <form:input type="email" path="emailNV" id="title-company-job"/>
            </div>
        </div>
        <div class="form-group">
            <label for="tenSanhTiec" style="width: 100%">Địa chỉ nhân viên</label>
            <div style="width: 100%">
                <form:input type="text" path="diaChiNV" id="title-company-job"/>
            </div>
        </div>
        <div class="form-group">
            <label for="loaiSanhTiec">Giới tính</label>
            <form:select id="maLoaiSanh" path="gioiTinhNV" cssClass="form-control" style="width: 100%">
                <option value="Nữ">Nữ</option>
                <option value="Nam">Nam</option>
            </form:select>
        </div>
        <div class="form-group">
            <input type="submit" value="Add" class="btn btn-danger">
        </div>
    </form:form>
</div>