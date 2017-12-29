<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
    	<%@include file="/WEB-INF/views/menu.jsp"%>
    <div style="position: relative; top: 150px; left: 400px; overflow-x: hidden; width: 900px; text-align: center;">
${msg }
	<form action="dologin.spring" method="POST">
	<input type="email" name="email" placeholder="Enter Email Address" class="input"><br/>
	<input type="password" name="pswd" placeholder="Enter password" class="input"><br/>
	<input type="submit" name="submit" value="Login" class="button">
	
</form>
</div>
</body>
</html>