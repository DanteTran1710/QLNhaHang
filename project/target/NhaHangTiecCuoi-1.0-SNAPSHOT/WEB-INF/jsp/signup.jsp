<%-- 
    Document   : signup
    Created on : Aug 21, 2021, 9:08:31 PM
    Author     : hp
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:url value="/signup" var="action" />
<c:if test="${errorMessage != null}">
        <div id="toast">
        <div id="toast_main">
            <div class="toast_icon">
                <i class="fa fa-exclamation-triangle" aria-hidden="true"></i>
            </div>
            <div class="toast_body">
                <h3 class="toast_title">THẤT BẠI!</h3>
                <div class="toast_message">${errorMessage}</div>
            </div>
            <div class="toast_close" onclick="removeToast();">
                <i class="fa fa-times" aria-hidden="true"></i>
            </div>
        </div>
    </div>
</c:if>

<!DOCTYPE html>
<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <div class="login100-pic js-tilt" data-tilt>
                <img src="<c:url value="/images/signup.png"/>" alt="IMG">
            </div>

            <div class="login100-form validate-form">
                <span class="login100-form-title">
                    SIGN UP
                </span>
                <div class="signup-form">
                    <form:form method="post" action="${action}" class="register-form" id="register-form" modelAttribute="taiKhoan">
                        <div class="form-group">
                            <label for="username"><i class="fa fa-address-card-o" aria-hidden="true"></i></label>
                                <form:input type="username" path="tenDangNhap" id="username" placeholder="User Name"/>
                        </div>
                        <div class="form-group">
                            <label for="password"><i class="fa fa-lock" aria-hidden="true"></i></label>
                                <form:input type="password" path="matKhau" id="pass" placeholder="Password"/>
                        </div>
                        <div class="container-login100-form-btn">
                            <button type="submit" class="login100-form-btn">SIGN UP</button>
                        </div>
                    </form:form>

                    <div class="text-center p-t-136">
                        <a class="txt2" href="<c:url value="/login"/>">
                            I'VE ALREADY HAVE AN ACCOUNT
                            <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


