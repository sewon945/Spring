package com.smhrd.myapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.smhrd.myapp.model.MavenMember;

@Mapper
public interface MemberMapper {

	// 회원가입 처리
	public int memberJoin(MavenMember member);
	
	
	// 로그인 처리 (메서드)
	// 인터페이스에서 result타입에 지정 해준 값을 그대로 void 자리에 넣어주기
	public MavenMember memberLogin(MavenMember member);
	
	
	// 회원정보수정 처리
	@Update("update mavenmember set pw=#{pw},nickname=#{nickname} where id=#{id}")
	public int memberUpdate(MavenMember member);
	
	
	// 회원삭제 처리
	@Delete("delete from mavenmember where id=#{id}") // {}가 하나만 있으면 {} 안에 아무것도 안적어도 됨 
	public int memberDelete(String id);
	
	
	// 회원 전체 리스트
	@Select("select * from mavenmember")
	public List<MavenMember> memberList();
}
