<%@page import="com.smhrd.myapp.model.MavenMember"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <%MavenMember member = (MavenMember)session.getAttribute("member"); --%>
	<!-- 현재 경로 : localhost:8089/myapp/update -->
	<!-- 요청 경로 : localhost:8089/myapp/member/update -->
	<!-- REST API : get/post - 폼태그에서는 이 두개만 가능, delete/patch/update - 요청메서드 -->
	<form action="member/update" method="post">
					<!-- value로 기본값 주기 value="< %=member.getId()%>" , readonly : 읽기만 가능(수정X)-->
     	ID : <input type="text" name="id" value="${member.id }" readonly><br>
     	<!-- id type을 hidden으로 해도 됨-->
    	PASSWORD : <input type="password" name="pw"><br>
   	    NICKNAME : <input type="text" name="nickname" value="${member.nickname }"><br>
        <input type="submit" value="회원가입">
    </form>
</body>
</html>