<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="styleSheet" type="text/css" href="css/signstyles.css">
</head>
<body>

	<div class = "sign-container">
	<%
	String message = request.getParameter("message");
	if("sign-success".equals(message)) {
		out.println("<p>회원가입 완료</p>");
	} else if ("error".equals(message)) {
		out.println("<p>오류 발생</p>");
	}
	%>
	<form action="login.jsp" id="loginbutton">
		<button type="submit">로그인</button>
	</form>
	
	</div>
</body>
</html>