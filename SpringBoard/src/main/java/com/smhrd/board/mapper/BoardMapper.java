package com.smhrd.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.smhrd.board.model.Board;

@Mapper
public interface BoardMapper {
	
	// insert, delete, update => 반환타입 int
	public int boardWrite(Board board);
	
	
	@Select("select * from board")   // board테이블에 있는 거 싹 다 가져오기
	public List<Board> boardList();	// 반환타입으로 List<> 적어주기
	
	
	public Board boardContent(int idx);   // mapper.xml에 작성해줌
	
	@Delete("delete from board where idx=#{idx}")
	public int boardDelete(int idx); // 삭제
	
}
