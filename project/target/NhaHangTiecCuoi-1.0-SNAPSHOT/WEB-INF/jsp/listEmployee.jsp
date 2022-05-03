<%-- 
    Document   : listEmployee
    Created on : Feb 14, 2022, 11:52:00 PM
    Author     : hp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1 class="text-center text-danger">Danh sách các sảnh cưới của nhà hàng</h1>

<!-- SEARCH SECTION -->
<div class="container">
    <form action="">
        <div class="search input-group mb-3">
            <input type="text" name="kw" class="form-control" placeholder="Search">
            <div class="input-group-append">
                <button class="btn-search" type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
            </div>
        </div>
    </form>
</div>
<div class="container">
    <div class="card " style="height: 600px">
        <div class="card-body ">
            <div class="ct-chart">
                <c:if test="${counter == 0}">
                    <table id="chartTable" class="table">
                        <tr>
                            <th></th>
                            <th>Họ tên</th>
                            <th>Số điện thoại liên hệ</th>
                            <th>Email</th>
                            <th>Địa chỉ</th>
                            <th></th>
                        </tr>
                        <c:forEach items="${nhanViens}" var="i">
                            <tr>
                                <td>
                                    <c:if test="${i.gioiTinhNV == 'Nam'}">
                                        <i class="fa fa-mars fa-lg" aria-hidden="true"></i>
                                    </c:if>
                                    <c:if test="${i.gioiTinhNV == 'Nữ'}">
                                        <i class="fa fa-venus fa-lg" aria-hidden="true"></i>
                                    </c:if>
                                </td>
                                <td>${i.hoTenNV}</td>
                                <td>${i.sdtNV}</td>
                                <td>${i.emailNV}</td>
                                <td>${i.diaChiNV}</td>
                                <td class="td-actions text-right">
                                    <button type="submit" rel="tooltip" title="Accept" class="btn btn-info btn-simple btn-link">
                                        <a href="<c:url value="/admin/listnv/${i.idNhanVien}"/>">Edit</a>
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
                <c:if test="${counter == 0}">
                    <div class="container">
                        <div class="empty-result">
                            <i class="fa fa-times fa-5x pt-3" aria-hidden="true"></i>
                            <p>
                                We have not found jobs for this search at the moment
                            </p>
                        </div>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</div>