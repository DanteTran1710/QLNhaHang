<%-- 
    Document   : editDVC
    Created on : Feb 14, 2022, 11:54:39 PM
    Author     : hp
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url value="/admin/listdvc/${dichVu.idDichVu}" var="action"/>

<div class="container">
    <h1 class="text-center text-danger" style="margin-top: 20px">QUẢN LÝ DỊCH VỤ CƯỚI</h1>

    <c:if test="${errMsg} != null">
        <div class="alert alert-danger">${errMsg}</div>
    </c:if>

     <form:form method="post" action="" modelAttribute="dichVu">

        <div class="form-group">
            <label for="loaiSanhTiec">Tên dịch vụ cưới</label>
            <form:input type="text" path="tenDichVu" id="tenDichVu" placeholder="Tên dịch vụ" style="width: 100%"/>
        </div>
        <div class="form-group">
            <input type="submit" value="Sửa mới" class="btn btn-danger">
        </div>
    </form:form>
</div>