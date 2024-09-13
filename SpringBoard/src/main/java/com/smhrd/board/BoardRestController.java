package com.smhrd.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smhrd.board.model.Board;
import com.smhrd.board.service.BoardService;

// @Controller : view 반환 (화면전환) => 비동기통신이 안됨 => 동기통신
// Spring3 => 비동기통신 @Controller + @ResponseBody (data만 반환)
// Spring4 => 비동기통신 @RestController (data 반환)
@Controller
public class BoardRestController {
	
	// service 기능 호출
	@Autowired
	BoardService service;

	//f12->network->list에서 경로 board 뒤를 써줘야해서 value에 /list 써주기
	// 응답받는 데이터에 대한 인코딩 방식 지정해준 것(produces = "application/text; charset=UTF-8") - 서블릿과 비슷
	@RequestMapping(value="/list", method=RequestMethod.GET, produces = "application/text; charset=UTF-8")
	public @ResponseBody String boardList() throws JsonProcessingException {
		// 테이블 전체 정보 리턴하기 => homecontroller에 있음
		List<Board> list = service.boardList();
		// List<Board> => JAVA 형식
		
		// ** 요청이 들어오면 게시물 정보를 가지고 있는 list 데이터를 응답해줘야함 (xml, *json* {key:value} 형태)
		// JAVA 객체 -> JSON 형태의 문자열로 변환해줘야함 => Jackson 라이브러리 사용
		
		// 도구생성
		ObjectMapper om = new ObjectMapper();
		String jsonString = om.writeValueAsString(list); // 특정한 value 형태인 ObjectMapper를 json 형태로 바꿔주는 것
		
		return jsonString;
		// 위에 public에 @ResponseBody String 적어줘야 jsonString 타입으로 리턴하겠다는 뜻 
	}
	
	@RequestMapping(value="/delete/{idx}", method=RequestMethod.GET)
	public @ResponseBody String delete(@PathVariable("idx") int idx) {
		
		int res = service.boardDelete(idx);
		
		if(res > 0) {
			return "success";
		} else {
			return "fail";
		}
	}
}
