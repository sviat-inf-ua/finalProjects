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
	<div id="container">
		<h3>Save Location</h3>

		<form:form action="saveLocation" modelAttribute="location"
			method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />

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
						<td>
							<!--  <input type="text" name="doctors_id" 
						placeholder="doc id"> -->
						
						
						
						 <%-- <form:select path="doctor"
								items="${doctor}" itemValue="id" itemLabel="firstName"></form:select> --%>
								
								 <form:select path="doctor" class="form-control" items="${doctors}" itemLabel="firstName" itemValue="id" id="doctor"/>
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
			<a href="${pageContext.request.contextPath}/admin/listLocations">Back
				to List</a>
		</p>

	</div>
</body>
</html>
