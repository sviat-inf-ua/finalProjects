<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>Save Location</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
	<%@include file="/WEB-INF/views/addStyle.jsp"%>
	<div id="container">
		<h3>Save Location</h3>

		<form:form action="saveLocation" modelAttribute="location"
			method="POST">

			<!-- need to associate this data with customer id -->
			<%-- <form:hidden path="id" /> --%>

			<table>
				<tbody>
					<tr>
						<td><input type="text" name="country" placeholder="Country"></td>
					</tr>

					<tr>
						<td><input type="text" name="city" placeholder="City"></td>
					</tr>

					<tr>
						<td><input type="text" name="street" placeholder="Street "></td>
					</tr>

					<tr>
						<td><input type="text" name="apt" placeholder="Building #">
						</td>
					</tr>
					<tr>
						<!-- <td><input type="text" name="doctorId" placeholder="doc id"> -->
						<td><form:select  path="id">
									<c:forEach var="doctor" items="${doctors}">
										<form:option  value="${doctor.getId()}">${doctor.getFirstName() } ${doctor.getLastName() }</form:option>
									</c:forEach>
								</form:select></td>


							<%-- <form:select path="doctor"
								items="${doctor}" itemValue="id" itemLabel="firstName"></form:select> --%>
							<%-- 
								 <form:select path="doctor" class="form-control" items="${doctors}" itemLabel="firstName" itemValue="id" id="doctor"/> --%>
						</td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" name="submit"
							value="Save"></td>
					</tr>


				</tbody>
			</table>


		</form:form>



		<div style=""></div>

		<p>
		<a href="${pageContext.request.contextPath}/admin">Back to admin
			home</a>
	</p>

	</div>

	<table>
		<tr>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Mobile Phone</th>
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
				<td>${tempDoctor.id}</td>
				<td>${tempDoctor.firstName}</td>
				<td>${tempDoctor.lastName}</td>
				<td>${tempDoctor.cellPhone}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
