package com.ji.spring004;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//	JSP Model 2
//		http://IP:PORT/프로젝트명/컨트롤러명
//		C : Servlet
//		상황판단 > 흐름 제어
//		doGet(), doPost() 메소드를 활용
//		주소에 컨트롤러 파일명, 컨트롤러 하나당 GET하나, POST 하나
//		>	컨트롤러의 수가 많아진다.

//	Spring
//		http://IP:PORT/top-level package의 마지막자리/임의대로 지정한 값
//		C : 일반 클래스
//			 일반 메소드
//			 컨트롤러 하나에 여러개의 요청 처리가 가능.
//			 > 컨트롤의 수는 최소화(패키지 당 하나 정도)

@Controller
public class HomeController {
	
	// 사이트 첫 접속시 Method : GET방식
	//	value에는 아무것도 쓰지 않은 상태
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {	// String 자료형이 기본
		
		return "index";	// index.jsp로 포워딩
		
	}
	
	// haha.test라는 주소로 GET방식 요청이 들어오면
	//	index.jsp로 포워딩(이동)해주는 메소드
	@RequestMapping(value = "/haha.test", method = RequestMethod.GET)
	public String testHaha() {
		
		return "index";
		
	}
	
	@RequestMapping(value = "/HomeController", method = RequestMethod.GET)
	public String backhome(HttpServletRequest req) {
		
		String name = req.getParameter("name");
		BigDecimal x = new BigDecimal(req.getParameter("x"));
		BigDecimal y = new BigDecimal(req.getParameter("y"));
		
		req.setAttribute("a_name", name);
		req.setAttribute("a_x", x);
		req.setAttribute("a_y", y);
		
		System.out.println("GET방식 실행");
		System.out.println("이름 : "+name);
		System.out.println("x : "+x);
		System.out.println("x : "+y);
		
		return "index";
		
	}
	
}
