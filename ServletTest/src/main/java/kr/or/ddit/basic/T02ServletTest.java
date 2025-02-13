package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class T02ServletTest extends HttpServlet {
/*
   서블릿(Servlet) 동작 방식에 대하여
   
    1. 사용자(클라이언트)가 URL을 클릭하면 HTTP 요청메세지를 서블릿 컨테이너로 전송한다.
    2. 서블릿 컨테이너 web.xml에 설정된 url패턴정보를 확인하여 어느 서블릿을 통해 처리 할지를 검색한다.
       (서블릿이 컨테이너에 로딩이 안 된 경우에는 먼저 생성하여 로딩 처리함. init()메서드도 호출 된다.)
    3. 서블릿 컨테이너는 요청을 처리할 개별 쓰레드를 생성하여 해당 서블릿 객체의 service()메서드를 호출한다.
       (HttpServletRequest 및 HttpServletResponse 객체를 생성하여 파라미터로 넘겨준다.)
    4. service() 메서드는 메서드 타입을 확인하여 적절한 메서드를 호출한다.(doGet, doPost, doPut, doDelete 등)
    5. 요청 처리가 완료되면, HttpServletResquest 및 HttpServletResponse 객체는 소멸 된다.
    6. 컨테이너로부터 서블릿이 제거되는 경우에 destroy() 메서드가 호출된다.
 */
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      // Request 객체의 메서드 확인하기
      System.out.println("getCharacterEncoding() : " + req.getCharacterEncoding());
      System.out.println("getContentLength() : " + req.getContentLength());
      System.out.println("getQueryString() : " + req.getQueryString());
      System.out.println("getProtocol() : " + req.getProtocol());
      System.out.println("getMethod() : " + req.getMethod());
      System.out.println("getRequestURI() : " + req.getRequestURI());
      System.out.println("getHeaderNames() : " + req.getHeaderNames());
      System.out.println("getRemoteAddr() : " + req.getRemoteAddr());
      System.out.println("getRemotePort() : " + req.getRemotePort());
      
      ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
      // 요청메세지로부터 name값 가져오기
      String name = req.getParameter("name");
      
      System.out.println("name : " + name);
      
      // 요청객체에 데이터 저장하기
      req.setAttribute("tel", "1234-5678");
      req.setAttribute("addr : ", "대전광역시 중구 오류동");
      
      // 요청객체에 저장된 데이터 꺼내오기
      System.out.println("tel => " + req.getAttribute("tel"));
      System.out.println("addr => " + req.getAttribute("addr"));
      
      ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
      // 응답 메세지 생성하기 위한 작업 시작
      
      // 응답 메세지의 컨텐츠 타입정보 설정
//      resp.setContentType("text/plain; charset=UTF-8");
      resp.setCharacterEncoding("UTF-8");
      resp.setContentType("text/plain");
      
      // 응답내용 작성하기
      PrintWriter out = resp.getWriter();
      
      out.println("name => " + name);
      out.println("서블릿 경로 : " + req.getServletPath());
      out.println("서블릿 컨텍스트 경로 : " + req.getContextPath());
      
      // 응답 메세지 생성하기 위한 작업 끝
   }
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      doGet(req, resp);
   }
}
