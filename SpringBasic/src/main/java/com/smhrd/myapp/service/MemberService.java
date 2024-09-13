package com.smhrd.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.myapp.mapper.MemberMapper;
import com.smhrd.myapp.model.MavenMember;

@Service
public class MemberService {
	
	@Autowired // 의존성주입 : MemberMapper 외부에서 객체 생성해서 가져다가 쓰겠다는 뜻
	MemberMapper mapper;
	
	// 회원가입 처리
	public int memberJoin(MavenMember member) {
		return mapper.memberJoin(member);
	}
	
	// 로그인 처리 메서드
	// mapper인터페이스에서 result타입에 지정 해준 값을 그대로 void 자리에 넣어주고 리턴하기
	public MavenMember memberLogin(MavenMember member) {
		return mapper.memberLogin(member);
	}
	
	// 회원정보수정 처리
	public int memberUpdate(MavenMember member) {
		return mapper.memberUpdate(member);
	}

	// 회원정보삭제 처리
	public int memberDelete(String id) {
		return mapper.memberDelete(id);
	}
	
	// 회원전체리스트 처리
	public List<MavenMember> memberList() {
		return mapper.memberList();
	}
}
