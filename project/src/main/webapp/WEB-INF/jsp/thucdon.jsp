<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul class="pagination  justify-content-center">
    <c:forEach begin="1" end="${Math.ceil(monAnCounter/20)}" var="i">
            <li class="page-item">
                <a class="page-link" href="<c:url value="/thucdon"/>?page=${i}">${i}</a>
            </li>
    </c:forEach>  
</ul>

<div class="row">
     <c:forEach var="m" items="${monan}">
        <div class="col-md-3 col-xs-12" style="padding: 10px">
            <div class="card">     
                <c:choose>
                    <c:when test="${m.anhMonAn != null && m.anhMonAn.startsWith('https') == true}">
                        <img class="img-card-top img-fluid" src="${m.anhMonAn}" alt="Card image" style="height: 400px"></img>
                    </c:when>
                    <c:when test="${m.anhMonAn == null || m.anhMonAn.startsWith('https') == false}">
                        <img class="img-card-top img-fluid" src="<c:url value="images/logo.jpg"/>" alt="Card image" style="height: 400px"></img>
                    </c:when>
                </c:choose>

                <div class="card-body" style="height: 210px">
                  <h4 class="card-title">${m.tenMonAn}</h4>
                  <p class="card-text">${m.giaMonAn} VNĐ</p>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

<script src="<c:url value="/js/thucdon.js" />"></script>
