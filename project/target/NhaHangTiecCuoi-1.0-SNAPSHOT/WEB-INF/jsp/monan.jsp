
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1 class="text-center text-danger">QUAN LY MON AN</h1>

<c:url value="/admin/monan" var="action"/>

<c:if test="${errMsg} != null">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>

<form:form method="post" action="" modelAttribute="monan" enctype="multipart/form-data">
    
    <form:errors path="*" cssClass="alert alert-danger" element="div"/>
    
    <div class="form-group">
        <label for="tenMonAn">Tên món ăn</label>
        <form:input type="text" id="tenMonAn" path="tenMonAn" cssClass="form-control"/>
        <form:errors path="tenMonAn" cssClass="text-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="giaMonAn">Giá món ăn</label>
        <form:input type="text" id="giaMonAn" path="giaMonAn" cssClass="form-control"/>
        <form:errors path="giaMonAn" cssClass="text-danger" element="div"/>
    </div>
    
    <div class="form-group">
        <label for="loaiMonAn">Loại món ăn</label>
        <form:select id="loaiMonAn" path="maLoaiMon" cssClass="form-control">
            <c:forEach var="l" items="${loaimon}">
                <option value="${l.idLoaiMon}">${l.tenLoaiMon}</option>
            </c:forEach>
        </form:select>
        <form:errors path="maLoaiMon" cssClass="text-danger" element="div"/>
    </div>
    
    <div class="form-group">
        <label for="file">Ảnh món ăn</label>
        <form:input type="file" id="file" path="file" cssClass="form-control"/>
    </div>
    <div class="form-group">
        <input type="submit" value="Thêm món ăn" class="btn btn-danger">
    </div>
</form:form>