package com.smhrd.myapp;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.smhrd.myapp.model.MavenMember;
import com.smhrd.myapp.service.MemberService;

@Controller		// 반환타입 : String으로 생각하기
public class MemberController {
	
	@Autowired   // 의존성주입
	MemberService service;	// 형태 정의해서 변수 써준 것
	

	// 회원가입 요청 처리 : localhost:8089/myapp/member/join 으로 왔을 때 저 메서드 호출하겠다는 뜻
	@RequestMapping(value="/member/join", method=RequestMethod.POST)
	public String memberJoin(@RequestParam("id")String id   // String id = request.getParameter("id");
						   , @RequestParam("pw") String pw
						   , @RequestParam("nickname") String nickname) {
		// String id = request.getParameter("id");
		System.out.println(id + "," + pw + "," + nickname);
		
		// DB까지 데이터가 들어가기 위해서는
		// controller -> service -> mapper
		// controller : 요청 파라미터를 받고 마지막에 뷰리턴 하는 역할
		// service : controller에 작성되는 코드 외에 로직들 작성 (없어도 되고 있어도 됨-대신 있으면 가공해서 보낼 수 있음)
		// mapper : 실제 DB 관련 작업
		
		MavenMember member = new MavenMember(id, pw, nickname);
		int res = service.memberJoin(member);
		
		System.out.println(res);
		
		// 포워딩 방식
		if(res > 0) { // 성공
			// index.jsp 페이지로 이동
			// return "index"; => 포워딩 방식으로 이동되면서 잘못된 주소로 결과물 리턴됨 (주소창에 join으로 뜸)
			// index 페이지를 보여주는 경로로 클라이언트가 재요청하게 만들기! (리다이렉팅 방식)
			return "redirect:/index";
		} else { // 실패
			// join.jsp 으로 이동
			return "redirect:/join";
		}
		
		
	}
	
	// 로그인 요청 처리 : localhost:8089/myapp/member/login
	@RequestMapping(value="/member/login", method=RequestMethod.POST)
	public String memberLogin(@RequestParam("id")String id,	// login.jsp 파일에 있는 name 적기
							  @RequestParam("pw")String pw,
							  HttpSession session) { // session 객체가 없으니 하나 만들어주기
		// System.out.println(id + "," + pw);  로그인이나 회원가입에서 입력한 값 콘솔에 뜨는 지 확인만 하기
		
		MavenMember member = new MavenMember(id,pw);
		
		// mapper인터페이스 파일에서 void에 쓴 값 적기? 이건 왜 적었을까
		MavenMember result = service.memberLogin(member);
		
		// 로그인 성공했을 때 index.jsp 페이지(회원가입,로그인 버튼)로 다시 돌아감
		// HttpSession session = request.getSession();
		if(result != null) {
			System.out.println("로그인 성공");
			session.setAttribute("member", result);
			// forwarding 방식 (이동) : 최종 페이지의 경로 확인X(어색), 추후 페이지 이동 시에 문제 발생 가능성O
			// return "index";
			// 주소창에 http://localhost:8089/myapp/member/login 경로 이렇게 뜸
			
			// redirection 방식 : 클라이언트가 해당 경로로 재요청하게 만듦
			// 			index를 보여주는 경로로 재요청
			return "redirect:/index";
			// 주소창에 http://localhost:8089/myapp/index 경로 이렇게 뜸
		} else { // null
			System.out.println("로그인 실패");
			return "redirect:/login";
		}
	}
	// 로그아웃이 되면 다시 index.jsp 페이지로 돌아옴
	// 로그아웃 요청 처리 : localhost:8089/myapp/member/logout
	@RequestMapping(value="/member/logout" , method=RequestMethod.GET)
	public String memberLogout(HttpSession session) {
		session.removeAttribute("member");
		return "redirect:/index";  // 반환타입 void를 String으로 바꿔주기
	}
	
	// 회원정보수정(update.jsp)
	// RequestMapping , RequestParam
	// session 안에서 현재 로그인한 사용자의 아이디만 가져와서 활용 - 비번이랑 닉넴만 새롭게 수정(아이디 수정X)
	@RequestMapping(value="/member/update" , method=RequestMethod.POST)
	public String memberUpdate(@ModelAttribute MavenMember member
								, HttpSession session) {
		// id, pw, nickname 보낼 거임 => 한 회원의 정보 (MavenMember 타입으로 묶어주기)
		// RequestParam => 파라미터 하나하나 가졍는 방법
		// ModelAttirbute => 특정한 Model 형태로 파라미터를 묶어서 가져오는 방법
		// 			=> 사용한 Model Class : 기본생성자, Setter 생성해서 초기화 해줘야함

//		System.out.println(member.getId());
//		System.out.println(member.getPw());
//		System.out.println(member.getNickname());
		
		int res = service.memberUpdate(member);
		
		System.out.println(res);
		
		if(res > 0) {
			// 수정 성공
			// member 세션을 수정한 값을 저장하도록 변경(새롭게 생성)
			session.setAttribute("member", member);
			return "redirect:/index";
		} else {
			return "redirect:/update";
		}
	}
	
	// 회원탈퇴
	@RequestMapping(value="/member/delete", method=RequestMethod.GET)
	public String memberDelete(@RequestParam("id") String id	// index.jsp 파일의 키값을 가져와서 쓰기
							, HttpSession session) { 
		
		int res = service.memberDelete(id); 
		
		// 성공이든 실패든 index 페이지로 이동
		// 성공 - 로그인이 풀리게 (세션 다루기)
		// 실패 - 로그인 상태 유지 (세션)
		if(res > 0) { // 탈퇴 성공
			session.removeAttribute("member");
		}
		
		return "redirect:/index";	
	}
	
	
	@RequestMapping(value="/member/delete/{id}", method=RequestMethod.GET)
	public String memberDelete(@PathVariable("id") String id) { 

		int res = service.memberDelete(id); 
		
		// list.jsp 삭제 링크를 누르면 해당 회원을 DB에서 삭제해주고 다시 list.jsp로 이동
		// => 삭제한 회원은 리스트에서 보이지 않아야한다
		
		return "redirect:/member/list";	
	}
	
	
	@RequestMapping(value="/member/list", method=RequestMethod.GET)
	public String memberList(Model model) { // 넘겨줄 파라미터가 없기에 () 비워주기
	
		List<MavenMember> list = service.memberList();
		// 리스트 저장(리다이렉팅 이동) => 세션(서버 용량 차지)에 저장하면? => 불필요하게 용량을 많이 차치	
		// return "redirect:/list";  가능 => 대신, 서버에 용량 차지함
		
		// 포워딩 (현재 사용하는 request, response를 다음 페이지에서도 사용할 수 있도록 해줌)
		// 세션 에 안쓴다고 했으니까 => / 리퀘스트 영역
		
		// 스프링에서 데이터를 임시적으로 저장할 때 사용하는 객체
		//		request와 같은 역할을 하는 객체 (Model 객체 사용)
		// Model : 임시적으로 다음 페이지에서만 사용할 데이터를 넘기고(저장하고) 싶을 때
		model.addAttribute("list", list);
		return "list";
		
	}
	

}
