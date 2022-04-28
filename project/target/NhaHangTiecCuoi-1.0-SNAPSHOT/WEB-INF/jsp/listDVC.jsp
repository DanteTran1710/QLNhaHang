<%-- 
    Document   : listDVC
    Created on : Feb 14, 2022, 11:55:10 PM
    Author     : hp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
                            <th></th>
                        </tr>
                        <c:forEach items="${dichVus}" var="i">
                            <tr>
                                <td>${i.idDichVu}</td>
                                <td>${i.tenDichVu}</td>
                                <td class="td-actions text-right">
                                    <button type="submit" rel="tooltip" title="Accept" class="btn btn-info btn-simple btn-link">
                                        <a href="<c:url value="/admin/listdichvu/${i.idDichVu}"/>">Edit</a>
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
