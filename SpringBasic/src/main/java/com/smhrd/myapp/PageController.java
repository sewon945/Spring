package com.smhrd.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// @Controller: 요청 파라미터 받아주기, 뷰(결과페이지) 리턴해주는 역할
@Controller
public class PageController {
	
	// index 페이지를 리턴해주는 메서드
	// index 페이지를 볼 수 있는 기본 경로
	// localhost:8089/myapp/index
	@RequestMapping(value="/index", method=RequestMethod.GET)   // value에 슬래시만 적으면 myapp까지의 경로만 설정됨
	public String index() {
		// view resolver : /WEB-INF/views/index.jsp
		return "index";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "join";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	//localhost:8089/myapp/update
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update() {
	   return "update";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list() {
		return "list";
	}
	
}
