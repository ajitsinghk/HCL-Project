<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
<title>List Employees</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<style>
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
</style>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>HCL Employee</h2>
		</div>
		<div id="container">
			<div id="content">
				<input type="button" class="addButton" value="Add EMployee"
					onclick="window.location.href='addForm'; return false;" />
				<!-- a search box -->
				<form:form action="searchEmployee" method="POST">
Search employee: <input type="text" name="theSearchName" />

					<input type="submit" value="Search" class="addButton" />
				</form:form>
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
					<!-- rendering data from controller -->
					<c:forEach var="tempEmployee" items="${employees}">
						<!-- constructing "update" link with employee id -->
						<c:url var="updateLink" value="/employee/updateForm">
							<c:param name="employeeId" value="${tempEmployee.id}" />
						</c:url>
						<!-- constructing "delete" link with employee id -->
						<c:url var="deleteLink" value="/employee/delete">
							<c:param name="employeeId" value="${tempEmployee.id}" />
						</c:url>
						<tr>
							<td>${tempEmployee.firstName}</td>
							<td>${tempEmployee.lastName}</td>
							<td>${tempEmployee.email}</td>
							<td>
								<!-- update link --> <a href="${updateLink}">Update</a> <!-- Delete link -->
								<a href="${deleteLink}"
								onclick="if (!(confirm('Are you sure you want to delete this employee?'))) return false">Delete</a>
							</td>
						</tr>

					</c:forEach>
				</table>
			</div>
		</div>
	</div>


</body>

</html>