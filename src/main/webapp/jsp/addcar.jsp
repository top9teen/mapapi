<%@page import="com.example.model.MemberBean"%>
<%@page import="javax.swing.text.DefaultEditorKit.BeepAction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@page import="com.example.model.CarBean"%>
<%@ page import="java.util.List"%>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<title>เพิ่มรถ</title>

 <% CarBean bean = null;
 String result = "";
 MemberBean bean2 = null;

 %>
<%
 	bean = (CarBean) request.getSession().getAttribute("cardao");
    bean2 = (MemberBean) request.getSession().getAttribute("LoginMember");
	result = (String) request.getAttribute("messes");
%>
<body>
<form name="welcome" action="addcar" method="post" onSubmit="return fncSubmit();">
		<div class="container">
		<h2 align="center">WELCOME PROJECT<%=bean2.getMemUsername() %></h2>
		<br>
			<div class="alert alert-success" align="right">
				<strong>Welcome new user </strong>
	
			</div>
			<%
				if (result.equals("S")) {
			%>
			<div class="alert alert-success">
				<strong>Success!</strong> Insert Success....</div>
			
			<%
				} else if (result.equals("F")) {
			%>
			<div class="alert alert-danger">
				<strong>Danger!</strong> Insert Fail !....
			</div>
				<%
				} else if (result.equals("B")) {
			%>
			<div class="alert alert-danger">
				<strong>User Repetitive !</strong> User Repetitive !....
			</div>
			
			<%
				}
			%>
			<div class="form-group">
				<label  for="exampleInputEmail1"></label> <input   type="hidden"
					class="form-control" name="email" value="<%=bean2.getMemUsername() %>">
			</div>
			<div class="form-group">
				<label   for="exampleInputEmail1">Lat </label> <input  type="text"
					class="form-control" name="lat">

			<div class="form-group">
				<label for="exampleInputEmail1">Log</label> <input type="text"
					class="form-control" name="log">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Address</label> <input type="text"
					class="form-control" name="address">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">MID</label> <input type="number"
					class="form-control" name="mid">
			</div>
			<div align="right">
			<button type="submit" class="btn btn-outline-success">เพิ่ม</button>
			<a  href="welcomeMember" class="btn btn-outline-danger"> กลับ </a>
			&nbsp;
			</div>
		</div>
		</div>
	</form>
</body>
<script type="text/javascript"src="assets/js/RegFrom.js"></script>
</html>