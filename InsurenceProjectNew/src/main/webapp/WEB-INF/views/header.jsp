<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  	<%-- <%@include file="../../resources/mainCss.jsp" %> --%>
  	<%@include file="/WEB-INF/views/mainCss.jsp"%>
<nav id="headerNav">
	<div id="logo">						
	
	
		<a href="registerUser"><img src="file:///C:/Users/sviat/Desktop/SviatoslavNaida_Java_Eavl/InsurenceProjectNew/src/main/resources/logo.jpg" width="50px" height="50px"></a>
	</div>
	<div id="mainNav">
		<ul>
			<li class="horizontalButton"><a href="${pageContext.request.contextPath}/">Home</a></li>
			<li class="horizontalButton"><a href="${pageContext.request.contextPath}/contactUs">Contact Us</a></li>
			<li class="horizontalButton"><a href="">About Us</a></li>
		</ul>
	</div>
</nav>