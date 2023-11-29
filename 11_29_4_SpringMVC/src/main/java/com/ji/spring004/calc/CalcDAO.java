package com.ji.spring004.calc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

//	멤버변수 없으면 : static method 기반
//		M/DAO에서 게시판 같은 기능 구현을 하려면, 멤버 변수가 생길 수 밖에 없음.
//			> static 기반 method 포기 > 객체를 만들어서 사용해야 함.
//			> 새로고침 or 요청 > 새 객체가 계속 요청되고 요청시마다 DAO가 계속 생성됨.
//			> 메모리 계속 사용해서 비효율적
//			> 밑에 써놓은 allCalcCount도 제대로 카운팅이 되지 않는다.

//	해결방안 : CalcDAO를 Singleton 처리

//	Spring 식의 Singleton 처리 방법 (@Service)

//DAO는 Service 필수. servlet-context.xml에 CalcDAO 객체를 등록한 효과를 냄.
@Service
public class CalcDAO {
	
	private int allCalcCount;
	
	public void calculate(Calculate cal, HttpServletRequest req) {
		
		allCalcCount++;
		System.out.println(allCalcCount);
		int add = cal.getX() + cal.getY();
		req.setAttribute("r", add);
		
	}
	
	public void insertCount(Calculate cal,HttpServletRequest req) {
		
		req.setAttribute("a_count", allCalcCount);
		
	}

}
