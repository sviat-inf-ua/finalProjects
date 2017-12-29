<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@include file="/WEB-INF/views/addStyle.jsp"%>
	<div id="wrapper">
		<div id="header">
			<h2>Add Plan Page</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">


			<div id="registerForm">
				<form:form action="saveInsurancePlanForm" method="POST" id="form"
					modelAttribute="plan">
					<table>
						<tbody>
							<tr>
								<td><form:input path="name" placeholder="Plan Name"
										class="input" /></td>
							</tr>
							<tr>
								<td><form:input path="price" placeholder="Plan Price"
										class="input" /></td>
							</tr>
							<tr>
								<td><form:input path="amountCovered"
										placeholder="Amount Covered" class="input" /></td>
							</tr>
							<tr>
								<td><input type="submit" value="Create Plan"></td>
							</tr>
						</tbody>
					</table>
				</form:form>
				<p>
					<a href="${pageContext.request.contextPath}/admin">Back to
						admin home</a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>