<%-- 
    Document   : editSanhCuoi
    Created on : Feb 14, 2022, 11:53:13 PM
    Author     : hp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url value="/admin/listsanhtiec/${sanhTiec.idSanhTiec}" var="action"/>

<div class="container">
    <h1 class="text-center text-danger" style="margin-top: 20px">QUẢN LÝ SẢNH TIỆC</h1>

<c:if test="${errMsg} != null">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>

<form:form method="post" action="${action}" modelAttribute="sanhTiec" enctype="multipart/form-data">
        
    <div class="form-group">
        <label for="tenSanhTiec">Tên sảnh tiệc</label>
        <form:input type="text" id="tenSanhTiec" path="tenSanhTiec" cssClass="form-control"/>
    </div>
    
    <div class="form-group">
        <label for="loaiSanhTiec">Loại sảnh tiệc</label>
        <form:select id="loaiSanhTiec" path="maLoaiSanh" cssClass="form-control">
            <c:forEach var="l" items="${loaisanh}">
                <option value="${l.idLoaiSanh}">${l.tenLoaiSanh}</option>
            </c:forEach>
        </form:select>
    </div>
    
    <div class="form-group">
        <label for="file">Ảnh sảnh tiệc</label>
        <form:input type="file" id="file" path="file" cssClass="form-control"/>
    </div>
    <div class="form-group">
        <input type="submit" value="Thêm sảnh tiệc" class="btn btn-danger">
    </div>
</form:form>
</div>