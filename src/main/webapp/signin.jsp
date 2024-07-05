<%@page import="java.awt.Window"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <link rel="stylesheet" href="css/signstyles.css">

</head>
<body>
    <div class="signup-container">
        <h2>회원가입</h2>
        <form action="login.jsp" method="post">
        
            <label for="username">사용자 이름</label>
            <input type="text" id="username" name="username">

            <label for="email">이메일</label>
            <input type="email" id="email" name="email">

            <label for="userid">아이디</label>
            <input type="text" id="id" name="userid">

            <button type="submit" id="check" form="check-form">중복 확인</button>
            				<!-- Javascript 중복 확인 함수 -->
            <label for="password">비밀번호</label>
            <input type="password" id="password" name="userpw">

            <label for="confirm-password">비밀번호 확인</label>
            <input type="password" id="confirm-password" name="confirm-password">
			
			<button type="submit" id="complete" >가입하기</button>
        </form>
        
        <form id = "check-from" action="CheckServlet" method="get">
            <input type="hidden" id="check-userid" name="userid">
        
        </form>
        
    </div>
    
    <script type="text/javascript">
    
    function openPopup() { 
        document.getElementById('popup').style.display = 'block'; 
    } 
    function closePopup() { 
        document.getElementById('popup').style.display = 'none';  
    } 
    
    </script>
    
</body>
</html>
