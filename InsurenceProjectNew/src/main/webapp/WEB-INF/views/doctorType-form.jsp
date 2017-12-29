<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
<title>Save Doc type</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<%-- <link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"> --%>
</head>

<body>
<%@include file="/WEB-INF/views/addStyle.jsp"%>

	<div id="wrapper">
		<div id="header">
			<h2>Doctor Type</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save type of doctor</h3>

		<form:form action="saveDoctorType" modelAttribute="doctorType"
			method="POST">

			<!-- need to associate this data with customer id -->
			<%-- <form:hidden path="id" /> --%>

			<table>
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<!--  <td><input type="number"  name="doctorId" /></td>  -->
						<%-- <td><form:select path="doctor" items="${doctors}" name="doctorId" value="${doctor.id}" itemLabel="firstName"></form:select> --%>
						
						<td><form:select  path="id">
									<c:forEach var="doctor" items="${doctors}">
										<form:option  value="${doctor.getId()}">${doctor.getFirstName() } ${doctor.getLastName() }</form:option>
									</c:forEach>
								</form:select></td>
						
						
					</tr>
					<tr>
						<td><label>Type:</label></td>
						<td><input type="text" name="doctorType" /></td>
					</tr>

					<%-- <tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName" /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>
					</tr> --%>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>


				</tbody>
			</table>


		</form:form>

		<div style=""></div>

		<p>
			<a href="${pageContext.request.contextPath}/admin">Back
				to admin home</a>
		</p>

	</div>
	<div>

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
						<td> ${tempDoctor.id} </td>
						<td> ${tempDoctor.firstName} </td>
						<td> ${tempDoctor.lastName} </td>
						<td> ${tempDoctor.cellPhone} </td>
						
					</tr>
				
				</c:forEach>
						
			</table>
	</div>

</body>

</html>










