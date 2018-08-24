<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
<title>List Employees</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>HCL Employee</h2>
		</div>
		<hr>
		<div id="container">
			<div id="content">
				<input type="button" class="addButton" value="Add EMployee"
					onclick="window.location.href='addForm'; return false;" /><hr>
				<!-- a search box -->
				<form:form action="searchEmployee" method="POST">
Search employee: <input type="text" name="theSearchName" />

					<input type="submit" value="Search" class="addButton" />
				</form:form>
				<hr>
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