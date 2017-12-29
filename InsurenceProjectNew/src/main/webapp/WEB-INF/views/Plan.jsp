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
    <div style="position: relative; top: 150px; left: 400px; overflow-x: hidden; width: 900px; text-align: left;">
    <h1 style="text-align:center">${msg }</h1>
    <p style="text-align:center">Below you will find the plan you applied for with all its benefits</p>
    	<table>
    	<tr>
    	<th>${plan.getName() }</th>
    	<th></th>
    	<th></th>
    	<th></th>
    	</tr>
    	<c:forEach items="${benefits }" var="benefit">
    	<tr>
    	
    		<td></td><td>${benefit.getName() }<td><td>${benefit.getDescription() }</td><td>${benefit.getAmountCovered() }</td>
    	</tr>
    	</c:forEach>
    
    </table>
    </div>
</body>
</html>