<%@page import="com.smhrd.myapp.model.MavenMember"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% MavenMember member = (MavenMember)session.getAttribute("member"); %>
	
	<% if(member == null) { %>
<!-- PageController에서 join으로 리턴해서 요청한다고 했으니까 .jsp는 빼기 -->
	<a href="join"><button>회원가입</button></a> 
	<a href="login"><button>로그인</button></a>
	
	<%} else { %>
		<%=member.getNickname() %><br>
		<a href="update"><button>회원정보수정</button></a>
		<!-- 쿼리스트림? 방식 : get 방식? --> 
		<a href="member/delete?id=<%=member.getId()%>"><button>회원탈퇴</button></a> 
		
		<!-- admin(아이디) 계정(관리자계정)으로 로그인 시 회원 전체 리스트를 볼 수 있는 버튼 추가 -->
		<%if(member.getId().equals("admin")) {%>
		<a href="member/list"><button>회원전체리스트</button></a>
		<%} %>
		
		<a href="member/logout"><button>로그아웃</button></a>
	<%} %>
</body>
</html>