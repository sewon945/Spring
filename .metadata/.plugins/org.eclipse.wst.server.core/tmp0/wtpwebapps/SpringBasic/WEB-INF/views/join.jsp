<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 현재 위치 : http://localhost:8089/myapp/join 를 기준으로 -->
	<!-- 회원가입 : localhost:8089/myapp/member/join 으로 요청 -->
	<!-- "member/join" 현재위치를 기준으로 member(myapp)의 join으로 요청하겠다는 뜻 -->
	<form action="member/join" method="post">
     	ID : <input type="text" name="id"><br>
    	PASSWORD : <input type="password" name="pw"><br>
   	    NICKNAME : <input type="text" name="nickname"><br>
        <input type="submit" value="회원가입">
    </form>
</body>
</html>