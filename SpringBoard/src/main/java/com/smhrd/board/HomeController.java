package com.smhrd.board;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smhrd.board.model.Board;
import com.smhrd.board.service.BoardService;

@Controller
public class HomeController {
	
	@Autowired
	BoardService service;
	
	// localhost:8089/board/
	// value에는 localhost:8089/board 경로 뒤부터 써주는 것이다
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String boardList(Model model) {
		
		List<Board> list = service.boardList();
		
		// System.out.println(list.size()); 콘솔창에 게시물 개수 출력되는지만 확인
		
		model.addAttribute("list", list);
		// model.addAttribute("세션(키값)", 내가 지정한 변수명);
		
		return "boardlist";
	}
	
	// localhost:8089/board/form
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String boardForm() {
		return "boardform";
	}
}
