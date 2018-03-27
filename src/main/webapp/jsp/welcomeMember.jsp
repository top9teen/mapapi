<!DOCTYPE html>

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
    		%>
    		<%
	bean = (MemberBean) request.getSession().getAttribute("LoginMember");
    
%>
<body>
  
<div class="container">
  <h3>map</h3>
  <script  src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCvz1uVgLhfYyVUj_c0pwRDwAZPelVTIpE&libraries=places&callback=initMap"          type="text/javascript"></script>
  
  <h3>map TEST</h3>
    <form action="carmap2" method="post" name="carmap2">
  <input type="hidden" value="<%=bean.getMemUsername() %>" name="useremail">
  <input type="submit" class="btn btn-success" value="ดูรถ">&nbsp;
  <a  href="addcar2" class="btn btn-primary"> เพิ่มรถ</a>&nbsp;
  <a  href="logout" class="btn btn-danger">ออกระบบ </a>&nbsp;
  </form>
  <br><br><br><br>
  
  <div id="map" style="width:100%;height:1024px;"></div>
</div>

</body>
<script type="text/javascript" >   
 
 
var locations = [   
    ['TEST CAR ', 13.736717, 100.523186,'assets/img/1.png', 1],      
	];    
var map = new google.maps.Map(document.getElementById('map'), {      
zoom: 15,      
center: new google.maps.LatLng(13.736717, 100.523186),      
mapTypeId: google.maps.MapTypeId.ROADMAP   
});    
var infowindow = new google.maps.InfoWindow();    
var marker, i;    for (i = 0; i < locations.length; i++) {        
marker = new google.maps.Marker({        
position: new google.maps.LatLng(locations[i][1], locations[i][2]),       
map: map,
icon: locations[i][3]
});     

google.maps.event.addListener(marker, 'click', (function(marker, i) {        
return function() {         
 infowindow.setContent(locations[i][0]);          
 infowindow.open(map, marker);        
 }      
 })
 (marker, i));    
 }  
 </script>
</html>
