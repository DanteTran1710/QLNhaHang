<%-- 
    Document   : addSanhCuoi
    Created on : Feb 14, 2022, 11:52:40 PM
    Author     : hp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url value="/admin/newsanhtiec" var="action"/>

<c:if test="${errMsg} != null">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>

<div class="container">
    <h1 class="text-center text-danger">Thêm sảnh tiệc mới</h1>
    <form:form method="post" action="" modelAttribute="sanhtiec" enctype="multipart/form-data">

        <div class="form-group">
            <label for="tenSanhTiec" style="width: 100%">Tên sảnh tiệc</label>
            <div style="width: 100%">
                <form:input type="text" path="tenSanhTiec" id="title-company-job"/>
            </div>
        </div>

        <div class="form-group">
            <label for="loaiSanhTiec">Loại sảnh</label>
            <form:select id="maLoaiSanh" path="maLoaiSanh" cssClass="form-control" style="width: 100%">
                <c:forEach items="${loaisanh}" var="ls">
                    <option value="${ls.idLoaiSanh}">${ls.tenLoaiSanh}</option>
                </c:forEach>
            </form:select>
        </div>

        <div class="form-group">
            <label for="anhTiecCuoi" style="width: 100%">Ảnh cho tiệc cưới</label>
            <div style="width: 100%">
                <form:input type="file" path="file" id="title-company-job"/>
            </div>
        </div>
        <div class="form-group">
            <input type="submit" value="Add" class="btn btn-danger">
        </div>
    </form:form>
</div>