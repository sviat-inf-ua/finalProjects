<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="main.css">
     	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <script type='text/javascript' src="https://rawgit.com/RobinHerbots/jquery.inputmask/3.x/dist/jquery.inputmask.bundle.js"></script>
    <script src="viewJS.js"></script>
    <script type="text/javascript">
    $(document).ready(function() {
    	$("#phone").inputmask({"mask": "(999) 999-9999"});
    	$("#ssn").inputmask({"mask": "99999"});
    });
    function validatePassword() {
    	var x = document.getElementById("pswd").value;
    	var y = document.getElementById("confirmPswd").value;
    	if (x != y) {
    		alert('Password confirmation does not match password entered');
    		return false;
    	}
    }
    </script>
</head>
<body>
		<%@include file="/WEB-INF/views/header.jsp"%>
    	<%@include file="/WEB-INF/views/menu.jsp"%>
    <div style="position: relative; top: 150px; left: 400px; overflow-x: hidden; width: 900px; text-align: center;">	
	<table>
	<h1>${msg }</h1>
	<%-- <form action="create.spring" method="POST"> --%>
	<form:form action="create.spring" method="POST" id="form" onsubmit="return validatePassword()"  modelAttribute="customer">
	<tr>
	<td>
		<!-- <input type="text" name="fname" placeholder="First Name"> -->
		<form:input path="fname" placeholder="First Name" class="input"/>
	</td>
	<td>
		<form:errors path="fname" cssStyle="color: red"></form:errors>
	</td>
	</tr>
	<tr>
	<td>
		<!-- <input type="text" name="lname" placeholder="Last Name"> -->
		<form:input path="lname" placeholder="Last Name" class="input"/>
	</td>
	<td>
		<form:errors path="lname" cssStyle="color: red"/> 
	</td>
	</tr>
	<tr>
	<td>
		<!-- <input type="text" name="mname" placeholder="Middle Name"> -->
		<form:input path="mname" placeholder="Middle Name" class="input"/>
	</td>
	<td>
		<%-- <form:errors path="dob" cssStyle="color: red"></form:errors> --%>
	</td>
</tr>
	<tr>
	<td>
		<!-- <input type="email" name="email" placeholder="Email Address"> -->
		<form:input path="email" placeholder="Email Address" class="input"/>
	</td>
	<td>
		<form:errors path="email" cssStyle="color: red" />
	</td>
	</tr>
	<tr>
	<td>
		<!-- <input type="date" name="dob" placeholder="Date Of Birth"> -->
		<form:input path="dob" placeholder="Date of Birth" class="input"/>
	</td>
	<td>
		<form:errors path="dob" cssStyle="color: red"></form:errors>
	</td>
	</tr>
	<tr>
	<td>
		<!-- <input type="text" name="phone" placeholder="Phone Numeber"> -->
		<form:input path="phone" id="phone" placeholder="Phone Number" class="input"/>
	</td>
	<td>
		<form:errors path="phone" cssStyle="color: red"></form:errors>
	</td>
</tr>
<tr>
	<td>
		<!-- <input type="text" name="ssn" placeholder="SSN"> -->
		<form:input path="ssn" placeholder="SSN" class="input"/>
	</td>
	<td>
		<form:errors path="ssn" cssStyle="color: red"></form:errors>
	</td>
</tr>
<tr>
	<td>
		<!-- <input type="password" name="pswd" placeholder="Password"> -->
		<form:input path="pswd" type="password" placeholder="Password" class="input"/>
	</td>
	<td>
		<form:errors path="pswd" id="pswd" type="password" cssStyle="color: red"></form:errors> 
	</td>
</tr>
<tr>
	<td>
		<input type="password" name="confirmPswd" id="confirmPswd" placeholder="Confirm Password" class="input"/>
	</td>
</tr>
<tr>
	<td colspan="2"><input type="submit" name="submit" value="Register" class ="button"></td>
</tr>
</form:form>
<%-- </form> --%>
</table>
</div>
</body>
</html>