<%-- 
    Document   : baocao
    Created on : Feb 13, 2022, 10:50:26 AM
    Author     : hp
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1 class="text-center text-danger">BÁO CÁO HOẠT ĐỘNG CỦA NHÀ HÀNG</h1>

<c:url value="/baocao" var="action"/>

<c:if test="${errMsg} != null">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>

<form:form method="post" action="" modelAttribute="baoCao" enctype="multipart/form-data">

    <div class="form-group">
        <label for="loaiSanhTiec">Đối tượng báo cáo</label>
        <form:select id="doiTuong" path="doiTuong" cssClass="form-control">
            <option value="Nhân viên">Nhân viên</option>
            <option value="Tổ chức sự kiện">Tổ chức sự kiện</option>
        </form:select>
    </div>

    <div class="form-group">
        <label for="noiDung" style="width: 100%">Nội dung báo cáo</label>
        <div style="width: 100%"><form:textarea type="textarea" path="noiDung" id="noiDung"/></div>
    </div>
    <div class="form-group">
        <input type="submit" value="Báo cáo" class="btn btn-danger">
    </div>
</form:form>