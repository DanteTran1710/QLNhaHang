<%-- 
    Document   : addDVC
    Created on : Feb 14, 2022, 11:54:12 PM
    Author     : hp
--%>

<%-- 
    Document   : baocao
    Created on : Feb 13, 2022, 10:50:26 AM
    Author     : hp
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">

    <h1 class="text-center text-danger">Thêm dịch vụ cưới mới</h1>

    <c:url value="/admin/newdvc" var="action"/>

    <c:if test="${errMsg} != null">
        <div class="alert alert-danger">${errMsg}</div>
    </c:if>

    <form:form method="post" action="" modelAttribute="dichVu">

        <div class="form-group">
            <label for="loaiSanhTiec">Tên dịch vụ cưới</label>
            <form:input type="text" path="tenDichVu" id="tenDichVu" placeholder="Tên dịch vụ" style="width: 100%"/>
        </div>
        <div class="form-group">
            <input type="submit" value="Thêm mới" class="btn btn-danger">
        </div>
    </form:form>
</div>