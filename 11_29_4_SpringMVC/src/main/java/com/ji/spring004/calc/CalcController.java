package com.ji.spring004.calc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//	프로젝트 내에 새 패키지 만들 때 : top-level package 뒤에 추가할 것.


@Controller	// < 안 붙이면 컨트롤러 역할을 수행 불가.
public class CalcController {

		// 1. JSP Model 2 스타일
		// 요청 파라미터 : String > 형변환해서 사용.
	
	/*@RequestMapping(value = "/calculate.do", method = RequestMethod.POST)
	public String calcXY(HttpServletRequest req) {
		
		String name = req.getParameter("name");
		int x = Integer.parseInt(req.getParameter("x"));
		int y = Integer.parseInt(req.getParameter("y"));

		System.out.println(name+x+y+"POST방식 실행");
		return "index";
		
	}*/
	
		// 2. 옛날 Spring 스타일	> 		활용이 애매함 ...
	
	/*@RequestMapping(value = "/calculate.do", method = RequestMethod.POST)
	public String calcXY(@RequestParam(value="name") String name,
										@RequestParam(value="x") int x,
										@RequestParam(value="y") int y) {
		
		System.out.println(name);
		System.out.println(x);
		System.out.println(y);
		
		return "index";
	}*/
	
	@Autowired
	private CalcDAO cDAO;	//	servlet-context.xml에 등록된 CalcDAO객체와 자동으로 연결
	
	@RequestMapping(value = "/calculate.do", method = RequestMethod.POST)
	public String calcXY(Calculate cal,HttpServletRequest req) {
				//DAO에서 가져올 method의 parameter를 함께 넣어줌.
		cDAO.calculate(cal, req);
		cDAO.insertCount(cal, req);
		req.setAttribute("a_name", req.getParameter("name"));
		req.setAttribute("a_x", req.getParameter("x"));
		req.setAttribute("a_y", req.getParameter("y"));

		return "index";
	}
	
}
