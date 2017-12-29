<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<title>List Doctors</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>
	<%@include file="/WEB-INF/views/addStyle.jsp"%>
	
	<div id="wrapper">
		<div id="header">
			<h2>View Doctors</h2>
		</div>
	</div>
	
	<div id="container">

		<div id="content">

			<!-- put new button: Add Customer -->

			<input type="button" value="Add Doctor"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />

			<!--  add our html table here -->

			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Mobile Phone</th>
					<th>Email</th>
					<th>Password</th>
					<th>Update/Delete</th>
				</tr>

				<!-- loop over and print our doctors -->
				<c:forEach var="tempDoctor" items="${doctors}">

					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/showFormForUpdate">
						<c:param name="doctorId" value="${tempDoctor.id}" />
					</c:url>

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/delete">
						<c:param name="doctorId" value="${tempDoctor.id}" />
					</c:url>

					<tr>
						<td>${tempDoctor.firstName}</td>
						<td>${tempDoctor.lastName}</td>
						<td>${tempDoctor.cellPhone}</td>
						<td>${tempDoctor.email}</td>
						<td>${tempDoctor.password}</td>

						<td>
							<!-- display the update link --> <a href="${updateLink}">Update</a>
							| <a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>

					</tr>

				</c:forEach>

			</table>

		</div>

	</div>
	<p>
		<a href="${pageContext.request.contextPath}/admin">Back to admin
			home</a>
	</p>
</body>
</html>