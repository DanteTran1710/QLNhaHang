<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="carouselExampleControls" class="carousel slide" data-ride="carousel" style="margin-top: 20px;">
  <div class="carousel-inner" style="width: 100%; height: 700px; border-radius: 10px">
    <div class="carousel-item active">
      <img class="d-block w-100" src="<c:url value="/images/ruby.jpg" />" alt="First slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="<c:url value="/images/diamond.jpg" />" alt="Second slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="<c:url value="/images/safia.jpeg" />" alt="Third slide">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>


<script src="<c:url value="/js/home.js" />"></script>