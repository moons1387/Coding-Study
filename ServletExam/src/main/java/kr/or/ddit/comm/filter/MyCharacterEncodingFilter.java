package kr.or.ddit.comm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyCharacterEncodingFilter implements Filter {

	private String encoding; // 인코딩방식
	
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		req.setCharacterEncoding(encoding);
		resp.setCharacterEncoding(encoding);
		
		chain.doFilter(req, resp);
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		if(filterConfig.getInitParameter("encoding") == null) { // 인코딩 정보가 존재하지 않으면...
			this.encoding = "UTF-8"; // 기본인코딩 설정하기
		} else {
			this.encoding = filterConfig.getInitParameter("encoding");
		}
		
		System.out.println("현재 설정된 인코딩 정보 : " + this.encoding);
		
	}

}
