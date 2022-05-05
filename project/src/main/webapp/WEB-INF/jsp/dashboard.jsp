<%-- 
    Document   : dashboard
    Created on : Aug 22, 2021, 10:09:53 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<!DOCTYPE html>
<div class="content">
    <div class="container-fluid">
        <div class="filter input-group mb-3">
            <nav class="nav-menu d-none d-lg-block">
                <ul>
                    <!-- THE SALARY FILTER OF CONDITIONS -->
                    <li class="drop-down"><a href="<c:url value="/admin"/>">STATISTIC BY MONTH</a>
                        <ul class="scrolltable">                     
                            <li><a href=""><input type="radio" name="rdbM" value="1" />&nbsp;&nbsp;Jan</a></li>
                            <li><a href=""><input type="radio" name="rdbM" value="2" />&nbsp;&nbsp;Feb</a></li>
                            <li><a href=""><input type="radio" name="rdbM" value="3" />&nbsp;&nbsp;March</a></li>
                            <li><a href=""><input type="radio" name="rdbM" value="4" />&nbsp;&nbsp;April</a></li>
                            <li><a href=""><input type="radio" name="rdbM" value="5" />&nbsp;&nbsp;May</a></li>
                            <li><a href=""><input type="radio" name="rdbM" value="6" />&nbsp;&nbsp;Jun</a></li>
                            <li><a href=""><input type="radio" name="rdbM" value="7" />&nbsp;&nbsp;July</a></li>
                            <li><a href=""><input type="radio" name="rdbM" value="8" />&nbsp;&nbsp;Aug</a></li>
                            <li><a href=""><input type="radio" name="rdbM" value="9" />&nbsp;&nbsp;Sep</a></li>
                            <li><a href=""><input type="radio" name="rdbM" value="10" />&nbsp;&nbsp;Oct</a></li>
                            <li><a href=""><input type="radio" name="rdbM" value="12" />&nbsp;&nbsp;Nov</a></li>
                            <li><a href=""><input type="radio" name="rdbM" value="7" />&nbsp;&nbsp;Dec</a></li>

                        </ul>
                    </li>
                    <!-- THE SALARY FILTER OF CONDITIONS -->
                    <li class="drop-down"><a href="<c:url value="/admin"/>">STATISTIC BY YEAR</a>
                        <ul class="scrolltable">                     
                            <li><a href=""><input type="radio" name="rdbY" value="2020" />&nbsp;&nbsp;2020</a></li>
                            <li><a href=""><input type="radio" name="rdbY" value="2021" />&nbsp;&nbsp;2021</a></li>
                            <li><a href=""><input type="radio" name="rdbY" value="2022" />&nbsp;&nbsp;2022</a></li>
                        </ul>
                    </li>
                    <!-- THE LEVEL FILTER OF CONDITIONS -->
                    <li class="drop-down"><a href="<c:url value="/admin"/>">STATISTIC BY SEASONS</a>
                        <ul class="scrolltable">                     
                            <li><a href=""><input type="radio" name="rdbS" value="spring" />&nbsp;&nbsp;SPRING</a></li>
                            <li><a href=""><input type="radio" name="rdbS" value="summer"/>&nbsp;&nbsp;SUMMER</a></li>
                            <li><a href=""><input type="radio" name="rdbS" value="fall"/>&nbsp;&nbsp;FALL</a></li>
                            <li><a href=""><input type="radio" name="rdbS" value="winter" />&nbsp;&nbsp;WINTER</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>

        </div>
        <div class="form-group" style="padding-bottom: 30px;">
            <button type="button"
                    class="btn btn-danger " style=" float: right" onclick="sendCondition()">SUBMIT
            </button>
        </div>
        <div class="row">
            <div class="col-md-5">
                <div class="card" style="height: 600px; width: 500px">
                    <div class="card-header ">
                        <h4 class="card-title">ORDERED-WEDDING CHART BY CHART</h4>
                    </div>
                    <div class="card-body ">
                        <canvas id="doughnutchart"></canvas>  
                    </div>
                </div>
            </div>
            <div class="col-md-7">
                <div class="card " style="height: 600px; width: 700px">
                    <div class="card-header ">
                        <h4 class="card-title">ORDERED-WEDDING CHART BY TABLE</h4>
                    </div>
                    <div class="card-body ">
                        <div class="ct-chart">
                            <table id="chartTable" class="table">
                                <tr>
                                    <th>PERIOD</th>
                                    <th>TOTAL MONEY</th>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>      