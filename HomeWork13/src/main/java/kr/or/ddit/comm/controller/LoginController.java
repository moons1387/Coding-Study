package kr.or.ddit.comm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/views/login/loginForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memId = req.getParameter("memId");
		String memPass = req.getParameter("memPass");
		
		// 서비스 생성
		IMemberService memService = MemberServiceImpl.getInstance();
		
		MemberVO mv = memService.getMember(memId);
		
		boolean isAuthenticated = false; // 인증된 사용자인지 여부
		
		if(mv != null) {
			if(memPass.equals(mv.getMemPass()))
				isAuthenticated = true;
		}
		
		///////////////////////////////////////////////////////////////////////
		
		if(isAuthenticated) {
			// 세션에 로그인 정보 설정하기
			req.getSession().setAttribute("LOGIN_USER", mv);
			
			// 메인 페이지로 이동
			resp.sendRedirect(req.getContextPath()+"/main.do");
			
		} else { // 인증 실패시...
			// 로그인 화면으로 이동
			resp.sendRedirect(req.getContextPath()+"/login.do");
		}
	}
}
