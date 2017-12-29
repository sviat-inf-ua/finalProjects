<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/views/header.jsp"%>
    <%@include file="/WEB-INF/views/menu.jsp"%>
    <div style="position: relative; top: 150px; left: 400px; overflow-x: hidden; width: 700px; text-align: center;">
    
    		<h1>${customer.getFname() }</h1>
    		<table>
    		<tr>
    			<td>&nbsp;</td>
    			<td></td>
    		</tr>
    		<tr>
    			<th>Date</th>
    			<th>Amount</th>
    		</tr>
    		<tr>
    			<td>&nbsp;</td>
    			<td></td>
    		</tr>
    		<c:forEach items="${bills }" var="bill">
    			<tr>
    			<td>${bill.getDateIssued() }</td>
    			<td>${bill.getAmount() }</td>
    			</tr>
    		</c:forEach>
    		</table>
    </div>
</body>
</html>