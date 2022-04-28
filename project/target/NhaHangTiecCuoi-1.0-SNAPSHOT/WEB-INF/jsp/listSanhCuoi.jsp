<%-- 
    Document   : listSanhCuoi
    Created on : Feb 14, 2022, 11:53:42 PM
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
                            <th>Mã tiệc cưới</th>
                            <th>Tên sảnh cưới</th>
                            <th>Loại sảnh</th>
                            <th>Ngày đặt sảnh</th>
                            <th></th>
                        </tr>
                        <c:forEach items="${sanhTiecs}" var="i">
                            <tr>
                                <td>${i.idSanhTiec}</td>
                                <td>${i.tenSanhTiec}</td>
                                <td>${i.maLoaiSanh.idLoaiSanh}</td>
                                <td>${i.ngayDatSanh}</td>
                                <td class="td-actions text-right">
                                    <button type="submit" rel="tooltip" title="Accept" class="btn btn-info btn-simple btn-link">
                                        <a href="<c:url value="/admin/listsanhtiec/${i.idSanhTiec}"/>">Edit</a>
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