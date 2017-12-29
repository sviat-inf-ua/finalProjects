<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Update Doctor</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<style type="text/css">
input[type=number] {
	size: 10;
}
</style>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
<%@include file="/WEB-INF/views/addStyle.jsp"%>
	<div id="container">
		<h3>New Doctor Page</h3>
		<form:form action="saveDoctor" modelAttribute="doctor"
			method="POST">
			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />

			<%-- <c:when test="${doctor !=null }"> --%>
			<table>
				<tbody>
					<tr>
						<td><input type="text" id="firstName" name="firstName"
							value="${doctor.firstName}"></td>
						<td>first name</td>
					</tr>

					<tr>
						<td><input type="text" name="lastName"
							value="${doctor.lastName}"></td>
						<td>last name</td>
					<tr>
						<td><input type="text" name="cellPhone"
							value="${doctor.cellPhone}"></td>
						<td>mobile phone</td>
					</tr>

					<tr>
						<td><input type="email" name="email" value="${doctor.email}"></td>
						<td>email</td>
					</tr>

					<tr>
						<td><input type="password" id="pswd" name="password"
							value="${doctor.password}"></td>
						<td>password</td>
					</tr>

					<tr>
						<td><input type="password" name="passwordCommit"
							value="${doctor.passwordCommit}"></td>
						<td>password commit</td>
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
	</div>
</body>
</html>

