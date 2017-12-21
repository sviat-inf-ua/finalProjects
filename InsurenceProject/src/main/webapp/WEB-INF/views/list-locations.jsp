<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<title>List Doctors</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="container">

		<div id="content">

			<!-- put new button: Add Location -->

			<input type="button" value="Add Location"
				onclick="window.location.href='showLocationForm'; return false;"
				class="add-button" />
			<!--  add our html table here -->

			<table>
				<tr>
					<th>Country</th>
					<th>City</th>
					<th>street</th>
					<th>apt</th>
					<th>Doctor name</th>
					
				</tr>

				<!-- loop over and print our locations -->
				<c:forEach var="tempLocation" items="${locations}">

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
						<td>${tempLocation.country}</td>
						<td>${tempLocation.city}</td>
						<td>${tempLocation.street}</td>
						<td>${tempLocation.apt}</td>
						<td>${tempLocation.doctor.firstName}</td>
						

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