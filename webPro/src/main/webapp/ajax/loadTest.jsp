<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String uId = request.getParameter("uId");
	String uPw = request.getParameter("uPw");

// 	System.out.println(uId +", "+ uPw);
	
	// JDBC 이용해서 DB정보 얻기
	// 1. 연결할 db가 존재해야함
	// 2. java와 db를 연결하기 위해 ojdbc.jar라이브러리 필요
	// 3. 드라이버 로딩
	Class.forName("oracle.jdbc.driver.OracleDriver");
	// 4. Connection 객체 생성
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection conn = DriverManager.getConnection(url, "pc18", "java");
	// 5. sql 구문 실행을 위한 Statement객체 생성
	Statement stmt = conn.createStatement();
	
	String sql = "SELECT MEM_ID FROM MYMEMBER WHERE MEM_ID = '"+uId+"' AND MEM_PASS = '"+uPw+"'";
	
	ResultSet rs = stmt.executeQuery(sql);
	
	if(rs.next()){
		// 정보 일치시 응답결과 생성
%>
		{"rst":"ok"}
<%
	} else {
		// 정보 불일치시 응답결과 생성
%>
		{"rst":"fail"}
<%
	} // if-else end
%>