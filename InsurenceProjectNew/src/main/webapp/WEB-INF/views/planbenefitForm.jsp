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
			<h2>Add Benefit Page</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">

			<div id="registerForm">
				<form:form action="savePlanBenefit" method="POST" id="form"
					modelAttribute="plan">
					<table>
						<tr>
							<td><form:select  path="id">
									<c:forEach var="plan" items="${list}">
										<form:option  value="${plan.getId()}">${plan.getName() }</form:option>
									</c:forEach>
								</form:select></td><td></td>
						</tr>
						<c:forEach var="benefit" items="${list2}">
							<tr>
								<td><input type="checkbox" class="input" name="benefitId"
									value="${benefit.getId() }" /></td>
								<td>${benefit.getName() }</td>
							</tr>
						</c:forEach>

						<tr>
							<td></td><td><input type="submit" value="add benefits"
								class="add-button"></td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>