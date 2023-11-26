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
		String lang1 = ""+session.getAttribute("lang");
		String ss = session.getAttribute("mess") != null ? ""+session.getAttribute("mess") : "home";
	%>
	<fmt:setLocale value="<%= lang1 %>" scope="request"/>
	<fmt:setBundle basename="home" scope="request"/>

</body>
</html>