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

<div class="container">
    <div class="col-md-7">
        <div class="card " style="height: 600px; width: 700px">
            <div class="card-body ">
                <div class="ct-chart">
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
                </div>
            </div>
        </div>
    </div>
</div>
