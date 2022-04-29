<%-- 
    Document   : editDVC
    Created on : Feb 14, 2022, 11:54:39 PM
    Author     : hp
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url value="/admin/listdichvu/${dv.idDichVu}" var="action"/>

<div class="container">
    <h1 class="text-center text-danger" style="margin-top: 20px">QUẢN LÝ DỊCH VỤ CƯỚI</h1>

    <c:if test="${message} != null">
        <div class="alert alert-danger">${message}</div>
    </c:if>

    <form:form method="post" action="" modelAttribute="dv" enctype="multipart/form-data" >
       
        <div class="form-group">
            <label for="loaiSanhTiec">Tên dịch vụ cưới</label>
            <form:input type="text" id="tenDichVu" path="tenDichVu" cssClass="form-control"/>
        </div>
        <div class="form-group">
            <label for="loaiSanhTiec">Bảng giá tiền</label>
            <form:select id="bangGia" path="bangGia" cssClass="form-control" style="width: 100%">
                <option value="1000000">1.000.000</option>
                <option value="2000000">2.000.000</option>
                <option value="5000000">5.000.000</option>
                <option value="10000000">10.000.000</option>
                <option value="20000000">20.000.000</option>
            </form:select>
        </div>
        <div class="form-group">
            <label for="loaiSanhTiec">Ghi chú</label>
            <form:input type="text" id="ghiChu" path="ghiChu" cssClass="form-control"/>
        </div>
        <div class="form-group">
            <label for="file">Ảnh dịch vụ</label>
            <form:input type="file" id="file" path="file" cssClass="form-control"/>
        </div>
        <div class="form-group">
            <input type="submit" value="Thêm dịch vụ" class="btn btn-danger">
        </div>
    </form:form>
</div>