<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 지시자 추가해준 것 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <!-- jquery가 있기에 $(jquery)를 쓸 수 있는 거임 => 없을 땐 아랫줄 적어주기 -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body><!-- model 저장되어 있는 값을 jsp에서 꺼내 쓸 때는 request에서 가져와야함 -->
<!-- request영역을 사용할 거면 el표기법 -->
<div class="container">
  <h2>데이터디자인반 게시판😎😎</h2>
  <div class="panel panel-default">
    <div class="panel-heading">게시판</div>
    <div class="panel-body">
    	  <table class="table table-bordered">
		    <thead>
		      <tr>
		        <th>번호</th>
		        <th>제목</th>
		        <th>작성자</th>
		        <th>작성일</th>
		      </tr>
		    </thead>
		    <tbody>
			  <!--게시물 리스트 출력-->
			  <!-- var: 각각의 board객체를 b라고 지정, c:forEach: 자바에서 for문 -->
			  <c:forEach var="b" items="${list }">
				  <tr>
				  	<td>${b.idx }</td>
				  	<!-- 1) board/content?idx=게시물번호 => @RequestParam, @ModelAttribute -->
				  	<!-- 2) board/content/게시물번호(표현식,el표기법) => @PathVariable -->
				  	<td><a href="content/${b.idx }">${b.title }</a></td>
				  	<!-- 이걸 설정했을 때 주소가 board/content/1 이렇게 뜸 -->
				  	<td>${b.writer }</td>
				  	<td>${b.indate }</td>
				  </tr>
			  </c:forEach>
			  
		      <tr>
		      	<td colspan="4">
		      	<!-- btn: 버튼, btn-sm: 버튼크기?, btn-success: 버튼색, onclick:클릭할 수 있게, location.href: 이건 뭘까..? -->
		      		<button class="btn btn-sm btn-success" onclick="location.href='form'">글작성</button>
		      	</td>
		      </tr>
		    </tbody>
		  </table>
    
    </div>
    <div class="panel-body">
    	  <table class="table table-bordered">
		    <thead>
		      <tr>
		        <th>번호</th>
		        <th>제목</th>
		        <th>작성자</th>
		        <th>작성일</th>
		      </tr>
		    </thead>
		    <tbody id="list">
		    
			</tbody>  
		  </table>
    
    </div>
    <div class="panel-footer">데이터디자인 엔지니어 양성과정 (담임 : 강예진)</div>
  </div>
</div>

<!-- script는 오타를 표시해주지 않아서 잘 확인하기 -->
<!-- 동기 통신 : http://localhost:8089/board/ 브라우저 보는 것? -->
<!-- 비동기 통신 : f12에서 보는 것? -->
<!-- JavaScript 형식 -->
<script src="resources/static/js/main.js"></script>
<script>
// F12 => Network => list => Request URL 보기

	// boardlist.jsp가 로딩이 되었을 때(화면이 출력되었을 때, 화면이 보일 때)
	// loadList() 함수를 바로 실행하는 방법
	// document : 
		// 화면이 준비가 되면 내가 특정 함수로 실행하겠다
	$(document).ready(function() {
		loadList()
	})
	
	// src -> main -> webapp -> resources -> static -> js -> main.js에 
	// 써져 있는 세 함수를 원래는 여기 안에 적었음 => 위에서 script 따로 다시 써서 경로 지정해줌
</script>

</body>
</html>
