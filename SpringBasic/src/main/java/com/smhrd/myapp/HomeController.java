package com.smhrd.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 컨트롤러 역할: 특정 경로로 요청이 왔을 때 메서드를 매핑해주는 역할 (요청 처리)
// 응답 : view를 리턴하는 역할

// model(데이터(위치,날씨 등) / view(화면)

// @RestController	// 데이터(model) 리턴 => ex) home이라는 문자열 자체를 리턴하겠다는 뜻(return "home";)
@Controller			// 화면(view) 리턴 => ex) home.jsp를 리턴하겠다는 뜻(return "home";)
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// [GET] localhost:8089/myapp/ => get방식으로 요청했을 대 이 주소를 실행하겠다는 뜻
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		// View Resolver : 뷰(클라이언트가 최종적으로 봐야하는 화면) 찾아주는 역할
//		servlet-context 파일에서
//		<beans:property name="prefix" value="/WEB-INF/views/" />
//		<beans:property name="suffix" value=".jsp" />
		
		//  /WEB-INF/views/home.jsp 를 찾아서 리턴하겠다는 뜻
		return "home";
	}
	
}
