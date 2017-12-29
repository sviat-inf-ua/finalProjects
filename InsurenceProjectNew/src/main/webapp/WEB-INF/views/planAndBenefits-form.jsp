<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/views/addStyle.jsp"%>
	<div id="wrapper">
		<div id="header">
			<h2>View locations</h2>
		</div>
	</div>
	${msg }
	<form:form action="addplan" modelAttribute="benefit">
		<form:input path="name" placeholder="Name" />
		<form:input path="description" placeholder="Description" />
		<form:input path="amountCovered" placeholder="Amount Covered" />
		<form:button type="submit">create</form:button>
	</form:form>
</body>
</html>