<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


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

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
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
						<td><label>id:</label></td>
						<!-- <td><input type="number"  name="doctor_id" /></td> -->
						<td><form:select path="doctor" items="${theDoctors}"
								itemValue="id" itemLabel="firstName"></form:select>
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
			<a href="${pageContext.request.contextPath}/admin/docTypeList">Back
				to List</a>
		</p>

	</div>

</body>

</html>










