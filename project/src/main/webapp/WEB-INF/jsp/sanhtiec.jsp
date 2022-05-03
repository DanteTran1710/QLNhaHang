<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul class="pagination  justify-content-center">
    <c:forEach begin="1" end="${Math.ceil(sanhTiecCounter/10)}" var="i">
            <li class="page-item">
                <a class="page-link" href="<c:url value="/sanhtiec"/>?page=${i}">${i}</a>
            </li>
    </c:forEach>  
</ul>

<div class="row">
    <c:forEach var="m" items="${sanhtiec}">
        <div class="col-md-3 col-xs-12" style="padding: 10px">
            <div class="card" >     
                <c:choose>
                    <c:when test="${m.anhSanhTiec != null && m.anhSanhTiec.startsWith('https') == true}">
                        <img class="img-card-top img-fluid" src="${m.anhSanhTiec}" alt="Card image" style="height: 400px"></img>
                    </c:when>
                    <c:when test="${m.anhSanhTiec == null || m.anhSanhTiec.startsWith('https') == false}">
                        <img class="img-card-top img-fluid" src="<c:url value="images/logo.jpg"/>" alt="Card image" style="height: 400px"></img>
                    </c:when>
                </c:choose>

                <div class="card-body">
                  <h4 class="card-title">${m.tenSanhTiec}</h4>
                  <a href="#" class="btn btn-primary">Đặt tiệc</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

<script src="<c:url value="/js/sanh.js" />"></script>