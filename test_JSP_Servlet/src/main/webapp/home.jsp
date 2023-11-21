<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%
			String test = "Hello";
		%>
		<h1>DungVipPro</h1>
		<hr>
		<a href="change-layout/home"> Home</a>
		<a href="change-layout/about">About</a>
		<a href="change-layout/contact">Contact Us</a>
		
		<jsp:include page="/layout.jsp"></jsp:include>
		
		<h3></h3>
		
		<script type="text/javascript">
			var oday = '<%= test %>' ;
			document.querySelector("h3").innerHTML = 'Hello ' + oday
			console.log("<%= test %>");
		</script>
	</body>
</html>