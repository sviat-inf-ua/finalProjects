<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<title>List types of doctors</title>

<!-- reference our style sheet -->

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>
	<%@include file="/WEB-INF/views/addStyle.jsp"%>

	<div id="wrapper">
		<div id="header">
			<h2>View Types of Doctor</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<!-- put new button: Add Customer -->

			<input type="button" value="Add Doctor type"
				onclick="window.location.href='showDoctorTypeForm'; return false;"
				class="add-button" />

			<!--  add our html table here -->

			<table>
				<tr>
					<th>Type</th>
					<th>Doctor name</th>
				</tr>

				<!-- loop over and print our doctors -->
				<c:forEach var="tempDoctorType" items="${doctorTypes}">

					<!-- construct an "update" link with customer id -->
					<%-- <c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>	 --%>

					<!-- construct an "delete" link with customer id -->
					<%-- <c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>					
					 --%>
					<tr>
						<td>${tempDoctorType.doctorType}</td>
						<td>${tempDoctorType.doctor.firstName}</td>

						<%-- 	<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td> --%>

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









