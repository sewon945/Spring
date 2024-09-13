<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
 
<div class="container">
  <h2>데이터디자인반 게시판😎😎</h2>
  <div class="panel panel-default">
    <div class="panel-heading">게시판</div>
    <div class="panel-body">
    
    	<!-- localhost:8089/board/form/write -->
    	<!-- action: 현재위치로부터 write로 요청한다는 뜻 -->
    	<!-- enctype 기본값 : application/x-www-form-urlencoded / 파일첨부 할 때는 multipart/form-data 로 인코팅 타입을 바꿔줘야함 -->
    	  <form action="form/write" method="post" enctype="multipart/form-data" class="form-horizontal">
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="title">제목:</label>
		      <div class="col-sm-10">
		      <!-- class의 필드와 같은 이름으로 name을 각각 맞춰줘야함 -->
		        <input type="text" name="title" class="form-control" id="title" placeholder="Enter title">
		      </div>
		    </div>
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="content">내용:</label>
		      <div class="col-sm-10">          
		        <textarea name="content" rows="10" class="form-control"></textarea>
		      </div>
		    </div>
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="writer">작성자:</label>
		      <div class="col-sm-10">          
		        <input type="text" name="writer" class="form-control">
		      </div>
		    </div>
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="photo">Photo:</label>
		      <div class="col-sm-10">         
		      <!-- 여기 name은 img로 하면 안돼서 그냥 photo로 지정해줌 --> 
		         <input type="file" name="photo" class="form-control" id="photo">
		      </div>
		     
		    </div>
		    <div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-success btn-default">작성</button>
		        <button type="reset" class="btn btn-warning btn-default">리셋</button>
		      </div>
		    </div>
		  </form>
    
    </div>
    <div class="panel-footer">데이터디자인 엔지니어 양성과정 (담임 : 강예진)</div>
  </div>
</div>
</body>
</html>
