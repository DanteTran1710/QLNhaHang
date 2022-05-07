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
                  <a href="#" class="btn btn-primary" onclick="getSanhTiec(${m.idSanhTiec})" data-toggle="modal" data-target="#exampleModal">Đặt tiệc</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content" style="width: 700px">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">ĐẶT TIỆC</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <h5 id="tenSanhTiec"></h5>   
          <!--================== MON AN ==========================-->
          <h6 style="margin-top: 20px; color: blue">Chọn món ăn</h6>
            <table class="table">
              <thead>
                <tr>
                  <th>Món ăn</th>
                  <th>Tên món</th>
                  <th>Giá</th>
                </tr>
              </thead>
              <tbody>
                  <c:forEach var="m" items="${listMonAn}">
                      <tr>
                  <td> <input type="checkbox" id="${m.idMonAn}" onclick="isCheckedMonAn(this)" name="vehicle1"></td>
                  <td>${m.tenMonAn}</td>
                  <td>${m.giaMonAn}</td>
                </tr> 
                </c:forEach>
            </table>
          <!--================== DICH VU ==========================-->
          <h6 style="margin-top: 20px; color: blue">Chọn dich vu</h6>
            <table class="table">
              <thead>
                <tr>
                  <th>Dịch vụ</th>
                  <th>Tên</th>
                  <th>Giá</th>
                </tr>
              </thead>
              <tbody>
                  <c:forEach var="d" items="${listDichVu}">
                      <tr>
                          <td> <input type="checkbox" id="${d.idDichVu}" onclick="isCheckedDichVu(this)" name="vehicle1"></td>
                  <td>${d.tenDichVu}</td>
                  <td>${d.bangGia}</td>
                </tr> 
                </c:forEach>
            </table>
          <h5 id="tongTien">Tổng tiền: 0</h5>  
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>


<script src="<c:url value="/js/sanh.js" />"></script>