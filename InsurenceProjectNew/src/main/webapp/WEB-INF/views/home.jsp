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
    	<h1>welcome ${customer.getFname() }</h1>
    	
    </div>
</body>
</html>