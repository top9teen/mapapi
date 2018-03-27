<!DOCTYPE html>
<%@page import="java.sql.*"%>
<%@page import="com.example.util.*"%>

<%@page import="javax.swing.text.DefaultEditorKit.BeepAction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@page import="com.example.model.*"%>
<%@ page import="java.util.List"%>
<html lang="en">
<head>

  <title>Bootstrap Example</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<%
	MemberBean bean = null;
List<CarBean> carBean = null;
%>
<%
	bean = (MemberBean) request.getSession().getAttribute("LoginMember");
 carBean = (List<CarBean>) request.getAttribute("listcar");
    
%>
<script  src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCvz1uVgLhfYyVUj_c0pwRDwAZPelVTIpE&libraries=places&callback=initMap"          type="text/javascript"></script>
<body>
<!-- <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="welcomeMember">หน้าแรก</a></li>
      <li><a href="addcar2">เพิ่มรถ</a></li>
      <li><a href="logout">ออก</a></li>
    </ul>
  </div>
</nav> -->
  
<div class="container">

   <h3>map my  <%=bean.getMemUsername() %></h3>
    <form >
  <a  href="welcomeMember" class="btn btn-success"> หน้าแรก</a>&nbsp;
  <a  href="addcar2" class="btn btn-primary"> เพิ่มรถ</a>&nbsp;
  <a  href="logout" class="btn btn-danger">ออกระบบ </a>&nbsp;
  </form>
  <br><br><br><br>
    <div id="map" style="width:100%;height:1024px;"></div>
  
</div>

</body>

<script type="text/javascript" >  
var address = "";
var longti = "";
var lastti = "";
var vaId = "";
var mid = "";
var bs = "'";
var locations = [];
<% for(int i=0; i < carBean.size();i++){%>
	address = '<%=carBean.get(i).getCarAddress()%>'
	longti =	<%=carBean.get(i).getCarLat()%>
	lastti =	<%=carBean.get(i).getCarLog()%>
	vaId =	<%=carBean.get(i).getCarId()%>
	mid = <%=carBean.get(i).getCarMid()%>
	
	locations.push([bs,address,bs,longti,lastti,'assets/img/1.png',mid,vaId]);
<%}%>  
	    
var map = new google.maps.Map(document.getElementById('map'), {      
zoom: 15,      
center: new google.maps.LatLng(13.716117 , 100.656631),      
mapTypeId: google.maps.MapTypeId.ROADMAP   
});    
var infowindow = new google.maps.InfoWindow();     
var marker, i;    for (i = 0; i < locations.length; i++) {        
marker = new google.maps.Marker({        
position: new google.maps.LatLng(locations[i][3], locations[i][4]),       
map: map,
icon: locations[i][5]
});     

google.maps.event.addListener(marker, 'click', (function(marker, i) {        
return function() {         
 infowindow.setContent(locations[i][1]);          
 infowindow.open(map, marker);        
 }      
 })
 (marker, i));    
 }  
 </script>
</html>
