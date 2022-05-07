<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul class="pagination  justify-content-center">
    <c:forEach begin="1" end="${Math.ceil(dichVuCounter/10)}" var="i">
            <li class="page-item">
                <a class="page-link" href="<c:url value="/dichvu"/>?page=${i}">${i}</a>
            </li>
    </c:forEach>  
</ul>

<div class="row">
    <c:forEach var="dv" items="${dichvu}">
        <div class="col-md-3 col-xs-12" style="padding: 10px">
            <div class="card" >     
                <c:choose>
                    <c:when test="${dv.anhDV != null && dv.anhDV.startsWith('https') == true}">
                        <img class="img-card-top img-fluid" src="${dv.anhDV}" alt="Card image" style="height: 400px"></img>
                    </c:when>
                    <c:when test="${dv.anhDV == null || dv.anhDV.startsWith('https') == false}">
                        <img class="img-card-top img-fluid" src="<c:url value="images/logo.jpg"/>" alt="Card image" style="height: 400px"></img>
                    </c:when>
                </c:choose>

                <div class="card-body">
                  <h4 class="card-title">${dv.tenDichVu}</h4>
                  <a href="#" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">Đặt tiệc</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

<script src="<c:url value="/js/dichvu.js" />"></script>