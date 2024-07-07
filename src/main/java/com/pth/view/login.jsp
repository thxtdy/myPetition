<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="css/loginStyles.css">
</head>
<body>
	<div class="login-container">
		<h2>로그인</h2>
		<form action="LoginServlet" method="POST">
			<label for="userid">아이디</label> 
			<input type="text" id="id" name="userid">
			
			<label for="password">비밀번호</label>
            <input type="password" id="password" name="userpw">
            
            <button type="submit" id ="complete">로그인</button>
		</form>

	</div>
</body>
</html>