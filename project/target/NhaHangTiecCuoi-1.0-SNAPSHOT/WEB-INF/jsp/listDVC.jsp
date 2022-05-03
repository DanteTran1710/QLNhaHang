<%-- 
    Document   : listDVC
    Created on : Feb 14, 2022, 11:55:10 PM
    Author     : hp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:if test="${msg != null}">
    <div id="toast">
        <div id="toast_main">
            <div class="toast_icon">
                <i class="fa fa-exclamation-triangle" aria-hidden="true"></i>
            </div>
            <div class="toast_body">
                <h3 class="toast_title">THÔNG BÁO!</h3>
                <div class="toast_message">${msg}</div>
            </div>
            <div class="toast_close" onclick="removeToast();">
                <i class="fa fa-times" aria-hidden="true"></i>
            </div>
        </div>
    </div>
</c:if>

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
    <div class="card " style="height: 600px;">
        <div class="card-body ">
            <div class="ct-chart">
                <c:if test="${counter > 0}">
                    <table id="chartTable" class="table">
                        <tr>
                            <th>Mã dịch vụ cưới</th>
                            <th>Tên các dịch vụ cưới</th>
                            <th>Bảng giá</th>
                            <th>Ghi chú</th>                            
                            <th></th>
                            <th></th>
                        </tr>
                        <c:forEach items="${dichVus}" var="i">
                            <tr>
                                <td>${i.idDichVu}</td>
                                <td>${i.tenDichVu}</td>
                                <td>${i.bangGia}</td>
                                <td>${i.ghiChu}</td>
                                <td class="td-actions text-right">
                                    <button type="submit" rel="tooltip" title="Accept" class="btn btn-info btn-simple btn-link">
                                        <a href="<c:url value="/admin/listdichvu/${i.idDichVu}"/>">Edit</a>
                                    </button>
                                </td>
                                <td class="td-actions text-right">
                                    <button type="submit" rel="tooltip" title="Accept" class="btn btn-info btn-simple btn-link">
                                        <a href="#" onclick="deleteDichVu(${i.idDichVu})">Delete</a>
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
                                Không tìm thấy dịch vụ cưới theo từ khóa
                            </p>
                        </div>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</div>

