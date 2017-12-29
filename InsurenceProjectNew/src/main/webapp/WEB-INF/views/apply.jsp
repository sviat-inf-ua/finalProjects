<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
/* tbody tr:nth-child(odd) {
   background-color: #ccc;
} */
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/header.jsp"%>
    	<%@include file="/WEB-INF/views/menu.jsp"%>
    <div style="position: relative; top: 150px; left: 400px; overflow-x: hidden; width: 900px; text-align: left;">
    
    	<form:form action="doapply" method="POST" onsubmit="return validatePassword()" modelAttribute="plan" >
    	<table>	
    	
    	
    	<c:forEach items="${plans }" var = "plan">
    	<tr>
    	<th></th>
    	 <th>Plan name</th>
    	 <th>Price</th>
    	 <th>Amount Of Coverage</th>
    	</tr>
    	<tr>
    	<td style="width:20px;">
    	<form:radiobutton path="id" value="${plan.getId() }"  />
    	</td>
    	<td>${plan.getName() }</td>
    	<td>${plan.getPrice() }</td>
    	<td>${plan.getAmountCovered() }</td>
    	<td></td>
    	</tr>
    	<tr> <th colspan="4" style="text-align: center">Benefits</th></tr>
    		<c:forEach items="${plan.getPlanBenefits() }" var = "benefit">
    		<tr>
    			<td></td>
    			<td></td>
    			<td>${benefit.getName() }</td>
    			<td>${benefit.getDescription() }</td>
    			<td>${benefit.getAmountCovered() }</td>
    		</tr>	
    		</c:forEach>
    		<tr>
    			<td colspan="4"> </td>
    		</tr>
   
    	</c:forEach>
    	<tr><td>
    	<input type="submit" name="submit" value="Apply">
    	</td></tr>
    	</table>
    	</form:form>
    	
    </div>
</body>
</html>