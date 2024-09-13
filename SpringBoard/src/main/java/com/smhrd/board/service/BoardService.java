package com.smhrd.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.board.mapper.BoardMapper;
import com.smhrd.board.model.Board;

@Service   // 어너테이션? 이라고 부름
public class BoardService {

	@Autowired
	BoardMapper mapper;
	
	public int boardWrite(Board board) {
		return mapper.boardWrite(board);
	}
	
	public List<Board> boardList() {
		return mapper.boardList();
	}
	
	public Board boardContent(int idx) {
		return mapper.boardContent(idx);
	}
	
	public int boardDelete(int idx) {
		return mapper.boardDelete(idx);
	}
}



