package kr.or.ddit.basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class T09SessionListenerTest extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// HttpSession 객체 생성하기
		HttpSession httpSession = req.getSession();
		
		// 세션에 데이터 저장 및 수정, 삭제 하기...
		httpSession.setAttribute("ATTR1", "속성1");
		httpSession.setAttribute("ATTR1", "속성11");
		httpSession.setAttribute("ATTR2", "속성2");
		httpSession.removeAttribute("ATTR1");
		
		// 세션 삭제하기
		httpSession.invalidate();
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
