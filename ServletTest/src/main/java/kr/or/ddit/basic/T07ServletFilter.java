package kr.or.ddit.basic;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class T07ServletFilter implements Filter {

	/* 서블릿 필터에 대하여...
	 * 
	 * 1. 사용목적 
	 * - 클라이언트의 요청을 수행하기 전에 가로채 필요한 작업을 수행할 수 있다. 
	 * - 클라이언트의 응답매시지를 보내기 전에 응답에 필요한 작업을 수행할 수 있다.
	 * 
	 * 2. 사용 예 
	 * - 인증필터 
	 * - 데이터 압축필터 
	 * - 인코딩 필터 
	 * - 로깅 및 감사처리 필터 
	 * - 이미지 변환 필터 등 */

	@Override
	public void destroy() {
		// 필터객체가 컨테이너로부터 제거되기 전에 호출됨.
		System.out.println("[T07ServletFilter] destroy() 호출됨.");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("[T07ServletFilter] dofilter() 시작...");

		// 클라이언트의 IP 주소 가져오기
		String ipAddr = req.getRemoteAddr();

		System.out.println("IP주소 : " + ipAddr + "\n포트번호 : " 
						  + req.getRemotePort() + "\n현재 시간 : " + new Date().toString());

		// 필터 체인을 수행한다.(다음 필터를 수행한다.)
		chain.doFilter(req, resp);

		System.out.println("[T07ServletFilter] dofilter() 끝...");

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("[T07ServletFilter] init() 호출됨.");

		// 초기화 파라미터 정보 가져오기
		String initParam = filterConfig.getInitParameter("init-param");

		System.out.println("init-param : " + initParam);

	}

}
