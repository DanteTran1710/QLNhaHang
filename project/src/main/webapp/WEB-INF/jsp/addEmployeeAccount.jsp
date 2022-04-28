<%-- 
    Document   : addEmployeeAccount
    Created on : Feb 18, 2022, 10:44:20 AM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<c:url value="/admin/signuptoempl" var="action" />

<div class="signup-form container">
        <h1 class="text-center text-danger">Đăng ký tài khoản cho người dùng</h1>
    <form:form method="post" action="${action}" class="register-form" id="register-form" modelAttribute="taiKhoan">
        <div class="form-group">
            <label for="username"><i class="fa fa-address-card-o" aria-hidden="true"></i>&nbsp;&nbsp;USERNAME</label>
            <form:input type="username" path="tenDangNhap" id="username" placeholder="User Name" style="width: 100%"/>
        </div>
        <div class="form-group">
            <label for="password"><i class="fa fa-lock" aria-hidden="true"></i>&nbsp;&nbsp;PASSWORD</label>
            <form:input type="password" path="matKhau" id="pass" placeholder="Password" style="width: 100%"/>
        </div>
        <div class="container-login100-form-btn">
            <button type="submit" class="login100-form-btn">SIGN UP</button>
        </div>
    </form:form>
</div>
