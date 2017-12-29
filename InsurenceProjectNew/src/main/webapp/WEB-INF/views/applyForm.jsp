<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer - Address</title>
	<script type="text/javascript">
	 function validateField() {
	    	if (document.getElementById("street").value =="") {
	    		alert('Street can not be empty');
	    		return false;
	    	}
	    	if (document.getElementById("apt").value =="") {
	    		alert('Apartmanet can not be empty');
	    		return false;
	    	}
	    	if (document.getElementById("city").value =="") {
	    		alert('City can not be empty');
	    		return false;
	    	}
	    	if (document.getElementById("State").value =="") {
	    		alert('State can not be empty');
	    		return false;
	    	}
	    	if (document.getElementById("zip").value =="" || isNaN(document.getElementById("zip").value)) {
	    		alert('Zip code can not be empty and must be a number');
	    		return false;
	    	}
	    }
	
	</script>
</head>
<body>

		<%@include file="/WEB-INF/views/header.jsp"%>
    	<%@include file="/WEB-INF/views/menu.jsp"%>
    	<div style="position: relative; top: 150px; left: 400px; overflow-x: hidden; width: 900px; text-align: center;" id="registerForm">	
    	
    	
    	
    	<form:form  action="address" method="POST" modelAttribute="customer" onsubmit="return validateField()">
    	<fieldset class="field">	
    	<legend>Address</legend>
    		<table>
    			<tr>
    				<td><form:input path="street" class="input" placeholder="Street"  id="street"/></td>
    				<td><form:errors path="street" cssStyle="color: red"></form:errors></td>
    			</tr>
    			<tr>
    				<td><form:input path="apt" class="input" placeholder="Apartment" id="apt"/></td>
    				<td><form:errors path="apt" cssStyle="color: red"></form:errors></td>
    			</tr>
    			<tr>
    				<td><form:input path="city" class="input" placeholder="City" id="city"/></td>
    				<td><form:errors path="city" cssStyle="color: red"></form:errors></td>
    			
    			</tr>
    			<tr>
    				<td><form:input path="State" class="input" placeholder="State" id="State"/></td>
    				<td><form:errors path="State" cssStyle="color: red"></form:errors></td>
    			</tr>
    			<tr>
    				<td><form:input path="zip" class="input" placeholder="Zip" id="zip"/></td>
    				<td><form:errors path="zip" cssStyle="color: red"></form:errors></td>
    			</tr>
    				<td colspan="2"><input type="submit" name="submit" value="Next" class="button"></td>
    			</tr>
    			
    		</table>
    	</fieldset>
    	</form:form>
    	
    	
    		
    	<%-- <form:form>
    	<fieldset>
    	<legend>Phisycal Information</legend>
    		<table>
    			<tr>
    				<td><form:input path="height" class="input"  placeholder="Height in ft"/> </td>
    				<td><form:errors path="height" cssStyle="color: red"></form:errors></td>
    			</tr>
    			<tr>
    				<td><form:input path="weight" class="input"  placeholder="weight in lb"/> </td>
    				<td><form:errors path="country" cssStyle="color: red"></form:errors></td>
    			</tr>
    			<tr>
    				<select>
    					<c:forEach items="${asdf }" var="allergies">
    					<option value="${asdf }">${asdf }</option>
    					</c:forEach>
    				</select>
    			</tr>
    		</table>
    	</fieldset>
    	</form:form> --%>
    	</div>
</body>
</html>