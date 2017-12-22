<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Save Doctor</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<style type="text/css">

input[type=number]{
    size: 10;
} 
</style>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
	<div id="container">
		<h3>New Doctor Page</h3>
		<form:form action="saveDoctor" modelAttribute="doctor" method="POST">
			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />

			<table>
				<tbody>
					<tr>
						<td><input type="text" name="firstName"
							placeholder="First Name"></td>
					</tr>

					<tr>
						<td><input type="text" name="lastName"
							placeholder="Last Name "></td>
					</tr>

					<tr>
						<td><input type="number" size="10" name="cellPhone"
							placeholder="cellPhone "></td>
					</tr>

					<tr>
						<td><input type="email" name="email" placeholder="email"></td>
					</tr>

					<tr>
						<td><input type="password" id="pswd" name="password"
							placeholder="password"></td>
					</tr>

					<tr>
						<td><input type="password" id="confirmPswd" name="passwordCommit"
							placeholder="passwordCommit"></td>
					</tr>

					<!-- <tr>
						<td><input type="text" name="active" placeholder="isActive">
						</td>
					</tr> -->
					<tr>
						<td colspan="2"><input type="submit" name="submit"
							value="Save"></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		<div style=""></div>
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back
				to List</a>
		</p>
	</div>
</body>
</html>
