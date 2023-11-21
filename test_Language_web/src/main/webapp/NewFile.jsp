<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<%-- <c:url var="home" value="/home"/> --%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	String lang = request.getParameter("lang");
	session.setAttribute("lang", lang);
%>
<fmt:setLocale value="<%= lang %>" scope="request"/>
<fmt:setBundle basename="global" scope="request"/>
	<a href="?lang=vi"><fmt:message key="menu.home"/></a>
	<h1><%= session.getAttribute("lang") %></h1>
</body>
</html>