<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<% 
		String lang = request.getParameter("lang");
		if(request.getParameter("lang") == null){
			lang = ""+session.getAttribute("lang");
		} else {	
			lang = request.getParameter("lang");		
			session.setAttribute("lang", lang);
		}
	%>
	<fmt:setLocale value="<%= lang %>" scope="request"/>
	<fmt:setBundle basename="global" scope="request"/>
		<h1>DungVipPro</h1>
		<hr>
		<a href="change-layout/home"><fmt:message key="menu.home"/></a>
		<a href="change-layout/about"><fmt:message key="menu.about"/></a>
		<a href="change-layout/contact"><fmt:message key="menu.contact"/></a>
		<span> | </span>
		<a href="?lang=vi">Vietnamese </a>
		<a href="?lang=en">English</a>
		
		<%-- <jsp:include page="/layout.jsp"></jsp:include> --%>
	</body>
</html>