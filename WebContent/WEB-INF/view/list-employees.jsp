<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<title>List Employees</title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>HCL Employee</h2>
		</div>
		<div id="container">
			<div id="content">
			<input type="button" class="addButton" value="Add EMployee"
			onclick="window.location.href='addForm'; return false;"
			/>
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email Name</th>
					</tr>
					<!-- rendering data from controller --> 
					<c:forEach var="tempEmployee" items="${employees}">
						<tr>
							<td>${tempEmployee.firstName}</td>
							<td>${tempEmployee.lastName}</td>
							<td>${tempEmployee.email}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>


</body>

</html>