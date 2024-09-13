function loadList() {
		// 게시물 전체 데이터 요청하는 함수
		$.ajax({
			url:"list", // 요청경로 (,은 속성들 구분할 때 쓰는 것)
			type:"get", // 요청방식(get/post)
			dataType:"json", // 서버에서 반환받는 데이터 형식 (json형태로 바꾼다고 지정해주는 것)
//			success : function(data){ // 성공했을 때, ()-> 서버에서 응답해준 값을 변수명으로 지정해주기
//				console.log(data)},

			// 아래 내가 적어둔 함수 불러와야함
			success : listView,
			
			error : function() {
				alert("통신 실패")
			}
		})
	}
	
	function listView(data) { // 위에서 성공했을 때 화면에 가지고 올 수 있도록 해주는 것
		// 테이블 구조(텍스트)로 게시물 데이터 출력
		//<tbody id="list">여기 사이에 추가할 내용 써주는 것</tbody>
		var result=""
		var cnt = 1 	// 화면에 출력되는 게시물 실제 번호 (인덱스X)
		// JAVA의 foreach문 - JAVA 배열과 똑같음
	      $.each(data, (index,vo)=> { //data : boardlist / vo : Board(배열안에서 각각 꺼내온 게시물 ex. 0번, 1번 게시물 등)
	         result += "<tr>";
	         result += "<td>"+ cnt++ +"</td>";
	         // 문자열 + 변수의 인덱스(.idx) - 컨텐츠 가지고 오고 싶으면 변수명.content
	         result += "<td><a href='board/content/" + vo.idx+"'>"+vo.title+"</a></td>";
	         result += "<td>"+vo.writer+"</td>";
	         result += "<td>"+vo.indate+"</td>";
	         result += "<td><button class='btn btn-warning btn-sm' onclick='goDelete("+vo.idx+")'>삭제</button></td>"
	         result += "</tr>";
	      })
	      // 아이디가 list인 => <tbody id="list">
	      // html을 쓴 이유 tr태그처럼 태그 역할을 해야하니까 .html()불러오기 , 텍스트 역할을 하고 싶을 때에는 .text()
	      $('#list').html(result)
	}
	
	function goDelete(idx) {
		$.ajax({
			// delete/1 , delete/2 ...
			url:"delete/" + idx,
			type:"get",
			// f12 콘솔에 띄워서 확인만 한 번 하기
//			success:function(data) {
//				console.log(data)},
				
			// 삭제한 거 제외해서 화면에 출력됨
			success:loadList,
			
			error:function() {
				alert("삭제 실패")
			}
		})
	}