package com.smhrd.board;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.smhrd.board.converter.ImageToBase64;
import com.smhrd.board.model.Board;
import com.smhrd.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService service;
	
	@RequestMapping(value="/form/write", method=RequestMethod.POST)
	public String boardWrite(@ModelAttribute Board board
						 , @RequestPart("photo") MultipartFile file) throws IllegalStateException, IOException {
		
//		Board b = new Board();
//		b.setTitle("테스트");
//		b.setWriter("테스트");
//		b.setContent("테스트");
//		b.setIdx(0); 	// auto_increment
		// img => 값을 보내지 않아서 => null값
		// indate => 값을 보내지 않아서 => null값 / now() 현재 시간
		
//		System.out.println(board.getWriter());
//		System.out.println(board.getTitle());
//		System.out.println(board.getContent());
//		System.out.println(file.getOriginalFilename()); // 실제 파일 이름
		
		String uploadFolder = "C://img";
		
		// UUID : 랜덤 문자열 생성 (겹치지 않도록)
		// UUID.randomUUID().toString() : 랜덤으로 생성된 문자열
		String fileName = UUID.randomUUID().toString()+file.getOriginalFilename();
		
		// file.transferTo(); 내가 지정한 경로에 파일 저장 가능
		// new File(파일경로, 파일이름)
		file.transferTo(new File(uploadFolder, fileName)); 
		// 위에 있는 throws IllegalStateException, IOException { => 예외처리
		
		// 파일 이름 수정
		board.setImg(fileName);
		
		int res = service.boardWrite(board);
		
		if(res > 0) {
			// System.out.println("성공");
			return "redirect:/";
		} else {
			// System.out.println("실패");
			return "redirect:/form";
		}
	}
	
	@RequestMapping(value="/content/{idx}", method=RequestMethod.GET)
	public String boardContent(@PathVariable("idx") int idx
							, Model model) throws IOException {
		// converter.convert(imgFile) 예외처리 해줘서 throws IOException 생김
		System.out.println(idx); // 인덱스 번호 출력
		
		Board board = service.boardContent(idx);
		
//		  System.out.println(board.getIdx());
//	      System.out.println(board.getTitle());
//	      System.out.println(board.getContent());
//	      System.out.println(board.getWriter());
//	      System.out.println(board.getIndate());
//	      System.out.println(board.getImg());
		
		// 1. img => 제목 ~~> C://img 폴더 안에서 해당 제목을 가진 파일 가져오기
		// 2. Base64 인코딩 방식 (이미지 -> 텍스트 , 텍스트 -> 이미지)
		
		// 실제 이미지 경로에 있는 이미지 제목까지 가져온 것(경로지정한 걸 알기위해 역슬레시로 해주기)
		String imgPath = "C:\\img\\" + board.getImg();  
		File imgFile = new File(imgPath);
		// img를 문자열로 인코딩하는 방법이 base64임=> 문자열로 인코딩하고 있음
		ImageToBase64 converter = new ImageToBase64();
		String imgBase64String = converter.convert(imgFile);
		// converter.convert(imgFile) => 예외처리 해주기
		
		// 이미지가 콘솔창에 문자열로 띄워지는 지 확인하기
		// System.out.println(imgBase64String);
		
		// 브라우저에서도 문자열로 띄워지게끔 해주는 것??
		board.setImg(imgBase64String);
		// 위 public에서 , Model model 적어준 다음 써주기 
		model.addAttribute("board", board);
		// 비동기통신 : 데이터(board)만 리턴?
		return "boardcontent";
		
	}
	
}
