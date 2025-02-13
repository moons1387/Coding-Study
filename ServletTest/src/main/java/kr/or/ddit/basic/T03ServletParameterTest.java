package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class T03ServletParameterTest extends HttpServlet {
   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      /*
            요청 객체로부터 파라미터 데이터 가져오는 방법
            
         - getParameter() : 파라미터값이 한개 인 경우...
         - getParameterValues() : 파라미터 값이 여러개인 경우... ex) checkbox 등.
         - getParameterNames() : 요청메시지에 존재하는 모든 파라미터 이름을 가져올 때 사용함.
      */
      
	   // POST방식으로 넘어오는 Body데이터를 가져올 때 적절한 인코딩 처리를 해야 한다.
	   // 반드시 값을 꺼내오기 전에 설정해야 한다.
	   
	   req.setCharacterEncoding("UTF-8");
	   
      String username = req.getParameter("username");
      String password = req.getParameter("password");
      String gender = req.getParameter("gender");
      String hobby = req.getParameter("hobby");
      String rlgn = req.getParameter("rlgn");
      
      String[] foods = req.getParameterValues("food");
      
      //////////////////////////////////////////////////
      
      resp.setCharacterEncoding("UTF-8");
      resp.setContentType("text/html");
      
      PrintWriter out = resp.getWriter();
      
      out.println("<!DOCTYPE html><head><title>파라미터 데이터</title></head>"
            + "<body>"
            + "<p>username : " + username + "</p>" 
            + "<p>password : " + password + "</p>" 
            + "<p>hobby : " + hobby + "</p>" 
            + "<p>gender : " + gender + "</p>" 
            + "<p>rlgn : " + rlgn + "</p>");
      if(foods != null) {
         for(String food : foods) {
            out.println("<p>food : " + food + "</p>");
         }
      }
      
      // 모든 파라미터 이름 정보 가져오기
      Enumeration<String> paramNames = req.getParameterNames();
      while(paramNames.hasMoreElements()) {
         String paramName = paramNames.nextElement();
         out.print("<p>파라미터 이름 : " + paramName + "</p>"); 
      }
      
      out.print("</body></html>");
   }
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      doGet(req, resp);
   }

}
