<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Form</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-employee.css">
<style>
form {
	margin-top: 10px;
}

label {
	font-size: 16px;
	width: 100px;
	display: block;
	text-align: right;
	margin-right: 10px;
	margin-top: 8px;
	margin-bottom: 8px;
}

input {
	width: 250px;
	border: 1px solid #666;
	border-radius: 5px;
	padding: 4px;
	font-size: 16px;
}

.save {
	font-weight: bold;
	width: 130px;
	padding: 5px 10px;
	margin-top: 30px;
	background: #cccccc;
}

table {
	border-style: none;
	width: 50%;
}

tr:nth-child(even) {
	background: #FFFFFF
}

tr:nth-child(odd) {
	background: #FFFFFF
}

tr {
	border-style: none;
	text-align: left;
}

html, body {
	margin-left: 15px;
	margin-right: 15px;
	padding: 0px;
	font-family: Verdana, Arial, Helvetica, sans-serif;
}

table {
	border-collapse: collapse;
	border-bottom: 1px solid gray;
	font-family: Tahoma, Verdana, Segoe, sans-serif;
	width: 72%;
}

th {
	border-bottom: 1px solid gray;
	background: none repeat scroll 0 0 #18b2c3;
	padding: 10px;
	color: #FFFFFF;
}

tr {
	border-top: 1px solid gray;
	text-align: center;
}

tr:nth-child(even) {
	background: #a5a5a5
}

tr:nth-child(odd) {
	background: #BBBBBB
}

#wrapper {
	width: 100%;
	margin-top: 0px;
}

#header {
	width: 70%;
	background: #0998c3;
	margin-top: 0px;
	padding: 15px 0px 15px 15px;
}

#header h2 {
	width: 100%;
	margin: auto;
	color: #FFFFFF;
}

#container {
	width: 100%;
	margin: auto
}

#container h3 {
	color: #000;
}

#container #content {
	margin-top: 20px;
}

.addButton {
	border: 1px solid #666;
	border-radius: 5px;
	padding: 4px;
	font-size: 12px;
	font-weight: bold;
	width: 120px;
	padding: 5px 10px;
	margin-bottom: 15px;
	background: #5b7dca;
}

.error{color:red}
</style>

</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h3>Employee Form</h3>
		</div>
	</div>

	<div id="container">
		<h3>Save Employee</h3>

		<form:form action="saveEmployee" modelAttribute="employee"
			method="POST">
			<!-- Without this we may loose customer's ID. This is important 
				Even though saveEmployee action works.
				We need this to keep a track of which customer is getting updated.
			-->
			<form:hidden path="id" />
			<table>
				<tbody>
					<tr>
						<td><label>First name(*)</label></td>
						<td><form:input path="firstName"/>
						<form:errors path="firstName" cssClass="error"/></td>
					</tr>

					<tr>
						<td><label>Last name(*)</label></td>
						<td><form:input path="lastName"/> 
						<form:errors path="lastName" cssClass="error"/></td>
					</tr>

					<tr>
						<td><label>Email(*)</label></td>
						<td><form:input path="email"/>
						<form:errors path="email" cssClass="error"/></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>


				</tbody>
			</table>


		</form:form>

		<div style=""></div>

		<p>
			<a href="${pageContext.request.contextPath}/employee/list">Back
				to List</a>
		</p>

	</div>

</body>
</html>