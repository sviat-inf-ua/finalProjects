<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function enable() {
		if(document.getElementById("aler").checked) {
			document.getElementById("allergies").disabled = false;
		} else {
			document.getElementById("allergies").disabled = true;
		}
	}
	 function validateField() {
	    	if (document.getElementById("height").value =="" || isNaN(document.getElementById("height").value)) {
	    		alert('Height can not be empty and must be a number');
	    		return false;
	    	}
	    	if (document.getElementById("weight").value =="" || isNaN(document.getElementById("weight").value)) {
	    		alert('Weight can not be empty and must be a number');
	    		return false;
	    	}
	    	if (document.getElementById("AnnualIncome").value =="" || isNaN(document.getElementById("AnnualIncome").value)) {
	    		alert('Annual Income can not be empty and must be a number');
	    		return false;
	    	}
	 }
</script>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
    	<%@include file="/WEB-INF/views/menu.jsp"%>
    	<div style="position: relative; top: 150px; left: 400px; overflow-x: hidden; width: 900px; text-align: center;" id="registerForm">	
    	
    	
    	
    	<form:form  action="physicalInf" method="POST" modelAttribute="customer" onsubmit="return validateField()">
    	<fieldset class="field">	
    	<legend>More about You</legend>
    		<table>
    			<tr>
    				<td><form:input path="height" class="input" placeholder="Your Height in ft" id="height"/></td>
    				<td><form:errors path="street" cssStyle="color: red"></form:errors></td>
    			</tr>
    			<tr>
    				<td><form:input path="weight" class="input" placeholder="Your weight in lb" id="weight"/></td>
    				<td><form:errors path="apt" cssStyle="color: red"></form:errors></td>
    			</tr>
    			<tr>
    				<td  style="text-align: center;"><input type="checkbox" id="aler" onchange="enable()">Allergic?</td>
    				<td></td>
    			</tr>
    			<tr>
    				<td><form:input path="allergies" class="input" id="allergies" placeholder="Allergies" disabled="true"/></td>
    				<td><form:errors path="allergies" cssStyle="color: red"></form:errors></td>
    			</tr>
    			<tr>
    				<td><form:checkbox path="asma"/>Asmatic</td>
    				<td><form:errors path="asma" cssStyle="color: red"></form:errors></td>
    			</tr>
    			<tr>
    				<td><form:input path="AnnualIncome" class="input" placeholder="Annual Income" id="AnnualIncome"/></td>
    				<td><form:errors path="AnnualIncome" cssStyle="color: red"></form:errors></td>
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